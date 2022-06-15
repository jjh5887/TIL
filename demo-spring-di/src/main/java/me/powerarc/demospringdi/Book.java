package me.powerarc.demospringdi;

@MyAnnotation(value = 200, name = "asdsda")
public class Book {

	private static final String C = "BOOK";
	private static String B = "BOOK";
	public String d = "d";
	protected String e = "e";
	@MyAnnotation
	private String a = "a";

	public Book() {
	}

	@MyAnnotation
	public Book(String a, String d, String e) {
		this.a = a;
		this.d = d;
		this.e = e;
	}

	private void f() {
		System.out.println("f");
	}

	public void g() {
		System.out.println("g");
	}

	public int h() {
		return 100;
	}
}
