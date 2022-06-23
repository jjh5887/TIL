package me.powerarc.designpatterns.behavioral_patterns.command._02_after;

// 메소드가 1개이고 return과 인자가 없는 인터페이스 -> Runnable
public interface Command {

	void execute();

	void undo();

}
