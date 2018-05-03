package com.tactfactory.spacetravel.util;

import com.tactfactory.spacetravel.entity.Planet;

public class PlanetUtil {

	public static double distanceBetween(Planet p1, Planet p2){
		return Math.sqrt(
				Math.pow((p1.getCoordinate().getX()-p2.getCoordinate().getX()),2)+
				Math.pow((p1.getCoordinate().getY()-p2.getCoordinate().getY()),2)+
				Math.pow((p1.getCoordinate().getZ()-p2.getCoordinate().getZ()),2)
				);
	}

	public static int fuelForDistance(Planet p1, Planet p2){
		Double dist = distanceBetween(p1,p2)/100;
		return dist.intValue();
	}
}
