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
			// 또 다른 클래스의 equals도 내부에서 또 equals를 호출한다면 SmellPoint의 equals일텐데
			// 그러면 또 이 코드로 돌아와서 equals를 호출... -> StackOverFlow
			return o.equals(this);

		// o가 ColorPoint면 색상까지 비교한다.
		return super.equals(o) && ((SmellPoint)o).smell.equals(smell);
	}

}
