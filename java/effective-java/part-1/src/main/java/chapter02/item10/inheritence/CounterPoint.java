package chapter02.item10.inheritence;

import java.util.concurrent.atomic.AtomicInteger;

import chapter02.item10.Point;

public class CounterPoint extends Point {
	private static final AtomicInteger counter =
		new AtomicInteger();

	public CounterPoint(int x, int y) {
		super(x, y);
		counter.incrementAndGet();
	}

	public static int numberCreated() {
		return counter.get();
	}
}
