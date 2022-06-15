package me.powerarc.demospringdi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App3 {
	public static void main(String[] args) throws
		NoSuchMethodException,
		InvocationTargetException,
		InstantiationException,
		IllegalAccessException, NoSuchFieldException {

		Constructor<Book2> constructor = Book2.class.getConstructor(null);
		Book2 book = constructor.newInstance();
		System.out.println(book);

		System.out.println();
		Constructor<Book2> constructor2 = Book2.class.getConstructor(String.class);
		Book2 myBook = constructor2.newInstance("myBook");
		System.out.println(myBook);

		// static field
		System.out.println();
		Field a = Book2.class.getDeclaredField("A");
		System.out.println(a.get(null));
		a.set(null, "AAAAAA");
		System.out.println(a.get(null));

		System.out.println();
		Field b = Book2.class.getDeclaredField("B");
		b.setAccessible(true);
		System.out.println(b.get(myBook));
		b.set(myBook, "BBBBBB");
		System.out.println(b.get(myBook));

		System.out.println();
		Method c = Book2.class.getDeclaredMethod("c");
		c.setAccessible(true);
		c.invoke(myBook);

		System.out.println();
		Method d = Book2.class.getDeclaredMethod("sum", int.class, int.class);
		int invoke = (int)d.invoke(myBook, 1, 2);
		System.out.println(invoke);
	}
}
