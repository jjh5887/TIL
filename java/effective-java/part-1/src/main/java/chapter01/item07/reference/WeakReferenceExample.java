package chapter01.item07.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {

	public static void main(String[] args) throws InterruptedException {
		Object strong = new Object();

		// gc가 일어나면 바로 사라짐 (물론 Strong Reference 없다는 전제하에)
		// Soft 보다 약한
		WeakReference<Object> weak = new WeakReference<>(strong);

		// Strong Reference 제거
		strong = null;

		System.gc();
		Thread.sleep(3000L);

		// TODO 거의 없어집니다.
		//  왜냐면 약하니까(?)...
		System.out.println(weak.get());
	}
}
