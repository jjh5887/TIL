package me.powerarc.designpatterns.creational_patterns.prototype_pattern._03_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaCollectionExample {

	public static void main(String[] args) {
		Student kwonho = new Student("kwonho");
		Student powerarc = new Student("powerarc");

		List<Student> students = new ArrayList<>();
		students.add(kwonho);
		students.add(powerarc);

		// List가 Cloneable을 상속 하지 않음
		// ArrayList<Student> clone = (ArrayList<Student>) students.clone();
		// System.out.println(clone);

		// 엄밀히 말하면 prototype은 아님
		List<Student> clone = new ArrayList<>(students);
		System.out.println(clone);
	}
}
