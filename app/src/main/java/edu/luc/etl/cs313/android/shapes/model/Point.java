package edu.luc.etl.cs313.android.shapes.model;

public class Point extends Location {


	public Point(final int x, final int y) {
		super(x, y, new Circle((0)));
		assert x >= 0;
		assert y >= 0;
	}
}
