package chapter01.item02.illegalargumentexception;

import java.time.LocalDate;

public class Order {
	// throws IllegalArgumentException, NullPointerException
	// 위와 같은 형태로 던지는 예외를 명시해도 되지만 가독성 때문에 추천 X
	// 일반적으론 Checked Exception 만 명시를 해줌
	public void updateDeliveryDate(LocalDate deliveryDate) {
		if (deliveryDate == null) {
			throw new NullPointerException("deliveryDate can't be null");
		}

		if (deliveryDate.isBefore(LocalDate.now())) {
			//TODO 과거로 배송 해달라고??
			throw new IllegalArgumentException("deliveryDate can't be earlier than " + LocalDate.now());
		}
	}
}
