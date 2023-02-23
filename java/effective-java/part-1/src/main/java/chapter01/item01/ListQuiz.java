package chapter01.item01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListQuiz {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(100);
		numbers.add(20);
		numbers.add(40);
		numbers.add(1);

		Comparator<Integer> comparator = (o1, o2) -> o2 - o1;
		numbers.sort(comparator.reversed());

		System.out.println(numbers);
	}
}
