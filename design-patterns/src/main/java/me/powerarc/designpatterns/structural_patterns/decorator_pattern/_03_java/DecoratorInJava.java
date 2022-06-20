package me.powerarc.designpatterns.structural_patterns.decorator_pattern._03_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;

public class DecoratorInJava {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Book());

		// 타입 체크하는 리스트
		List books = Collections.checkedList(list, Book.class);

		list.add(new Item());
		books.add(new Item()); // ClassCastException

		// 서블릿 요청 또는 응답 래퍼
		HttpServletRequestWrapper requestWrapper;
		HttpServletResponseWrapper responseWrapper;
	}

	private static class Book {

	}

	private static class Item {

	}
}
