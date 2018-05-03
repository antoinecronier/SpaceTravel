package com.tactfactory.spacetravel.entity;

public class Food extends Gear {

	private Boolean isEatable;

	/**
	 * @return the isEatable
	 */
	public Boolean getIsEatable() {
		return isEatable;
	}

	/**
	 * @param isEatable the isEatable to set
	 */
	public void setIsEatable(Boolean isEatable) {
		this.isEatable = isEatable;
	}

	/**
	 *
	 */
	public Food() {
		super();
	}

	/**
	 * @param name
	 * @param weight
	 */
	public Food(String name, int weight) {
		super(name, weight);
	}

	/**
	 * @param isEatable
	 */
	public Food(String name, int weight, Boolean isEatable) {
		super(name, weight);
		this.isEatable = isEatable;
	}
}
