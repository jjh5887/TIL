package chapter01.item01;

public interface HelloService {

	String hello();

	// static HelloService of(String lang) {
	// 	if (lang.equals("ko")) {
	// 		return new KoreanHelloService();
	// 	} else {
	// 		return new EnglishHelloService();
	// 	}
	// }

	static String hi() {
		prepareMessage();
		return "hi";
	}

	static String h2() {
		prepareMessage();
		return "hi";
	}

	static String h3() {
		prepareMessage();
		return "hi";
	}

	private static void prepareMessage() {
	}

}
