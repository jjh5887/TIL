package me.powerarc.designpatterns.creational_patterns.abstract_factory._03_java;

import org.springframework.beans.factory.FactoryBean;

import me.powerarc.designpatterns.creational_patterns.factory_method._02_after.Ship;
import me.powerarc.designpatterns.creational_patterns.factory_method._02_after.Whiteship;

public class ShipFactory implements FactoryBean<Ship> {

	@Override
	public Ship getObject() throws Exception {
		Ship ship = new Whiteship();
		ship.setName("whiteship");
		return ship;
	}

	@Override
	public Class<?> getObjectType() {
		return Ship.class;
	}
}
