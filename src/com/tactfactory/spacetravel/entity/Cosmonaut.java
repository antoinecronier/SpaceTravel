package com.tactfactory.spacetravel.entity;

public class Cosmonaut implements Weightable {

	private String firstname;
	private String lastname;
	private int weight;

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public Cosmonaut() {
	}

	/**
	 * @param firstname
	 * @param lastname
	 */
	public Cosmonaut(String firstname, String lastname, int weight) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cosmonaut [firstname=" + firstname + ", lastname=" + lastname
				+ "]";
	}
}
