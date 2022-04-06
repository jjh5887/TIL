package me.powerarc.java8to11.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// @Target(ElementType.TYPE_PARAMETER) // 제네릭에만 사용 가능
@Target(ElementType.TYPE_USE) // 타입이랑 타입에는 다 사용 가능
@Repeatable(ChickenContainer.class) // 어노테이션 반복 사용
public @interface Chicken {
	String value();
}
