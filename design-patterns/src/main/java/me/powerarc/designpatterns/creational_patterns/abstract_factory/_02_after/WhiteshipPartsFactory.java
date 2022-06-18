package me.powerarc.designpatterns.creational_patterns.abstract_factory._02_after;

import me.powerarc.designpatterns.creational_patterns.abstract_factory._01_before.WhiteAnchor;
import me.powerarc.designpatterns.creational_patterns.abstract_factory._01_before.WhiteWheel;

public class WhiteshipPartsFactory implements ShipPartsFactory {
	@Override
	public Anchor createAnchor() {
		return new WhiteAnchor();
	}

	@Override
	public Wheel createWheel() {
		return new WhiteWheel();
	}
}
