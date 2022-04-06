package me.powerarc.java8to11.annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Chicken("간장")
@Chicken("양념")
public class App {

	public static void main(String[] args) throws @Chicken("") RuntimeException {
		List<@Chicken("") String> names = new ArrayList<>();

		Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
		Arrays.stream(chickens).forEach((a) -> System.out.println(a.value()));

		ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
		Arrays.stream(chickenContainer.value()).forEach((a)-> System.out.println(a.value()));

	}

	static class FeelsLikeChicken<@Chicken("") T> {

		public static <@Chicken("") C> void print(@Chicken("") C c) {
			System.out.println(c);
		}
	}
}
