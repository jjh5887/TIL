package me.powerarc;

import static net.bytebuddy.matcher.ElementMatchers.*;

import java.io.File;
import java.io.IOException;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

public class Masulsa {

	public static void main(String[] args) throws IOException {
		// 1. 코드 조작
		// new ByteBuddy().redefine(Moja.class)
		// 		.method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
		// 		.make().saveIn(new File("/Users/jung-gwonho/workspace/TIL/bytecode/target/classes/"));

		// 바이트코드를 조작하고 동시에 조작된 클래스를 읽어오지 않음 -> 조작하고 build 하고 나서 그 다음에 적용됨
		// 2. 확인
		System.out.println(new Moja().pullOut());
	}
}
