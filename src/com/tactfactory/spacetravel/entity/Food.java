package com.tactfactory.spacetravel.entity;

public class Food extends Gear implements BuySale {

	private Boolean isEatable;
	private double price;

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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
	public Food(String name, int weight, Boolean isEatable, double price) {
		super(name, weight);
		this.isEatable = isEatable;
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Food [isEatable=" + isEatable + ", price=" + price
				+ ", toString()=" + super.toString() + "]";
	}
}
