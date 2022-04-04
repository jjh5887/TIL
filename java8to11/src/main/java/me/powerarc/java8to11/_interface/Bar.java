package me.powerarc.java8to11._interface;

public interface Bar {

	void printName();

	/**
	 * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
	 */
	default void printNameUpperCase() {
		System.out.println(getName().toUpperCase());
	}

	// equals, toString은 default 메소드로 사용 불가능
	// default String toString() {
	//
	// }

	String getName();

	static void printAnything() {
		System.out.println("anything");
	}
}
