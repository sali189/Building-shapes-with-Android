package edu.luc.etl.cs313.android.shapes.model;
import java.util.Iterator;


public class Size implements Visitor<Integer> {
	@Override
	public Integer onPolygon(final Polygon p) {
		return 1;
	}

	@Override
	public Integer onCircle(final Circle c) {
		return 1;
	}

	@Override
	public Integer onGroup(final Group g) {
		int size = 0;
		final Iterator<? extends Shape> shape = g.getShapes().iterator();
		while(shape.hasNext()){
			size = size + shape.next().accept(this);

		}
		return size;
	}

	@Override
	public Integer onRectangle(final Rectangle q) {
		return 1;
	}

	@Override
	public Integer onOutline(final Outline o) {
		return o.getShape().accept(this);
	}

	@Override
	public Integer onFill(final Fill c) {
		return c.getShape().accept(this);
	}

	@Override
	public Integer onLocation(final Location l) {
		return l.getShape().accept(this);
	}

	@Override
	public Integer onStroke(final Stroke c) {
		return c.getShape().accept(this);
	}
}
