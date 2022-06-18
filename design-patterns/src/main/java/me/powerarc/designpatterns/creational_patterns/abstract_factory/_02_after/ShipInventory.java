package me.powerarc.designpatterns.creational_patterns.abstract_factory._02_after;

import me.powerarc.designpatterns.creational_patterns.factory_method._02_after.Ship;
import me.powerarc.designpatterns.creational_patterns.factory_method._02_after.ShipFactory;

public class ShipInventory {

	public static void main(String[] args) {
		ShipFactory shipFactory = new WhiteshipFactory(new WhitesPartsProFactory());
		Ship ship = shipFactory.createShip();
		System.out.println(ship.getAnchor().getClass());
		System.out.println(ship.getWheel().getClass());
	}
}
