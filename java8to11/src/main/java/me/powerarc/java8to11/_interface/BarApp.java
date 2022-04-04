package me.powerarc.java8to11._interface;

public class BarApp {
	public static void main(String[] args) {
		Bar bar = new DefaultBar("kwonho");
		bar.printName();
		bar.printNameUpperCase();

		Bar.printAnything();
	}
}
