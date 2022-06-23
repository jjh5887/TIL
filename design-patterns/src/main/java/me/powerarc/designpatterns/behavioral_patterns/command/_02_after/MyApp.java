package me.powerarc.designpatterns.behavioral_patterns.command._02_after;

import me.powerarc.designpatterns.behavioral_patterns.command._01_before.Game;

public class MyApp {

	private final Command command;

	public MyApp(Command command) {
		this.command = command;
	}

	public void press() {
		command.execute();
	}

	public static void main(String[] args) {
		MyApp myApp = new MyApp(new GameStartCommand(new Game()));
	}
}
