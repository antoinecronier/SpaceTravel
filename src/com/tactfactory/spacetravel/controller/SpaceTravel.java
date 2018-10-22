package com.tactfactory.spacetravel.controller;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.spacetravel.entity.Compartment;
import com.tactfactory.spacetravel.entity.Gear;
import com.tactfactory.spacetravel.entity.Planet;
import com.tactfactory.spacetravel.entity.Spaceship;
import com.tactfactory.spacetravel.entity.Weightable;
import com.tactfactory.spacetravel.util.PlanetUtil;

public class SpaceTravel {

	private static final String READY_TRAVEL = "La fus�e %s est pr�te avec � son bord les cosmonautes %s pour la s�rie de voyage %s";
	private static final String GEAR_NOT_ADDED = "L'�quipement %s ne peut pas �tre embarqu� dans le compartiment %s";
	private static final String GEAR_ADD = "L'�quipement %s a �t� embarqu� dans la soute %s";
	private static final String WRONG_COMPARTMENT = " car il ne respect pas les crit�res de la soute %s";
	private static final String REFUEL = "Rechargement du carburant";
	private static final String REFUEL_MAX = REFUEL + " au maximum %s";
	private static final String REFUEL_VALUE = REFUEL + " � %s";
	private static final String REFUEL_FINISH = "Le nouveau niveau de carburant est � %s soit %s %";
	private static final String REFUEL_MORE = "%s n'ont pas �t� utilis�";
	private static final String NAVIGATION_STEP = "Le vaisseau spacial %s est arriv� � %s en partant de %s en utilisant %s carburant";
	private static final String NAVIGATION_FAILED = "Le vaisseau n'est pas arriv� � destination il est perdu dans l'espace";
	private static final String NAVIGATION_STOP = "Le vaisseau a fini son trajet";
	private static final String UNLOAD_GEAR = "D�chargement de %s";
	private static final String UNLOAD_GEAR_FAILED = "Impossible de d�charger %s car non pr�sent";
	private static final String SPACESHIP_OVERWEIGHT = "Impossible de d�placer le vaisseau car il est surcharg�";
	private static final String COMPARTMENT_OVERWEIGHT = "Compartiment surcharg�";

	private Spaceship spaceship;
	private List<Planet> travelSteps;
	private int stepIndex = 0;
	private boolean canContinue = true;

	/**
	 * @return the spaceship
	 */
	public Spaceship getSpaceship() {
		return spaceship;
	}

	/**
	 * @param spaceship the spaceship to set
	 */
	public void setSpaceship(Spaceship spaceship) {
		this.spaceship = spaceship;
	}

	/**
	 * @return the travelSteps
	 */
	public List<Planet> getTravelSteps() {
		return travelSteps;
	}

	/**
	 * @param travelSteps the travelSteps to set
	 */
	public void setTravelSteps(List<Planet> travelSteps) {
		this.travelSteps = travelSteps;
	}

	/**
	 * @param spaceship
	 * @param travelSteps
	 */
	public SpaceTravel(Spaceship spaceship, List<Planet> travelSteps) {
		super();
		this.spaceship = spaceship;
		this.travelSteps = travelSteps;

		System.out.println(String.format(READY_TRAVEL, spaceship.getName(), spaceship.getCosmonauts(), travelSteps));
	}

	public void travelWithoutSteps(){
		while (this.stepIndex < this.travelSteps.size() - 1 && this.canContinue ) {
			travelToNextPlanet();
		}
		this.canContinue = true;
	}

	public void travelToNextPlanet(){
		if (this.stepIndex < this.travelSteps.size() - 1) {
			if (this.canContinue) {
				if (checkWeight()) {
					if (checkFuel()) {

					}
				}
			}else {
				System.out.println(NAVIGATION_FAILED);
			}
		}else {
			System.out.println(NAVIGATION_STOP);
		}
	}

	private Boolean checkWeight() {
		Boolean result = false;

		if (this.spaceship.getMaxWeight() > this.getSpaceship().getWeight()) {
			result = true;
		}else {
			this.canContinue = false;
			System.out.println(SPACESHIP_OVERWEIGHT);
		}

		return result;
	}

	/**
	 * @param necessaryFuel
	 */
	private Boolean checkFuel() {
		Boolean result = false;
		int necessaryFuel = PlanetUtil.fuelForDistance(travelSteps.get(stepIndex), travelSteps.get(stepIndex+1));
		necessaryFuel = necessaryFuel * this.getSpaceship().getWeight() / 100;
		this.spaceship.setFuel(this.spaceship.getFuel()-necessaryFuel);
		if (this.spaceship.getFuel() > 0) {
			System.out.println(String.format(NAVIGATION_STEP,this.spaceship.getName(),travelSteps.get(stepIndex+1).getName(), travelSteps.get(stepIndex).getName(), String.valueOf(necessaryFuel)));
			result = true;
			this.stepIndex++;
		}else {
			System.out.println(NAVIGATION_FAILED);
			this.stepIndex = -1;
			this.canContinue = false;
		}

		return result;
	}

	public void reFuel(){
		this.spaceship.setFuel(this.spaceship.getMaxFuel());
		System.out.println(String.format(REFUEL_MAX,this.spaceship.getMaxFuel()));
	}

	public void reFuel(int value){
		if (this.spaceship.getFuel() + value <= this.spaceship.getMaxFuel()) {
			this.spaceship.setFuel(this.spaceship.getFuel() + value);
			System.out.println(String.format(REFUEL_VALUE,String.valueOf(value)));
			System.out.println(String.format(REFUEL_FINISH,String.valueOf(this.spaceship.getFuel()),String.valueOf(this.spaceship.getFuel()/this.spaceship.getMaxFuel()*100)));
		}else {
			int tempValue = this.spaceship.getFuel();
			this.reFuel();
			System.out.println(String.format(REFUEL_MORE,String.valueOf(this.spaceship.getMaxFuel()- tempValue + value)));
		}
	}

	public List<Gear> load(List<Gear> gears, Compartment compartment){
		List<Gear> notLoad = new ArrayList<Gear>();
		for (Gear gear : gears) {
			if (compartment.getWeight() + gear.getWeight() < compartment.getMaximalWeight()) {
				if (compartment.getCriteria() == null) {
					if (compartment.getGears().isEmpty()) {
						compartment.getGears().add(gear);
						System.out.println(String.format(GEAR_ADD,gear.getName(),compartment.getName()));
					}else if (compartment.getGears().get(0).getClass().getSimpleName().equals(gear.getClass().getSimpleName())) {
						compartment.getGears().add(gear);
						System.out.println(String.format(GEAR_ADD,gear.getName(),compartment.getName()));
					}else {
						System.out.println(String.format(GEAR_NOT_ADDED, gear.getName(), compartment.getName()));
						notLoad.add(gear);
					}
				}else {
					if (gear.getClass().getSimpleName().equals(compartment.getCriteria())) {
						compartment.getGears().add(gear);
						System.out.println(String.format(GEAR_ADD,gear.getName(),compartment.getName()));
					}else {
						System.out.println(String.format(GEAR_NOT_ADDED, gear.getName(), compartment.getName() + String.format(WRONG_COMPARTMENT, compartment.getCriteria())));
						notLoad.add(gear);
					}
				}
			}else {
				System.out.println(COMPARTMENT_OVERWEIGHT);
			}
		}
		return notLoad;
	}

	public List<Gear> unload(Compartment compartment) {
		List<Gear> gears = new ArrayList<Gear>();
		for (Gear gear : compartment.getGears()) {
			gears.add(gear);
			System.out.println(String.format(UNLOAD_GEAR, gear.getName()));
		}
		compartment.getGears().removeAll(gears);
		return gears;
	}

	public List<Gear> unload(Compartment compartment, List<Gear> gears) {
		List<Gear> notUnload = new ArrayList<Gear>();
		for (Gear gear : gears) {
			if (compartment.getGears().contains(gear)) {
				System.out.println(String.format(UNLOAD_GEAR, gear.getName()));
				compartment.getGears().remove(gear);
			}else {
				System.out.println(String.format(UNLOAD_GEAR_FAILED,gear.getName()));
				notUnload.add(gear);
			}
		}

		return notUnload;
	}

	public Planet getCurrentPlanet(){
		return this.travelSteps.get(this.stepIndex);
	}
}
