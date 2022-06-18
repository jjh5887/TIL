package me.powerarc.designpatterns.creational_patterns.abstract_factory._02_after;

public class WhitesPartsProFactory implements ShipPartsFactory {
	@Override
	public Anchor createAnchor() {
		return new WhiteAnchorPro();
	}

	@Override
	public Wheel createWheel() {
		return new WhiteWheelPro();
	}
}
