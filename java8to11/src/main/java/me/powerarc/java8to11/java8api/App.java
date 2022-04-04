package me.powerarc.java8to11.java8api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("kwonho");
		names.add("keesun");
		names.add("whiteship");
		names.add("toby");

		names.forEach(System.out::println);
		System.out.println();

		// Collection
		Spliterator<String> spliterator = names.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		while (spliterator.tryAdvance(System.out::println))
			;
		System.out.println("====================");
		while (spliterator1.tryAdvance(System.out::println))
			;
		System.out.println();

		names.removeIf(s->s.startsWith("k"));
		names.forEach(System.out::println);



		// Comparator
		Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
		names.sort(compareToIgnoreCase.reversed().thenComparing((String::compareTo)));



	}
}
