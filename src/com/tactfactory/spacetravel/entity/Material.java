package com.tactfactory.spacetravel.entity;

public class Material extends Gear implements BuySale {

	private int rarity;
	private double price;

	/**
	 * @return the rarity
	 */
	public int getRarity() {
		return rarity;
	}

	/**
	 * @param rarity the rarity to set
	 */
	public void setRarity(int rarity) {
		this.rarity = rarity;
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
	public Material() {
		super();
	}

	/**
	 * @param name
	 * @param weight
	 */
	public Material(String name, int weight) {
		super(name, weight);
	}

	/**
	 * @param rarity
	 */
	public Material(String name, int weight, int rarity, double price) {
		super(name, weight);
		this.rarity = rarity;
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Material [rarity=" + rarity + ", price=" + price
				+ ", toString()=" + super.toString() + "]";
	}
}
