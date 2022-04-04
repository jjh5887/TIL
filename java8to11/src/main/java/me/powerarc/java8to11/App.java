package me.powerarc.java8to11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
	public static void main(String[] args) {
		// 스태틱 메소드 참조
		UnaryOperator<String> hi = Greeting::hi;
		System.out.println(hi.apply("hi"));

		// 특정 객체의 인스턴스 메소드 참조
		Greeting greeting = new Greeting();
		UnaryOperator<String> hello = greeting::hello;
		System.out.println(hello.apply("kwonho"));

		// 생성자 참조
		Supplier<Greeting> newGreeting = Greeting::new;
		Function<String, Greeting> kwonhoGreeting = Greeting::new;
		System.out.println(kwonhoGreeting.apply("kwonho").getName());


		// 임의 객체의 인스턴스 메소드 참조
		String[] names = {"kwonho", "keesun", "whiteship", "toby"};
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		Arrays.sort(names, (o1, o2) -> o1.compareToIgnoreCase(o2));
		Arrays.sort(names, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(names));
	}
}
