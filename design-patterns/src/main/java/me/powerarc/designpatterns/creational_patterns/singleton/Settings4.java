package me.powerarc.designpatterns.creational_patterns.singleton;

import java.io.Serializable;

public class Settings4 implements Serializable {

	// static inner (권장되는 방식)
	private Settings4() {
	}

	private static class SettingsHolder {
		private static final Settings4 INSTANCE = new Settings4();
	}

	public static Settings4 getInstance() {
		return SettingsHolder.INSTANCE;
	}

	// Deserializable 대응 방안
	protected Object readResolve() {
		return getInstance();
	}
}
