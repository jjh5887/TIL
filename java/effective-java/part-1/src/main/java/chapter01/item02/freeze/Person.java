package chapter01.item02.freeze;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;

	private int birthYear;

	private List<String> kids;

	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
		this.kids = new ArrayList<>();
	}

	// 좋은 형태는 아님
	private void checkIfObjectIsFrozen() {
		if (this.frozen()) {
			throw new IllegalStateException();
		}
	}

	private boolean frozen() {
		return false;
	}

	public void setName(String name) {
		checkIfObjectIsFrozen();
		this.name = name;
	}

	public void setBirthYear(int birthYear) {
		checkIfObjectIsFrozen();
		this.birthYear = birthYear;
	}

	public void setKids(List<String> kids) {
		checkIfObjectIsFrozen();
		this.kids = kids;
	}

	public static void main(String[] args) {
		Person person = new Person("keesun", 1982);
	}

}
