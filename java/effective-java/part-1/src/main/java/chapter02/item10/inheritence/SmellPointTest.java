package chapter02.item10.inheritence;

import chapter02.item10.Color;

public class SmellPointTest {
	/**
	 * Stack 메모리 조절해주는 Java 실행 옵션
	 * TODO -Xss10M
	 * @param args
	 */
	public static void main(String[] args) {
		SmellPoint p1 = new SmellPoint(1, 0, "sweat");
		ColorPoint p2 = new ColorPoint(1, 0, Color.RED);

		// equals에서 또 equals를 호출하여 StackOverflowError 발생
		p1.equals(p2);
	}
}
