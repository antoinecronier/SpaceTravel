package com.tactfactory.spacetravel.controller;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.spacetravel.entity.BuySale;
import com.tactfactory.spacetravel.entity.Compartment;
import com.tactfactory.spacetravel.entity.Gear;
import com.tactfactory.spacetravel.entity.Spaceship;
import com.tactfactory.spacetravel.menu.Menu;
import com.tactfactory.spacetravel.menu.MenuInteraction;

public class SpaceshipController extends TraderController implements Menu {

	private static final String WELCOME = "\n"+ MenuInteraction.MENU_DELIMITERS
											+"Bienvenu commandant"
											+ MenuInteraction.MENU_DELIMITERS + "\n";
	private static final String ACTIONS = "\n1 : Données de navigation\n"
											+ "2 : Naviguer vers la planète\n"
											+ "3 : Voir les commerces\n"
											+ "3 : " + TraderController.TRADE_ACTION_BUY
											+ "3 : " + TraderController.TRADE_ACTION_SELL
											+ MenuInteraction.ACTION_LEAVE;

	private static final String ACTION_1 = "?";

	private SpaceTravel spaceTravel;
	private Compartment currentSelectedCompartment;

	/**
	 * @param spaceship
	 */
	public SpaceshipController(SpaceTravel spaceTravel, double balance) {
		super(balance);
		this.spaceTravel = spaceTravel;
	}

	@Override
	public String getDisplay() {
		return WELCOME + ACTIONS;
	}

	@Override
	public Boolean checkResult(String toCheck) {
		Boolean result = false;
		if (toCheck.equals("1") || toCheck.equals("2") || toCheck.equals("3")
				|| toCheck.equals(MenuInteraction.ACTION_LEAVE_ITEM)) {
			result = true;
		}
		return result;
	}

	@Override
	public void interact(String result) {
		switch (result) {
		case "1":
			;
			System.out.println(String.format(ACTION_1));
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

	@Override
	public List<BuySale> stock(List<BuySale> toStock) {
		List<BuySale> notLoad = new ArrayList<BuySale>();
		List<Gear> toLoad = new ArrayList<Gear>();

		for (BuySale buySale : toStock) {
			if (buySale.getClass().getSimpleName().equals(Gear.class.getSimpleName())) {
				toLoad.add((Gear)buySale);
			}else {

			}
		}

		this.changeCurrentSelectedCompartment();

		for (Gear gear : this.spaceTravel.load(toLoad,this.currentSelectedCompartment)) {
			notLoad.add((BuySale)gear);
		}

		return notLoad;
	}

	@Override
	public void unstock(List<BuySale> toUnstock) {
		List<Gear> toUnload = new ArrayList<Gear>();

		for (BuySale buySale : toUnstock) {
			toUnload.add((Gear)buySale);
		}

		this.changeCurrentSelectedCompartment();
		this.spaceTravel.unload(this.currentSelectedCompartment, toUnload);
	}

	private void changeCurrentSelectedCompartment() {
		MenuInteraction.getInstance().menuInteract(new Menu() {
			private int itemsNb = 0;

			@Override
			public void interact(String result) {
				SpaceshipController.this.currentSelectedCompartment
				= SpaceshipController.this.spaceTravel
					.getSpaceship()
					.getCompartments()
					.get(Integer.valueOf(result));
			}

			@Override
			public String getDisplay() {
				StringBuilder display = new StringBuilder();
				display.append("\n");
				display.append("Selectionner le compartiment à utiliser\n");
				int i = 0;
				for (Compartment compartment : SpaceshipController.this.spaceTravel.getSpaceship().getCompartments()) {
					display.append(i + " : " + compartment + "\n");
				}
				itemsNb = i;
				display.append("\n");
				return display.toString();
			}

			@Override
			public Boolean checkResult(String toCheck) {
				Boolean result = false;
				if (Integer.valueOf(toCheck) < itemsNb && Integer.valueOf(toCheck) >= 0) {
					result = true;
				}
				return result;
			}
		});
	}

}
