package me.powerarc.java8to11;

public class Foo {
	public static void main(String[] args) {
		// 익명 내부 클래스
		RunSomething runSomething = new RunSomething() {
			@Override
			public void doIt() {
				System.out.println("hello");
			}
		};

		RunSomething runSomethingWithLambda = () -> System.out.println("hello");

		RunSomething runSomethingWithLambdaLines = () -> {
			System.out.println("hello");
			System.out.println("hi");
		};

		runSomething.doIt();
		runSomethingWithLambda.doIt();
		runSomethingWithLambdaLines.doIt();

		// 순수 함수
		RunSomething2 runSomething2 = (num) -> num + 10;

		// 입력받은 값이 동일한 경우 결과가 같아야함.
		System.out.println(runSomething2.doIt(1));
		System.out.println(runSomething2.doIt(1));
		System.out.println(runSomething2.doIt(1));

		System.out.println(runSomething2.doIt(2));
		System.out.println(runSomething2.doIt(2));
		System.out.println(runSomething2.doIt(2));

		// 순수 함수 X
		int base = 20;
		RunSomething2 runSomething2NotPure = new RunSomething2() {

			@Override
			public int doIt(int num) {
				// 외부의 값을 수정하려는 경우
				// base++;

				// 함수 밖에 값을 사용하는 경우
				return num + base;
			}
		};

		// final 로 가정해버려서 컴파일 에러
		// base--;
	}
}
