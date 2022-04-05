package me.powerarc.java8to11.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		Optional<OnlineClass> optional = springClasses.stream()
			.filter(onlineClass -> onlineClass.getTitle().startsWith("jpa"))
			.findFirst();

		// optional.ifPresent(onlineClass -> System.out.println(onlineClass.getTitle()));

		OnlineClass onlineClass = optional.orElse(createNewClass()); // 있더라도 createNewClass()는 실행됨
		System.out.println(onlineClass.getTitle());

		System.out.println("================");
		OnlineClass onlineClass1 = optional.orElseGet(App::createNewClass);
		System.out.println(onlineClass1.getTitle());

		// System.out.println("================");
		// optional.orElseThrow(IllegalArgumentException::new);

		Optional<OnlineClass> onlineClass2 = optional
			.filter(OnlineClass::isClosed);

		System.out.println(onlineClass2.isEmpty());

		Optional<Integer> integer = optional
			.map(OnlineClass::getId);


		// map, flatMap
		Optional<Optional<Progress>> progress = optional
			.map(OnlineClass::getProgress);

		// Stream에서 쓰는 flatMap과는 다름
		Optional<Progress> progress2 = optional
			.flatMap(OnlineClass::getProgress);

	}

	private static OnlineClass createNewClass() {
		System.out.println("creating new online class");
		return new OnlineClass(10, "New class", false);
	}
}
