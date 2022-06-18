package me.powerarc.designpatterns.creational_patterns.abstract_factory._02_after;

public interface ShipPartsFactory {

	Anchor createAnchor();

	Wheel createWheel();
}
