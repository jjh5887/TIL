package chapter01.item06;

import java.util.regex.Pattern;

public class RegularExpression {
	private static final Pattern SPLIT_PATTERN = Pattern.compile(";;;");

	public static void main(String[] args) {
		long start = System.nanoTime();
		for (int j = 0; j < 10000; j++) {
			// String name = "keesun,whiteship";
			String name = "keesun;;;whiteship";

			// 한글자만 사용하는 경우는 미리 컴파일 하지 않아도 빠름
			name.split(";;;");
		}
		System.out.println(System.nanoTime() - start);

		start = System.nanoTime();
		for (int j = 0; j < 10000; j++) {
			String name = "keesun;;;whiteship";
			// replace 를 사용할 때도 활용 가능
			SPLIT_PATTERN.split(name);
		}
		System.out.println(System.nanoTime() - start);
	}
}
