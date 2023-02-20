package chapter01.item01;

public class HelloServiceFactory {
	public static void main(String[] args) {
		// 인터페이스 기반의 프레임워크
		HelloService ko = HelloService.of("ko");
	}
}
