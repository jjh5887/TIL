package chapter01.item03.enumtype;

import chapter01.item03.field.IElvis;

public enum Elvis implements IElvis {
	INSTANCE;

	public void leaveTheBuilding() {
		System.out.println("기다려 자기야, 지금 나갈께!");
	}

	@Override
	public void sing() {
		System.out.println("sing");
	}

	// 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
	public static void main(String[] args) {
		Elvis elvis = Elvis.INSTANCE;
		elvis.leaveTheBuilding();
	}
}
