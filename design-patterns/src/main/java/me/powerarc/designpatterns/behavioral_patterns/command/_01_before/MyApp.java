package me.powerarc.designpatterns.behavioral_patterns.command._01_before;

public class MyApp {

	private final Game game;

	public MyApp(Game game) {
		this.game = game;
	}

	public void press() {
		game.start();
	}

	public static void main(String[] args) {
		Button button = new Button(new Light());
		button.press();
		button.press();
		button.press();
		button.press();
	}
}
