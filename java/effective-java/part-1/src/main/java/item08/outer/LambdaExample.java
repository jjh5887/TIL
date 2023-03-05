package item08.outer;

import java.lang.reflect.Field;

public class LambdaExample {
	private int value = 10;

	// 람다도 감싸고 있는 외부 클래스의 참조를 가짐
	// 단, 외부 클래스의 멤버를 참조해야만 가짐
	private Runnable instanceLambda = () -> {
		// 아래 코드를 주석처리하면 참조 X
		// 또, 참조하는 멤버가 static 이여도 참조 x
		System.out.println(value);
	};

	public static void main(String[] args) {
		LambdaExample example = new LambdaExample();
		Field[] declaredFields = example.instanceLambda.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println("field type: " + field.getType());
			System.out.println("field name: " + field.getName());
		}
	}
}
