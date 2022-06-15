package me.powerarc;

import static net.bytebuddy.matcher.ElementMatchers.*;

import java.lang.instrument.Instrumentation;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class MasulsaAgent {

	public static void premain(String agentArgs, Instrumentation inst) {
		// 클래스 로딩할때 적용하여 byte 코드 자체는 바뀌지 않고 메모리 내부에서 변경
		new AgentBuilder.Default()
			.type(ElementMatchers.any())
			.transform((builder, typeDescription, classLoader, javaModule) -> builder.method(named("pullOut"))
				.intercept(FixedValue.value("Rabbit!"))).installOn(inst);
	}
}
