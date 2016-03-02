package edu.luc.etl.cs313.android.shapes.model;
import java.util.List;
import java.util.Iterator;

public class BoundingBox implements Visitor<Location> {


	@Override
	public Location onCircle(final Circle c) {
		final int radius = c.getRadius();
		return new Location(-radius, -radius, new Rectangle(2 * radius, 2 * radius));
	}

	@Override
	public Location onFill(final Fill f) {
		Location location;
		final Shape shape = f.getShape();
        location = shape.accept(this);
		return location;
	}

	@Override
	public Location onGroup(final Group g) {
        final Iterator<? extends Shape> it = g.getShapes().iterator();
        int currentMaxX = 0;
        int currentMaxY = 0;
        int currentMinX = Integer.MAX_VALUE;
        int currentMinY = Integer.MAX_VALUE;

        while (it.hasNext()) {
            final Location l = it.next().accept(this);
            int x = l.getX();
            int y = l.getY();
            int xPlusWidth = x;
            int yPlusHeight = y;
            if (l.getShape() instanceof Rectangle)
            {
                xPlusWidth += ((Rectangle) l.getShape()).getWidth();
            }
            if(l.getShape() instanceof Rectangle)
            {
                yPlusHeight += ((Rectangle) l.getShape()).getHeight();
            }
            if (currentMaxX <= xPlusWidth) {
                currentMaxX = xPlusWidth;
            }
            if (currentMaxY <= yPlusHeight)
            {
                currentMaxY = yPlusHeight;
            }
            if (currentMinX >= x)
            {
                currentMinX = x;
            }
            if (currentMinY >= y) {
                currentMinY = y;
            }
        }
        return new Location(currentMinX, currentMinY, new Rectangle((currentMaxX - currentMinX),
                (currentMaxY - currentMinY)));
    }
	@Override
	public Location onLocation(final Location l) {
        final Location loc = l.getShape().accept(this);
        final int x = l.getX() + loc.getX();
        final int y = l.getY() + loc.getY();
        return new Location(x,y,loc.getShape());
	}

	@Override
	public Location onRectangle(final Rectangle r) {
		final int width = r.getWidth();
        final int height = r.getHeight();
        return new Location(0,0, new Rectangle(width, height));
	}

	@Override
	public Location onStroke(final Stroke c) {
        Location location;
        final Shape shape = c.getShape();
        location = shape.accept(this);
        return location;
	}

	@Override
	public Location onOutline(final Outline o) {
        Location location;
        final Shape shape = o.getShape();
        location = shape.accept(this);
        return location;
	}

	@Override
	public Location onPolygon(final Polygon s) {
        List<? extends Point> points = s.getPoints();
        Point point;
        int biggerX = 0, biggerY=0, smallerX=0, smallerY=0;
        int x,y,width,height,firstX,firstY;
        firstX = points.get(0).getY();
        firstY = points.get(0).getY();
        smallerX = firstX;
        smallerY = firstY;
        biggerX=firstX;
        biggerY=firstY;
        for(int i=0; i<points.size(); i++){
            point = points.get(i);
            x=point.getX();
            y=point.getY();
            if(x>biggerX)
            {
                biggerX = x;
            }
            if(y>biggerY)
            {
                biggerY = y;
            }
        }
    width = biggerX - smallerX;
    height = biggerY - smallerY;
    return new Location(firstX, firstY, new Rectangle(width, height));
	}
}
