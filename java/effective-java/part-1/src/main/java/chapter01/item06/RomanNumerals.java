package chapter01.item06;

import java.util.regex.Pattern;

// 값비싼 객체를 재사용해 성능을 개선한다. (32쪽)
public class RomanNumerals {
	// 코드 6-1 성능을 훨씬 더 끌어올릴 수 있다!
	static boolean isRomanNumeralSlow(String s) {
		return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}

	// 코드 6-2 값비싼 객체를 재사용해 성능을 개선한다.
	// 정규식 자체를 미리 만들어서 재활용
	private static final Pattern ROMAN = Pattern.compile(
		"^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

	static boolean isRomanNumeralFast(String s) {
		return ROMAN.matcher(s).matches();
	}

	public static void main(String[] args) {
		boolean result = false;
		long start = System.nanoTime();
		for (int j = 0; j < 100; j++) {
			result = isRomanNumeralFast("MCMLXXVI");
		}
		long end = System.nanoTime();
		System.out.println(end - start);
		System.out.println(result);

		result = false;
		start = System.nanoTime();
		for (int j = 0; j < 100; j++) {
			result = isRomanNumeralFast("MCMLXXVI");
		}
		end = System.nanoTime();
		System.out.println(end - start);
		System.out.println(result);
	}
}
