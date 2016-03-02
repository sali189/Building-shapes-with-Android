package edu.luc.etl.cs313.android.shapes.model;

public class Stroke implements Shape {
	final int color;
	final Shape shape;


	public Stroke(final int color, final Shape shape) {
		this.color = color;
		this.shape = shape;
	}

	public int getColor()
	{
		return color;
	}

	public Shape getShape()
	{
		return shape;
	}

	@Override
	public <Result> Result accept(Visitor<Result> v)
	{
		return v.onStroke(this);
	}
}
