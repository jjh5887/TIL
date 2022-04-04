package me.powerarc.java8to11;

// 추상 메서드가 하나만 있으면 함수헝 인터페이스 (static, default 가 있어도 추상 메서드가 하나만 있으면 됨)
@FunctionalInterface
public interface RunSomething {

	// abstract 생략 가능
	void doIt();

	// 추상 메서드 2개면 @FunctionalInterface 에러남
	// void doAgain();

	static void printName() {
		System.out.println("Kwonho");
	}

	default void printAge() {
		System.out.println("26");
	}
}
