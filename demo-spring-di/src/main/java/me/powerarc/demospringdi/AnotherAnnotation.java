package me.powerarc.demospringdi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // default는 class여서 리플렉션에서 조회되지 않음
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface AnotherAnnotation {

	String name() default "kwonho";

	int value() default 100; // 이름을 value로 사용하면 namedParamter 생략 가능
}
