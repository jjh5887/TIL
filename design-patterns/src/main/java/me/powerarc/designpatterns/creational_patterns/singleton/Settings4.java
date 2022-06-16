package me.powerarc.designpatterns.creational_patterns.singleton;

public class Settings4 {

	// static inner (권장되는 방식)
	private Settings4() {
	}

	private static class SettingsHolder {
		private static final Settings4 INSTANCE = new Settings4();
	}

	public static Settings4 getInstance() {
		return SettingsHolder.INSTANCE;
	}
}
