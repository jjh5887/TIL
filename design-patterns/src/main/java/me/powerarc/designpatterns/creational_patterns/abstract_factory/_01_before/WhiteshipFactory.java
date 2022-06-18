package me.powerarc.designpatterns.creational_patterns.abstract_factory._01_before;

import me.powerarc.designpatterns.creational_patterns.factory_method._02_after.DefaultShipFactory;
import me.powerarc.designpatterns.creational_patterns.factory_method._02_after.Ship;

public class WhiteshipFactory extends DefaultShipFactory {

	@Override
	public Ship createShip() {
		Ship ship = new Ship();
		ship.setAnchor(new WhiteAnchor());
		ship.setWheel(new WhiteWheel());
		return ship;
	}
}
