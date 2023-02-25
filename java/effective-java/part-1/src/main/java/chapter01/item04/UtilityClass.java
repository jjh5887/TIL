package chapter01.item04;

public class UtilityClass {

	/**
	 * 이 클래스는 인스턴스를 만들 수 없습니다.
	 */
	private UtilityClass() {
		// 아예 해당 상황이 발생하지 않게 방지하려면 Exception보다는 Error
		throw new AssertionError();
	}

	public static String hello() {
		return "hello";
	}

	public static void main(String[] args) {
		String hello = UtilityClass.hello();

		UtilityClass utilityClass = new UtilityClass();
		utilityClass.hello();

	}
}
