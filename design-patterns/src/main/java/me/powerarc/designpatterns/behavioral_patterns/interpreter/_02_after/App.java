package me.powerarc.designpatterns.behavioral_patterns.interpreter._02_after;

import java.util.Map;

public class App {

	public static void main(String[] args) {
		// Tree 구조처럼 형성됨
		PostfixExpression expression = PostfixParser.parse("xyz+-a+");
		int result = expression.interpret(Map.of('x', 1, 'y', 2, 'z', 3, 'a', 4));
		System.out.println(result);

	}
}
