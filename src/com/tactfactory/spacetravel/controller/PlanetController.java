package com.tactfactory.spacetravel.controller;

import com.tactfactory.spacetravel.entity.Planet;
import com.tactfactory.spacetravel.entity.Spaceship;
import com.tactfactory.spacetravel.menu.Menu;
import com.tactfactory.spacetravel.menu.MenuInteraction;
import com.tactfactory.spacetravel.util.PlanetUtil;

public class PlanetController implements Menu {

	private static final String WELCOME = "\n"+ MenuInteraction.MENU_DELIMITERS
											+"Bienvenu sur la planet"
											+ MenuInteraction.MENU_DELIMITERS + "\n"
											+ "\n%s\n";
	private static final String ACTIONS = "\n1 : Données de navigation\n"
										+ "2 : Naviguer vers la planète\n"
										+ "3 : Voir les commerces\n"
										+ MenuInteraction.ACTION_LEAVE;

	private static final String ACTION_1 = "La planète %s est à %s unité de carburant de la planète actuelle %s\nActuellement le vaisseau a %s unité de carburant";

	private Planet planet;
	private SpaceTravel spaceTravel;

	/**
	 * @param planet
	 */
	public PlanetController(Planet planet, SpaceTravel spaceTravel) {
		super();
		this.planet = planet;
		this.spaceTravel = spaceTravel;
	}

	@Override
	public String getDisplay() {
		return String.format(WELCOME,planet) + ACTIONS;
	}

	@Override
	public Boolean checkResult(String toCheck) {
		Boolean result = false;
		if (toCheck.equals("1") || toCheck.equals("2") || toCheck.equals("3")) {
			result = true;
		}
		return result;
	}

	@Override
	public void interact(String result) {
		switch (result) {
		case "1":
			;
			System.out.println(String.format(ACTION_1,
											this.planet,
											String.valueOf(PlanetUtil.fuelForDistance(this.spaceTravel.getCurrentPlanet(),this.planet)),
											this.spaceTravel.getCurrentPlanet(),
											this.spaceTravel.getSpaceship().getFuel()
											));
			MenuInteraction.getInstance().menuContinue();
			MenuInteraction.getInstance().menuInteract(this);
			break;
		case "2":
			MenuInteraction.getInstance().menuContinue();
			MenuInteraction.getInstance().menuInteract(this);
			break;
		case "3":
			MenuInteraction.getInstance().menuContinue();
			MenuInteraction.getInstance().menuInteract(this);
			break;
		case "exit":
			break;
		}
	}
}
