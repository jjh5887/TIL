package chapter01.item07.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {

	public static void main(String[] args) throws InterruptedException {
		BigObject strong = new BigObject();
		ReferenceQueue<BigObject> rq = new ReferenceQueue<>();

		// Phantom은 gc때 사라지지만 ReferenceQueue에 저장됨
		// 주로 자원 정리할 때 쓰지만, 차라리 try with resource를 사용하는게 나음
		// PhantomReference<BigObject> phantom = new PhantomReference<>(strong, rq);

		BigObjectReference<BigObject> phantom = new BigObjectReference<>(strong, rq);
		strong = null;

		System.gc();
		Thread.sleep(3000L);

		// TODO 팬텀은 유령이니까..
		//  죽었지만.. 사라지진 않고 큐에 들어갑니다.
		System.out.println(phantom.isEnqueued());

		Reference<? extends BigObject> reference = rq.poll();
		reference.clear();
	}
}
