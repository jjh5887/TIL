package me.powerarc.designpatterns.structural_patterns.flyweight_pattern._02_after;

public class Character {

	private final char value;

	private final String color;

	private final Font font;

	public Character(char value, String color,
		Font font) {
		this.value = value;
		this.color = color;
		this.font = font;
	}
}
