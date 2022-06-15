package me.powerarc.demospringdi.di;

import java.util.Arrays;

public class ContainerService {

	public static <T> T getObject(Class<T> classType) throws
		ReflectiveOperationException {
		T instance = createInstance(classType);
		Arrays.stream(classType.getDeclaredFields()).forEach(f -> {

			if (f.getAnnotation(Inject.class) != null) {
				try {
					Object fieldInstance = createInstance(f.getType());
					f.setAccessible(true);
					f.set(instance, fieldInstance);
				} catch (ReflectiveOperationException e) {
					e.printStackTrace();
				}
			}
		});

		return instance;
	}

	private static <T> T createInstance(Class<T> classType) throws ReflectiveOperationException {
		return classType.getConstructor(null).newInstance();
	}
}
