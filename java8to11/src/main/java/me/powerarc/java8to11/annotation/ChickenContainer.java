package me.powerarc.java8to11.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
// 위 두 범위는 자기가 가지는 어노테이션의 범위보다 크거나 같아야함
public @interface ChickenContainer {
	// 자기가 자니는 어노테이션을 배열로 가져야함
	Chicken[] value();
}
