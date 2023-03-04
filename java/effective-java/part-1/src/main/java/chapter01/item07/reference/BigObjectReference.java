package chapter01.item07.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class BigObjectReference<BigObject> extends PhantomReference<BigObject> {
	public BigObjectReference(BigObject referent, ReferenceQueue<? super BigObject> q) {
		super(referent, q);
	}

	// 클리어 되는 시점 확인하기
	@Override
	public void clear() {
		super.clear();
		System.out.println("clean up");
	}
}
