package com.tactfactory.spacetravel.entity;

public abstract class Gear implements Weightable {

	private String name;
	private int weight;

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
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Gear() {
	}

	/**
	 * @param name
	 * @param weight
	 */
	public Gear(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gear [name=" + name + ", weight=" + weight + "]";
	}
}
