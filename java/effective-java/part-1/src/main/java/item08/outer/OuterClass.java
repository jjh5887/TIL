package item08.outer;

import java.lang.reflect.Field;

public class OuterClass {
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		InnerClass innerClass = outerClass.new InnerClass();

		System.out.println(innerClass);

		outerClass.printFiled();
	}

	private void hi() {

	}

	private void printFiled() {
		Field[] declaredFields = InnerClass.class.getDeclaredFields();
		// outer 클래스가 나옴
		for (Field field : declaredFields) {
			System.out.println("field type:" + field.getType());
			System.out.println("field name:" + field.getName());
		}
	}

	class InnerClass {

		// static이 아닌 내부 클래스는 외부 객체의 참조를 가질 수 있음
		public void hello() {
			OuterClass.this.hi();
		}

	}
}
