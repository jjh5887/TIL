package me.powerarc.designpatterns.structural_patterns.adapter_pattern._03_java;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

public class AdapterSpring {

	public static void main(String[] args) {
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		HandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
	}
}
