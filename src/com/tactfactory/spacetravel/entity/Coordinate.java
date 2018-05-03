package com.tactfactory.spacetravel.entity;

public class Coordinate {

	private double X;
	private double Y;
	private double Z;

	/**
	 * @return the x
	 */
	public double getX() {
		return X;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		X = x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return Y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		Y = y;
	}
	/**
	 * @return the z
	 */
	public double getZ() {
		return Z;
	}
	/**
	 * @param z the z to set
	 */
	public void setZ(double z) {
		Z = z;
	}

	public Coordinate() {
	}

	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Coordinate(double x, double y, double z) {
		super();
		X = x;
		Y = y;
		Z = z;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coordinate [X=" + X + ", Y=" + Y + ", Z=" + Z + "]";
	}
}
