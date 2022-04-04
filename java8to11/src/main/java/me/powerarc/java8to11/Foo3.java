package me.powerarc.java8to11;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo3 {
	public static void main(String[] args) {
		Foo3 foo3 = new Foo3();
		foo3.run();
	}

	private void run() {
		final int baseNum = 10;

		// 로컬 클래스
		class LocalClass {
			void printBaseNumber() {
				int baseNum = 11;
				System.out.println(baseNum); // 11
			}
		}

		// 익명 클래스
		Consumer<Integer> integerConsumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer integer) {
				int baseNum = 11;
				System.out.println(baseNum); // 11
			}
		};

		// 람다
		// 람다의 스코프는 run 메소드와 같음
		IntConsumer printInt = (i) -> {
			// 쉐도잉이 안됨
			// int baseNum = 11;
			System.out.println(i + baseNum);
		};

		// 에러
		// printInt = (baseNum) -> {
		// 	System.out.println(baseNum);
		// }

		printInt.accept(10);
	}
}
