package chapter01.item03.enumtype;

import java.lang.reflect.Constructor;

public class EnumElvisReflection {
	public static void main(String[] args) {
		try {
			// Enum은 자체적으로 리플렉션 방어
			Constructor<Elvis> declaredConstructor = Elvis.class.getDeclaredConstructor();
			System.out.println(declaredConstructor);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
