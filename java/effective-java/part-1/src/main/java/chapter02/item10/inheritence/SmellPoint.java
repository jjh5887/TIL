package chapter02.item10.inheritence;

import chapter02.item10.Point;

public class SmellPoint extends Point {

	private String smell;

	public SmellPoint(int x, int y, String smell) {
		super(x, y);
		this.smell = smell;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Point))
			return false;

		// o가 일반 Point면 색상을 무시하고 비교한다.
		if (!(o instanceof SmellPoint))
			// 또다른 자식클래스의 equals도 내부에서 또 equals를 호출하면 StackOverFlow
			return o.equals(this);

		// o가 ColorPoint면 색상까지 비교한다.
		return super.equals(o) && ((SmellPoint)o).smell.equals(smell);
	}

}
