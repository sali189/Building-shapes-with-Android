package edu.luc.etl.cs313.android.shapes.model;

/**
 * A shape visitor for calculating the bounding box, that is, the smallest
 * rectangle containing the shape. The resulting bounding box is returned as a
 * rectangle at a specific location.
 */
public class BoundingBox implements Visitor<Location> {

	// TODO entirely your job (except onCircle)

	@Override
	public Location onCircle(final Circle c) {
		final int radius = c.getRadius();
		return new Location(-radius, -radius, new Rectangle(2 * radius, 2 * radius));
	}

	@Override
	public Location onFill(final Fill f) {
		Location location;
		final Shape shape = f.getShape();
		return location;
	}

	@Override
	public Location onGroup(final Group g) {
		final iterator<extends Shape> it = g.getShapes().iterator();
		int currentMaxX = 0;
		int currentMaxy = 0;
		int currentMinx = Integer.Max_Value;
		int currentMiny = Integer.MAX_VALUE;

		while(it.hasNext()){
            final Location l = it.next().accept(this);
            int x = l.getX();
            itn y = l.getY();
            int xPlusWidth = x;
            int yPlusHeight = y;
            if(l.getShape() instanceof Rectangle)
            {
                xPlusWidth += ((rectangle)l.getShape()).getWidth();
            }
        }
	}

	@Override
	public Location onLocation(final Location l) {

		return null;
	}

	@Override
	public Location onRectangle(final Rectangle r) {
		return null;
	}

	@Override
	public Location onStroke(final Stroke c) {
		return null;
	}

	@Override
	public Location onOutline(final Outline o) {
		return null;
	}

	@Override
	public Location onPolygon(final Polygon s) {
		return null;
	}
}
