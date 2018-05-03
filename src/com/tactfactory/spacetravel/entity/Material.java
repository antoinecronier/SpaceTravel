package com.tactfactory.spacetravel.entity;

public class Material extends Gear {

	private int rarity;

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
	public Material(String name, int weight, int rarity) {
		super(name, weight);
		this.rarity = rarity;
	}
}
