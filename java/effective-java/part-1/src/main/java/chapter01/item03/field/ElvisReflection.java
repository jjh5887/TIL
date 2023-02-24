package chapter01.item03.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ElvisReflection {
	public static void main(String[] args) {
		try {
			Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor();
			defaultConstructor.setAccessible(true);
			Elvis elvis1 = defaultConstructor.newInstance();
			Elvis elvis2 = defaultConstructor.newInstance();
			Elvis.INSTANCE.sing();
		} catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
