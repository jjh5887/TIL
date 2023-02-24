package chapter01.item03.field;

import java.io.Serializable;

public class Elvis implements Serializable, IElvis {
	/**
	 * 싱글톤 오브젝트
	 */
	public static final Elvis INSTANCE = new Elvis();

	private static boolean created;

	// 리플렉션 방어 코드
	private Elvis() {
		if (created) {
			throw new UnsupportedOperationException("can't be created by constructor.");
		}

		created = true;
	}

	// 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
	public static void main(String[] args) {
		Elvis elvis = Elvis.INSTANCE;
		elvis.leaveTheBuilding();
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	public void sing() {
		System.out.println("I'll have a blue~ Christmas without you~");
	}

	// 역직렬화 할 때 사용하는 메서드를 오버라이딩 하여 방어
	// 오버라이드이지만 문법적으로 오버라이드는 아님
	private Object readResolve() {
		return INSTANCE;
	}
}
