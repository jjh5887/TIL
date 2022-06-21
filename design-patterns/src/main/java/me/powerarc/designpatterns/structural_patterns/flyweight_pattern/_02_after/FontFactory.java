package me.powerarc.designpatterns.structural_patterns.flyweight_pattern._02_after;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {

	private final Map<String, Font> cahce = new HashMap<>();

	public Font getFont(String font) {
		if (cahce.containsKey(font)) {
			return cahce.get(font);
		}

		String[] split = font.split(":");
		Font newFont = new Font(split[0], Integer.parseInt(split[1]));
		cahce.put(font, newFont);
		return newFont;
	}
}
