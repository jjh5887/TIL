package me.powerarc.designpatterns.behavioral_patterns.interpreter._02_after;

import java.util.Map;

public interface PostfixExpression {

	int interpret(Map<Character, Integer> context);

	static PostfixExpression plus(PostfixExpression left, PostfixExpression right) {
		return context -> left.interpret(context) + right.interpret(context);
	}

	static PostfixExpression minus(PostfixExpression left, PostfixExpression right) {
		return context -> left.interpret(context) - right.interpret(context);
	}

	static PostfixExpression variable(Character c) {
		return context -> context.get(c);
	}
}
