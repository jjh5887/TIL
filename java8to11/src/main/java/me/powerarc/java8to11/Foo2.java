package me.powerarc.java8to11;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo2 {
	public static void main(String[] args) {
		Function<Integer, Integer> plus10 = (num) -> num + 10;
		Function<Integer, Integer> multiply2 = (i) -> i * 2;

		System.out.println("Function");
		System.out.println(plus10.apply(1));
		System.out.println(multiply2.apply(1));
		System.out.println();

		// 함수 조합
		System.out.println("Function Compose, AndThen");
		Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
		System.out.println(multiply2AndPlus10.apply(2));
		System.out.println(plus10.andThen(multiply2).apply(2));
		System.out.println();

		// 입력 2, 반환 1
		System.out.println("BiFunction");
		BiFunction<Integer, Integer, Integer> biFunction = (i, j) -> i + j;
		System.out.println(biFunction.apply(10, 20));
		System.out.println();

		// 입력 1, 반환 0
		System.out.println("Consumer");
		Consumer<Integer> printT = (i) -> System.out.println(i);
		printT.accept(10);
		System.out.println();

		// 입력 0, 반환 1
		System.out.println("Supplier");
		Supplier<Integer> get10 = () -> 10;
		System.out.println(get10.get());
		System.out.println();

		// true or false
		System.out.println("Predicate");
		Predicate<String> startsWithKwonHo = (name) -> name.startsWith("kwonho");
		Predicate<Integer> isEven = (i) -> i % 2 == 0;
		System.out.println(startsWithKwonHo.negate().test("kwonho hi"));
		System.out.println(isEven.test(3));
		System.out.println();

		// 입력하는 값과 리턴하는 값의 타입이 같은 경우
		System.out.println("UnaryOperator");
		UnaryOperator<Integer> plus30 = (i) -> i + 30;
		System.out.println(plus30.apply(5));
		System.out.println();

		// BiFunction의 3개의 타입이 모드 같은 경우
		System.out.println("BinaryOperator");
		BinaryOperator<Integer> binaryOperator = (i, j) -> i + j;
		System.out.println(binaryOperator.apply(10, 20));

	}
}
