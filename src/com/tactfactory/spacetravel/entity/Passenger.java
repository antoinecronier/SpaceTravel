package com.tactfactory.spacetravel.entity;

import java.util.Date;

public class Passenger extends Gear {

	private String firstname;
	private String lastname;
	private Date birth;

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
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 *
	 */
	public Passenger() {
		super();
	}

	/**
	 * @param name
	 * @param weight
	 */
	public Passenger(String name, int weight) {
		super(name, weight);
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param birth
	 */
	public Passenger(String name, int weight, String firstname, String lastname, Date birth) {
		super(name, weight);
		this.firstname = firstname;
		this.lastname = lastname;
		this.birth = birth;
	}
}
