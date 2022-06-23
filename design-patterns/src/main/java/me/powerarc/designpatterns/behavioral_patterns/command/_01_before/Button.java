package me.powerarc.designpatterns.behavioral_patterns.command._01_before;

public class Button {

	private final Light light;

	public Button(Light light) {
		this.light = light;
	}

	public void press() {
		light.off();
	}

	public static void main(String[] args) {
		Button button = new Button(new Light());
		button.press();
		button.press();
		button.press();
		button.press();
	}
}
