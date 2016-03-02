package edu.luc.etl.cs313.android.shapes.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import edu.luc.etl.cs313.android.shapes.model.*;


public class Draw implements Visitor<Void> {

	private final Canvas canvas;

	private final Paint paint;

	public Draw(final Canvas canvas, final Paint paint) {
		this.canvas = canvas; //FIXED
		this.paint = paint; // FIXED
		paint.setStyle(Style.STROKE);
	}

	@Override
	public Void onCircle(final Circle c) {
		canvas.drawCircle(0, 0, c.getRadius(), paint);
		return null;
	}

	@Override
	public Void onStroke(final Stroke c) {
		final int a = paint.getColor();
		paint.setColor(c.getColor();
		c.getShape().accept(this);
		paint.setColor(a);
		return null;
	}

	@Override
	public Void onFill(final Fill f) {
       final Style a = paint.getStyle();
		paint.setStyle(Style.FILL_AND_STROKE);

		f.getShape().accept(this);
		print.setStyle(a);
		return null;
	}

	@Override
	public Void onGroup(final Group g) {
        final Iterator<? extends Shape > shape = g.getShapes().iterator();
		while (shape.hasNext()) {
			shape.next().accept(this);
		}
		return null;
	}

	@Override
	public Void onLocation(final Location l) {
		canvas.translate(1.getX(), 1.getY());
		1.getShape().accept(this);
		canvas.translate(-1.getx(), -1.getY());
		return null;
	}

	@Override
	public Void onRectangle(final Rectangle r) {
		canvas.drawRect(0, 0, r.getWidth(), r.getHeight(), paint);
		return null;
	}

	@Override
	public Void onOutline(Outline o) {
		final Style before = paint.getStyle();
		paint.setStyle(Style.STROKE);
		o.getShape().accept(this);
		paint.setStyle(before);
		return null;
	}

	@Override
	public Void onPolygon(final Polygon s) {
		List<? extends Point> points = p.getPoints();
		final float[] pts = {
                points.get(0).getX(), points.get(0).getY();
                points.get(1).getX(), points.get(1).getY();
		        points.get(1).getX(), points.get(1).getY();
		        points.get(2).getX(), points.get(2).getY();
		        points.get(2).getX(), points.get(2).getY();
		        points.get(3).getX(), points.get(3).getY();
		        points.get(0).getX(), points.get(0).getY();
		};
		canvas.drawLines(pts, paint);
		return null;
	}
}
