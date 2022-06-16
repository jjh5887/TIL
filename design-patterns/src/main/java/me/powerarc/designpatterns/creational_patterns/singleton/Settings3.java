package me.powerarc.designpatterns.creational_patterns.singleton;

public class Settings3 {

	// double-checked locking
	private static volatile Settings3 instance;

	private Settings3() {
	}

	public static Settings3 getInstance() {
		if (instance == null) {
			synchronized (Settings3.class) {
				if (instance == null) {
					instance = new Settings3();
				}
			}
		}
		return instance;
	}
}
