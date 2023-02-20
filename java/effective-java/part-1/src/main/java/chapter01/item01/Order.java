package chapter01.item01;

public class Order {

	private boolean prime;

	private boolean urgent;

	private Product product;

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
}
