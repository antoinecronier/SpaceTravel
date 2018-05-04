package com.tactfactory.spacetravel.entity;

import java.util.ArrayList;
import java.util.List;

public class Compartment implements Weightable {

	private String name;
	private List<Gear> gears = new ArrayList<Gear>();
	private int maximalWeight;
	private String criteria;
	private int emptyWeight;

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

	/**
	 * @return the emptyWeight
	 */
	public int getEmptyWeight() {
		return emptyWeight;
	}
	/**
	 * @param emptyWeight the emptyWeight to set
	 */
	public void setEmptyWeight(int emptyWeight) {
		this.emptyWeight = emptyWeight;
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
			String criteria, int emptyWeight) {
		super();
		this.name = name;
		this.gears = gears;
		this.maximalWeight = maximalWeight;
		this.criteria = criteria;
		this.emptyWeight = emptyWeight;
	}

	@Override
	public int getWeight() {
		Integer realWeight = this.emptyWeight;
		for (Gear gear : this.gears) {
			realWeight += gear.getWeight();
		}
		return  realWeight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Compartment [name=" + name + ", gears=" + gears
				+ ", maximalWeight=" + maximalWeight + ", criteria=" + criteria
				+ ", emptyWeight=" + emptyWeight + "]";
	}
}
