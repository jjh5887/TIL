package me.powerarc.designpatterns.behavioral_patterns.command._02_after;

import me.powerarc.designpatterns.behavioral_patterns.command._01_before.Light;

public class LightOnCommand implements Command {

	private final Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}
}
