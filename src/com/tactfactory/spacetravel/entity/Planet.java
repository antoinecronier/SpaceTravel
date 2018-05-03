package com.tactfactory.spacetravel.entity;

public class Planet {

	private String name;
	private Coordinate coordinate;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}
	/**
	 * @param coordinate the coordinate to set
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Planet() {
	}

	/**
	 * @param name
	 * @param coordinate
	 */
	public Planet(String name, Coordinate coordinate) {
		super();
		this.name = name;
		this.coordinate = coordinate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Planet [name=" + name + ", coordinate=" + coordinate + "]";
	}
}
