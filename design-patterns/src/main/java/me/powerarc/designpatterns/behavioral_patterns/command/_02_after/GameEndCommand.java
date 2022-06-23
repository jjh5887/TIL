package me.powerarc.designpatterns.behavioral_patterns.command._02_after;

import me.powerarc.designpatterns.behavioral_patterns.command._01_before.Game;

public class GameEndCommand implements Command {

	private final Game game;

	public GameEndCommand(Game game) {
		this.game = game;
	}

	@Override
	public void execute() {
		game.end();
	}

	@Override
	public void undo() {
		new GameStartCommand(this.game).execute();
	}
}
