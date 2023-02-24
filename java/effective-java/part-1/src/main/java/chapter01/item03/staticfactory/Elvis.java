package chapter01.item03.staticfactory;

public class Elvis {

	private static final Elvis INSTANCE = new Elvis();

	private Elvis() {
	}

	// 싱글턴이 아니게 바꾸기 용이
	public static Elvis getInstance() {
		return INSTANCE;
	}

	// 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
	public static void main(String[] args) {
		Elvis elvis = Elvis.getInstance();
		elvis.leaveTheBuilding();

		System.out.println(Elvis.getInstance());
		System.out.println(Elvis.getInstance());
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}
}
