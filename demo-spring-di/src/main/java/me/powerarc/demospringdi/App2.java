package me.powerarc.demospringdi;

import java.util.Arrays;

public class App2 {
	public static void main(String[] args) {
		System.out.println("========== MyBook Annotations ==========");
		Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

		System.out.println();
		System.out.println("========== MyBook DeclaredAnnotations ==========");
		Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);

		System.out.println();
		System.out.println("========== Book Fields Annotations ==========");
		Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
			Arrays.stream(f.getAnnotations()).forEach(a -> {
				if (a instanceof MyAnnotation) {
					MyAnnotation myAnnotation = (MyAnnotation) a;
					System.out.println(myAnnotation.value());
					System.out.println(myAnnotation.name());
 				}
			});
		});

	}
}
