package me.powerarc.designpatterns.behavioral_patterns.interpreter._02_after;

import java.util.Map;

public class MinusExpression implements PostfixExpression {

	private final PostfixExpression left;

	private final PostfixExpression right;

	public MinusExpression(PostfixExpression left,
		PostfixExpression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpret(Map<Character, Integer> context) {
		return left.interpret(context) - right.interpret(context);
	}
}