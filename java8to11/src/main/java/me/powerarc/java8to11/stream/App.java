package me.powerarc.java8to11.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("kwonho");
		names.add("keesun");
		names.add("whiteship");
		names.add("toby");

		// 중개 오퍼레이션 -> Stream 리턴
		Stream<String> stringStream = names.stream().map((s) -> {
			// 출력 안됨
			System.out.println(s);
			return s.toUpperCase();
		});

		System.out.println("종료 오퍼레이션 실행 후 출력");

		// 종료 오퍼레이션
		List<String> collect = stringStream.collect(Collectors.toList());

		System.out.println("================");

		// 병렬 처리
		names.parallelStream().map((s -> {
			System.out.println(s + " " + Thread.currentThread().getName());
			return s.toUpperCase();
		})).collect(Collectors.toList()).forEach(System.out::println);
	}
}
