package edu.luc.etl.cs313.android.shapes.model;

import java.util.List;
import java.util.Iterator;

public class Polygon extends Group {

	public Polygon(final Point... points) {
		super(points);
	}

	@SuppressWarnings("unchecked")
	public List<? extends Point> getPoints() {
		return (List<? extends Point>) getShapes();
	}

	@Override
	public <Result> Result accept(final Visitor<Result> v) {
		return v.onPolygon(this);
	}
	public int getMaxX() {
		final Iterator<? extends Point> point = getPoints().iterator();

		int currentMax = 0;
		while (point.hasNext()) {
			final Location currentLocation = point.next();
			if (currentMax <= currentLocation.getX())  {
				currentMax = currentLocation.getX();
			}
		}
		return currentMax;
	}

	public int getMaxY() {
		final Iterator<? extends Point> point = getPoints().iterator();

		int currentMax = 0;
		while (point.hasNext()) {
			final Location currentLocation = point.next();
			if (currentMax <= currentLocation.getY())  {
				currentMax = currentLocation.getY();
			}
		}
		return currentMax;
	}

	public int getMinX() {
		final Iterator<? extends Point> point = getPoints().iterator();

		int currentMax = Integer.MAX_VALUE;
		while (point.hasNext()) {
			final Location currentLocation = point.next();
			if (currentMax >= currentLocation.getX())  {
				currentMax = currentLocation.getX();
			}
		}
		return currentMax;
	}

	public int getMinY() {
		final Iterator<? extends Point> point = getPoints().iterator();

		int currentMax = Integer.MAX_VALUE;
		while (point.hasNext()) {
			final Location currentLocation = point.next();
			if (currentMax >= currentLocation.getY())  {
				currentMax = currentLocation.getY();
			}
		}
		return currentMax;
	}

	public int getWidth() {
		return getMaxX() - getMinX();
	}

	public int getHeight() {
		return getMaxY() - getMinY();
	}
}