package me.powerarc.designpatterns.creational_patterns.abstract_factory._02_after;

import me.powerarc.designpatterns.creational_patterns.factory_method._02_after.DefaultShipFactory;
import me.powerarc.designpatterns.creational_patterns.factory_method._02_after.Ship;

public class WhiteshipFactory extends DefaultShipFactory {

	private final ShipPartsFactory shipPartsFactory;

	public WhiteshipFactory(
		ShipPartsFactory shipPartsFactory) {
		this.shipPartsFactory = shipPartsFactory;
	}

	@Override
	public Ship createShip() {
		Ship ship = new Ship();
		ship.setAnchor(shipPartsFactory.createAnchor());
		ship.setWheel(shipPartsFactory.createWheel());
		return ship;
	}
}
