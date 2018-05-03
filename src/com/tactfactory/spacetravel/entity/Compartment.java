package com.tactfactory.spacetravel.entity;

import java.util.ArrayList;
import java.util.List;

public class Compartment {

	private String name;
	private List<Gear> gears = new ArrayList<Gear>();
	private int maximalWeight;
	private String criteria;

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
	 * @return the gears
	 */
	public List<Gear> getGears() {
		return gears;
	}
	/**
	 * @param gears the gears to set
	 */
	public void setGears(List<Gear> gears) {
		this.gears = gears;
	}
	/**
	 * @return the maximalWeight
	 */
	public int getMaximalWeight() {
		return maximalWeight;
	}
	/**
	 * @param maximalWeight the maximalWeight to set
	 */
	public void setMaximalWeight(int maximalWeight) {
		this.maximalWeight = maximalWeight;
	}
	/**
	 * @return the criteria
	 */
	public String getCriteria() {
		return criteria;
	}
	/**
	 * @param criteria the criteria to set
	 */
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public Compartment() {

	}

	/**
	 * @param name
	 * @param gears
	 * @param maximalWeight
	 * @param criteria
	 */
	public Compartment(String name, List<Gear> gears, int maximalWeight,
			String criteria) {
		super();
		this.name = name;
		this.gears = gears;
		this.maximalWeight = maximalWeight;
		this.criteria = criteria;
	}
}
