package me.powerarc.java8to11._interface;

public class DefaultBar implements Bar {

	String name;

	public DefaultBar(String name) {
		this.name = name;
	}

	// default 메소드 재정의 가능
	@Override
	public void printNameUpperCase() {
		System.out.println(this.name.toUpperCase());
	}

	@Override
	public void printName() {
		System.out.println(this.name);
	}

	@Override
	public String getName() {
		return this.name;
	}
}
