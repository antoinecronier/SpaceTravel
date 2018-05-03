package com.tactfactory.spacetravel;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.spacetravel.controller.SpaceTravel;
import com.tactfactory.spacetravel.entity.*;

public class Application {

	public static void main(String[] args){

		// Spaceship 1 Cosmonaut
		List<Cosmonaut> spaceship1Cosmonaut = new ArrayList<Cosmonaut>();
		spaceship1Cosmonaut.add(new Cosmonaut("Jean", "Ford"));
		spaceship1Cosmonaut.add(new Cosmonaut("Ivan", "Ford"));
		spaceship1Cosmonaut.add(new Cosmonaut("Ivan", "Taylor"));

		// Spaceship 1 compartment
		List<Compartment> spaceship1Compartment = new ArrayList<Compartment>();
		spaceship1Compartment.add(new Compartment("compartiment 1", new ArrayList<Gear>()
				, 1000, Passenger.class.getSimpleName()));
		spaceship1Compartment.add(new Compartment("compartiment 2", new ArrayList<Gear>()
				, 1000, Material.class.getSimpleName()));
		spaceship1Compartment.add(new Compartment("compartiment 3", new ArrayList<Gear>()
				, 1000, null));
		spaceship1Compartment.add(new Compartment("compartiment 4", new ArrayList<Gear>()
				, 1000, null));

		// Spaceship 1
		Spaceship spaceship1 = new Spaceship("Fusée1", spaceship1Cosmonaut, spaceship1Compartment, 0, 10000);

		// Planets
		Planet earth = new Planet("Terre", new Coordinate(0, 12, -20));
		Planet mars = new Planet("Mars", new Coordinate(2000, 30, 16.366));
		Planet saturn = new Planet("Saturne", new Coordinate(100, 160, -6));
		Planet proxima = new Planet("Proxima du centaure", new Coordinate(99999, -99999, 888880));

		// Space travel
		SpaceTravel spaceship1Travel = new SpaceTravel(spaceship1,
				new ArrayList<Planet>(){
					{
						add(earth);
						add(mars);
						add(saturn);
					}});

		// Gear loading
		List<Gear> gears = new ArrayList<Gear>();
		gears.add(new Material("Plomb",320,2));
		gears.add(new Material("Plomb",120,2));
		gears.add(new Material("Plomb",240,2));
		gears.add(new Material("Or",100,10));
		gears.add(new Material("Fibre carbone",200,4));
		spaceship1Travel.load(gears, spaceship1Compartment.get(0));

		gears = new ArrayList<Gear>();
		for (int i = 0; i < 20; i++) {
			gears.add(new Passenger("Passenger"+i,80));
		}
		gears.add(new Material("Fibre carbone",20,4));
		spaceship1Travel.load(gears, spaceship1Compartment.get(1));

		gears = new ArrayList<Gear>();
		for (int i = 0; i < 100; i++) {
			gears.add(new Food("Maïs",20,true));
		}
		for (int i = 0; i < 20; i++) {
			gears.add(new Food("Choux de bruxel",20,false));
		}
		spaceship1Travel.load(gears, spaceship1Compartment.get(2));

		gears = new ArrayList<Gear>();
		for (int i = 0; i < 100; i++) {
			gears.add(new Food("Eau",200,true));
		}
		spaceship1Travel.load(gears, spaceship1Compartment.get(3));

		// Re fuel to max
		spaceship1Travel.reFuel();

		// Travel by steps for spaceship1
		System.out.println("\n\n\n-------------\nVoyage 1 étape 1\n-------------\n");
		spaceship1Travel.travelToNextPlanet();
		System.out.println("\n\n\n-------------\nVoyage 1 étape 2\n-------------\n");
		spaceship1Travel.unload(spaceship1Compartment.get(2));
		System.out.println("\n\n\n-------------\nVoyage 1 étape 3\n-------------\n");
		spaceship1Travel.reFuel();
		System.out.println("\n\n\n-------------\nVoyage 1 étape 4\n-------------\n");
		spaceship1Travel.travelToNextPlanet();
		System.out.println("\n\n\n-------------\nVoyage 1 étape 5?\n-------------\n");
		spaceship1Travel.travelToNextPlanet();

		// Spaceship 1 Cosmonaut
		List<Cosmonaut> spaceship2Cosmonaut = new ArrayList<Cosmonaut>();
		spaceship2Cosmonaut.add(new Cosmonaut("Ygor", "Nolan"));
		spaceship2Cosmonaut.add(new Cosmonaut("Djo", "FF"));
		spaceship2Cosmonaut.add(new Cosmonaut("Alfred", "M"));

		// Spaceship 1 compartment
		List<Compartment> spaceship2Compartment = new ArrayList<Compartment>();

		// Spaceship 2
		Spaceship spaceship2 = new Spaceship("Fusée2", spaceship2Cosmonaut, spaceship2Compartment, 0, 10000);

		// Space travel
		SpaceTravel spaceship2Travel = new SpaceTravel(spaceship2,
			new ArrayList<Planet>(){
			{
				add(earth);
				add(proxima);
				add(earth);
			}});
		// Travel without steps for spaceship2
		System.out.println("\n\n\n-------------\nVoyage 2 étapes\n-------------\n");
		spaceship2Travel.reFuel();
		spaceship2Travel.travelWithoutSteps();
	}
}
