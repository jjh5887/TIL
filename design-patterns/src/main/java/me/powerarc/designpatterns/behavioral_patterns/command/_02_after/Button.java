package me.powerarc.designpatterns.behavioral_patterns.command._02_after;

import java.util.Stack;

import me.powerarc.designpatterns.behavioral_patterns.command._01_before.Game;
import me.powerarc.designpatterns.behavioral_patterns.command._01_before.Light;

public class Button {

	private final Stack<Command> commands = new Stack<>();

	public void press(Command command) {
		command.execute();
		commands.push(command);
	}

	public void undo() {
		if (!commands.isEmpty()) {
			Command command = commands.pop();
			command.undo();
		}
	}

	public static void main(String[] args) {
		Button button = new Button();
		button.press(new LightOnCommand(new Light()));
		button.press(new GameEndCommand(new Game()));
		button.undo();
		button.undo();
	}
}
