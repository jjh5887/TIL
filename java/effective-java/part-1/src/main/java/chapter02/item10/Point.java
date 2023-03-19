package chapter02.item10;

public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 추이성을 해결할 순 있지만 잘못된 코드 - 리스코프 치환 원칙 위배! (59쪽)
	// TODO 근데 작동은 정상적으로 하지만 결과 값이 다르다고 리스코프 치환 원칙을 위배 한다고 볼 수 있을까...?
	// @Override
	// public boolean equals(Object o) {
	//  // 클래스 자체를 비교하여 자식 클래스여도 구분 -> 자식 클래스와의 비교를 거부해서 리스코프 치환 위배인가...?
	// 	if (o == null || o.getClass() != getClass())
	// 		return false;
	// 	Point p = (Point)o;
	// 	return p.x == x && p.y == y;
	// }

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Point)) {
			return false;
		}

		Point p = (Point)o;
		return p.x == x && p.y == y;
	}
}
