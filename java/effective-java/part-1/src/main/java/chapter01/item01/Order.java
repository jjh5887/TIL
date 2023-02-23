package chapter01.item01;

import java.util.EnumMap;

public class Order {

	private boolean prime;

	private boolean urgent;

	private Product product;

	// Type Safety
	private OrderStatus orderStatus;

	// 메소드 시그니쳐 때문에 아래와 같은 형태 불가능
	// public Order(Product product, boolean prime) {
	// 	this.product = product;
	// 	this.prime = prime;
	// }
	//
	// public Order(Product product, boolean urgent) {
	// 	this.product = product;
	// 	this.urgent = urgent;
	// }

	// 정적 팩토리 메서드로 이를 해결
	public static Order primeOrder(Product product) {
		Order order = new Order();
		order.product = product;
		order.prime = true;
		return order;
	}

	public static Order urgentOrder(Product product) {
		Order order = new Order();
		order.product = product;
		order.urgent = true;
		return order;
	}

	public static void main(String[] args) {
		Order order = new Order();
		// equals 보단 ==을 이용하여 비교 (equals는 NPE 발생 위험)
		if (order.orderStatus == OrderStatus.DELIVERED) {
			System.out.println("delivered");
		}

		// Enum을 key로 하는 Map 또는 Set을 쓸 때는 EnumMap, EnumSet을 사용하는게 성능상으로 더 좋음
		// 성능상 더 좋은 이유는, Enum으로 Key를 사용하면 값이 제한되있기 때문에 제한된 갯수만큼 Array로 선언해서 쓰면 되기 때문
		EnumMap<OrderStatus, String> map = new EnumMap<>(OrderStatus.class);
	}
}
