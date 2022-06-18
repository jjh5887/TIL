package me.powerarc.designpatterns.creational_patterns.abstract_factory._03_java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.powerarc.designpatterns.creational_patterns.factory_method._02_after.Ship;

public class FactoryBeanExample {

	public static void main(String[] args) {
		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("config.xml");
		Ship whiteship = applicationContext1.getBean("whiteship", Ship.class);
		System.out.println(whiteship.getName());

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
		Ship bean = applicationContext.getBean(Ship.class);
		System.out.println(bean);
	}
}
