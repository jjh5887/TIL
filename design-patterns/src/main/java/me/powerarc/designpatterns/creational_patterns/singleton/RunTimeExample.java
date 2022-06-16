package me.powerarc.designpatterns.creational_patterns.singleton;

public class RunTimeExample {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println(runtime.maxMemory());
		System.out.println(runtime.freeMemory());
	}
}
