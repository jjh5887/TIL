package chapter01.item01;

import java.util.Optional;
import java.util.ServiceLoader;

import chapter01.item01.secret.ChineseHelloService;

public class HelloServiceFactory {
	public static void main(String[] args) {
		// 인터페이스 기반의 프레임워크
		// HelloService ko = HelloService.of("ko");

		// 자바에서 기본으로 제공해주는 ServiceLoader
		// 인터페이스의 구현체가 없어도 된다 -> 의존성 분리고
		// 실제로 별도의 프로젝트를 생성하지 않아 출력 되지는 않음... (귀찮아서...)
		ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
		Optional<HelloService> helloServiceOptional = loader.findFirst();
		helloServiceOptional.ifPresent(h -> {
			System.out.println(h.hello());
		});

		// 이런 형태로도 작성이 가능하지만 의존성이 생김
		HelloService helloService = new ChineseHelloService();
		System.out.println(helloService.hello());

	}
}
