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

public class App {
	public static void main(String[] args) throws
		NoSuchMethodException,
		InvocationTargetException,
		InstantiationException,
		IllegalAccessException {

		// 싱글톤 구현 깨기
		// by Reflection
		Settings4 settings = Settings4.getInstance();
		Constructor<Settings4> constructor = Settings4.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Settings4 settings2 = constructor.newInstance();
		System.out.println(settings == settings2);

		// by Serializable and Deserializable
		System.out.println();
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
			out.writeObject(settings);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Settings4 settings3 = null;
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
			settings3 = (Settings4)in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(settings == settings3);
	}
}
