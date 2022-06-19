package me.powerarc.designpatterns.structural_patterns.bridge_pattern._02_after;

import me.powerarc.designpatterns.structural_patterns.bridge_pattern._01_before.Champion;

public class App {

	public static void main(String[] args) {
		Champion kad아리 = new 아리(new KDA());
		kad아리.skillQ();
		kad아리.skillW();

		Champion poolParty아리 = new 아리(new PoolParty());
		poolParty아리.skillR();
		poolParty아리.skillE();
	}
}
