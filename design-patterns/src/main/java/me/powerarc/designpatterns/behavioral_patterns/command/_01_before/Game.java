package me.powerarc.designpatterns.behavioral_patterns.command._01_before;

public class Game {

	private boolean isStarted;

	public void start() {
		System.out.println("게임을 시작합니다.");
		this.isStarted = true;
	}

	public void end() {
		System.out.println("게임을 종료합니다.");
		this.isStarted = false;
	}

	public boolean isStarted() {
		return isStarted;
	}
}
