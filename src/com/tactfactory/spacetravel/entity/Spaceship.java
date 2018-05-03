package com.tactfactory.spacetravel.entity;

import java.util.ArrayList;
import java.util.List;

public class Spaceship {

	private String name;
	private List<Cosmonaut> cosmonauts = new ArrayList<Cosmonaut>();
	private List<Compartment> compartments = new ArrayList<Compartment>();
	private int fuel;
	private int maxFuel;

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
	 * @return the cosmonauts
	 */
	public List<Cosmonaut> getCosmonauts() {
		return cosmonauts;
	}
	/**
	 * @param cosmonauts the cosmonauts to set
	 */
	public void setCosmonauts(List<Cosmonaut> cosmonauts) {
		this.cosmonauts = cosmonauts;
	}
	/**
	 * @return the compartments
	 */
	public List<Compartment> getCompartments() {
		return compartments;
	}
	/**
	 * @param compartments the compartments to set
	 */
	public void setCompartments(List<Compartment> compartments) {
		this.compartments = compartments;
	}
	/**
	 * @return the fuel
	 */
	public int getFuel() {
		return fuel;
	}
	/**
	 * @param fuel the fuel to set
	 */
	public void setFuel(int fuel) {
		if (fuel < 0) {
			fuel = 0;
		}
		this.fuel = fuel;
	}
	/**
	 * @return the maxFuel
	 */
	public int getMaxFuel() {
		return maxFuel;
	}
	/**
	 * @param maxFuel the maxFuel to set
	 */
	public void setMaxFuel(int maxFuel) {
		this.maxFuel = maxFuel;
	}

	public Spaceship() {

	}

	/**
	 * @param name
	 * @param cosmonauts
	 * @param compartments
	 * @param fuel
	 */
	public Spaceship(String name, List<Cosmonaut> cosmonauts,
			List<Compartment> compartments, int fuel,int maxFuel) {
		super();
		this.name = name;
		this.cosmonauts = cosmonauts;
		this.compartments = compartments;
		this.fuel = fuel;
		this.maxFuel = maxFuel;
	}
}
