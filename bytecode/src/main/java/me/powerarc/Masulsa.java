package me.powerarc;

import static net.bytebuddy.matcher.ElementMatchers.*;

import java.io.File;
import java.io.IOException;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

public class Masulsa {

	public static void main(String[] args) throws IOException {
		// 해당 방법으로 클래스르 집적 로드하지않고 조작 but 다른곳에서 해당 클래스를 읽으면 의미없음
		ClassLoader classLoader = Masulsa.class.getClassLoader();
		TypePool typePool = TypePool.Default.of(classLoader);

		// 1. 코드 조작
		new ByteBuddy().redefine(typePool.describe("me.powerarc.Moja").resolve(),
				ClassFileLocator.ForClassLoader.of(classLoader))
			.method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
			.make().saveIn(new File("/Users/jung-gwonho/workspace/TIL/bytecode/target/classes/"));

		// 바이트코드를 조작하고 동시에 조작된 클래스를 읽어오지 않음 -> 조작하고 build 하고 나서 그 다음에 적용됨
		// 2. 확인
		System.out.println(new Moja().pullOut());
	}
}
