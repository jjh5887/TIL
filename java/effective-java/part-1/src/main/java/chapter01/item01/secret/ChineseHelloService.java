package chapter01.item01.secret;

import chapter01.item01.HelloService;

// 다른 프로젝트에 있는 클래스이고 dependency 설정했다고 가정
public class ChineseHelloService implements HelloService {

	@Override
	public String hello() {
		return "Ni Hao";
	}
}
