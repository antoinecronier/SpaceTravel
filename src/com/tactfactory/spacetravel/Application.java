package com.tactfactory.spacetravel;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.spacetravel.controller.PlanetController;
import com.tactfactory.spacetravel.controller.SpaceTravel;
import com.tactfactory.spacetravel.entity.*;
import com.tactfactory.spacetravel.menu.MenuInteraction;

/**
 * Créer un programme qui permet de faire voyager un vaisseau spacial de planète en planète suivant un itinéraire de vol.
 * Le vaisseau possèdera des compartiments de stockage ne pouvant embarquer qu'un certain poids de marchandise et un seul type de marchandise.
 * Afin d'affréter un compartiment on renseignera la liste des marchandises et le compartiment dans lequel on veut insérer les marchandises.
 * Lorsque l'on affréte un compartiement on le rempli jusqu'à ne plus pouvoir y ajouter de marchandise en terme de poids.
 * Un planète possèdera un nom et des coordonnées.
 * Une coordonnées sera représenté par X, Y et Z
 * Naviguer entre deux planètes se fera en consommant du carburant selon la formule suivante :
 * 		((sqrt((Xa-Xb)²+(Ya-Yb)²+(Za-Zb)²)/100) * (poidsFusée / 100))
 * 
 * Une marchandise, un compartiment et les cosmonautes qui pilote la fusée possède tous un poids. 
 * 
 * Votre programme permettra à l'utilisateur par l'intermédiaire d'un menu de :
 * 	- connaitre les informations de la planète courante ou il se situe
 * 	- naviguer vers une nouvelle planète
 * 
 * => exemples :
 * 		-----------------------Bienvenu sur la planet-----------------------
 *
 *		Planet [name=Terre, coordinate=Coordinate [X=0.0, Y=12.0, Z=-20.0]]
 * 
 * 		1 : Données de navigation
 *		2 : Naviguer vers la planète
 *
 * => si l'utilisateur saisi 1 on affichera :
 * 
 * 		La planète Planet [name=Terre, coordinate=Coordinate [X=0.0, Y=12.0, Z=-20.0]] est à 0 unité de carburant de la plan�te actuelle Planet [name=Terre, coordinate=Coordinate [X=0.0, Y=12.0, Z=-20.0]]
 *		Actuellement le vaisseau a 10000 unité de carburant
 *
 *		Entrer pour continuer...
 *
 * => si l'utilisateur saisi 2 on affichera :
 * 
 * 		Le vaisseau spacial Fusée1 est arrivé à Mars en partant de Terre en utilisant 20 carburant
 * 
 * Seul les éléments présenté si dessus sont liés à des intéractions utilisateur.
 * Tout autre fonctionnalité, comme le plan de vol, l'affrétement, ... est directement créer dans le point d'entré de votre programme.
 * 
 * @author antoine.cronier
 *
 */
public class Application {

	public static void main(String[] args){

		// Spaceship 1 Cosmonaut
		List<Cosmonaut> spaceship1Cosmonaut = new ArrayList<Cosmonaut>();
		spaceship1Cosmonaut.add(new Cosmonaut("Jean", "Ford",120));
		spaceship1Cosmonaut.add(new Cosmonaut("Ivan", "Ford",120));
		spaceship1Cosmonaut.add(new Cosmonaut("Ivan", "Taylor",120));

		// Spaceship 1 compartment
		List<Compartment> spaceship1Compartment = new ArrayList<Compartment>();
		spaceship1Compartment.add(new Compartment("compartiment 1", new ArrayList<Gear>()
				, 1000, Passenger.class.getSimpleName(),100));
		spaceship1Compartment.add(new Compartment("compartiment 2", new ArrayList<Gear>()
				, 1000, Material.class.getSimpleName(),80));
		spaceship1Compartment.add(new Compartment("compartiment 3", new ArrayList<Gear>()
				, 1000, null,300));
		spaceship1Compartment.add(new Compartment("compartiment 4", new ArrayList<Gear>()
				, 1000, null,100));

		// Spaceship 1
		Spaceship spaceship1 = new Spaceship("Fus�e1", spaceship1Cosmonaut, spaceship1Compartment, 0, 10000,50000);

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
		gears.add(new Material("Plomb",320,2,20));
		gears.add(new Material("Plomb",120,2,200));
		gears.add(new Material("Plomb",240,2,10));
		gears.add(new Material("Or",100,10,25));
		gears.add(new Material("Fibre carbone",200,4,20000));
		spaceship1Travel.load(gears, spaceship1Compartment.get(0));

		gears = new ArrayList<Gear>();
		for (int i = 0; i < 20; i++) {
			gears.add(new Passenger("Passenger"+i,80));
		}
		gears.add(new Material("Fibre carbone",20,4,20));
		spaceship1Travel.load(gears, spaceship1Compartment.get(1));

		gears = new ArrayList<Gear>();
		for (int i = 0; i < 100; i++) {
			gears.add(new Food("Ma�s",20,true,20));
		}
		for (int i = 0; i < 20; i++) {
			gears.add(new Food("Choux de bruxel",20,false,20));
		}
		spaceship1Travel.load(gears, spaceship1Compartment.get(2));

		gears = new ArrayList<Gear>();
		for (int i = 0; i < 100; i++) {
			gears.add(new Food("Eau",200,true,20));
		}
		spaceship1Travel.load(gears, spaceship1Compartment.get(3));

		// Re fuel to max
		spaceship1Travel.reFuel();

		// Manualy do
		String result = MenuInteraction.getInstance().menuInteract(new PlanetController(earth,spaceship1Travel));


		// Travel by steps for spaceship1
		System.out.println("\n\n\n-------------\nVoyage 1 �tape 1\n-------------\n");
		spaceship1Travel.travelToNextPlanet();
		System.out.println("\n\n\n-------------\nVoyage 1 �tape 2\n-------------\n");
		spaceship1Travel.unload(spaceship1Compartment.get(2));
		System.out.println("\n\n\n-------------\nVoyage 1 �tape 3\n-------------\n");
		spaceship1Travel.reFuel();
		System.out.println("\n\n\n-------------\nVoyage 1 �tape 4\n-------------\n");
		spaceship1Travel.travelToNextPlanet();
		System.out.println("\n\n\n-------------\nVoyage 1 �tape 5?\n-------------\n");
		spaceship1Travel.travelToNextPlanet();

		// Spaceship 1 Cosmonaut
		List<Cosmonaut> spaceship2Cosmonaut = new ArrayList<Cosmonaut>();
		spaceship2Cosmonaut.add(new Cosmonaut("Ygor", "Nolan",120));
		spaceship2Cosmonaut.add(new Cosmonaut("Djo", "FF",120));
		spaceship2Cosmonaut.add(new Cosmonaut("Alfred", "M",120));

		// Spaceship 1 compartment
		List<Compartment> spaceship2Compartment = new ArrayList<Compartment>();

		// Spaceship 2
		Spaceship spaceship2 = new Spaceship("Fus�e2", spaceship2Cosmonaut, spaceship2Compartment, 0, 10000,120);

		// Space travel
		SpaceTravel spaceship2Travel = new SpaceTravel(spaceship2,
			new ArrayList<Planet>(){
			{
				add(earth);
				add(proxima);
				add(earth);
			}});
		// Travel without steps for spaceship2
		System.out.println("\n\n\n-------------\nVoyage 2 �tapes\n-------------\n");
		spaceship2Travel.reFuel();
		spaceship2Travel.travelWithoutSteps();
	}
}
