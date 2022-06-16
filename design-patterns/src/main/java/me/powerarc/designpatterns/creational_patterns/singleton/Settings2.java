package me.powerarc.designpatterns.creational_patterns.singleton;

public class Settings2 {

	// eager initialization
	private static final Settings2 INSTANCE = new Settings2();

	private Settings2() {
	}

	public static synchronized Settings2 getInstance() {
		return INSTANCE;
	}
}
