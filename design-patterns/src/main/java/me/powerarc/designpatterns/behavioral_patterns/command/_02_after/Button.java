package me.powerarc.designpatterns.behavioral_patterns.command._02_after;

import me.powerarc.designpatterns.behavioral_patterns.command._01_before.Light;

public class Button {

	private final Command command;

	public Button(Command command) {
		this.command = command;
	}

	public void press() {
		command.execute();
	}

	public static void main(String[] args) {
		Button button = new Button(new LightOnCommand(new Light()));
		button.press();
		button.press();
	}
}
