package me.powerarc.java8to11;

public class Greeting {

	private String name;

	public Greeting() {
	}

	public Greeting(String name) {
		this.name = name;
	}

	public static String hi(String s) {
		return "hi " + s;
	}

	public String getName() {
		return name;
	}

	public String hello(String name) {
		return "hello " + name;
	}
}
