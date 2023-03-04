package chapter01.item07.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {

	public static void main(String[] args) throws InterruptedException {
		Object strong = new Object();

		// 메모리가 필요한 상황에 GC (물론 Strong Reference 없다는 전제하에)
		SoftReference<Object> soft = new SoftReference<>(strong);

		// Strong Reference 제거
		strong = null;

		System.gc();
		Thread.sleep(3000L);

		// TODO 거의 안 없어집니다.
		//  왜냐면 메모리가 충분해서.. 굳이 제거할 필요가 없으니까요.
		System.out.println(soft.get());
	}
}
