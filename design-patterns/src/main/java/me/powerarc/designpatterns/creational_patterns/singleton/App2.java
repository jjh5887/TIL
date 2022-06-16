package me.powerarc.designpatterns.creational_patterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App2 {
	public static void main(String[] args) throws
		InvocationTargetException,
		InstantiationException,
		IllegalAccessException {
		Settings5 settings = Settings5.INSTANCE;

		Settings5 settings1 = null;
		Constructor<?>[] declaredConstructors = Settings5.class.getDeclaredConstructors();

		// enum은 자체적으로 막음
		// for (Constructor<?> declaredConstructor : declaredConstructors) {
		// 	declaredConstructor.setAccessible(true);
		// 	settings1 = (Settings5)declaredConstructor.newInstance("INSTANCE");
		// 	System.out.println(settings == settings1);
		// }

		// by Serializable and Deserializable
		System.out.println();
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
			out.writeObject(settings);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Settings5 settings2 = null;
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
			settings2 = (Settings5)in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(settings == settings2); // true
	}
}
