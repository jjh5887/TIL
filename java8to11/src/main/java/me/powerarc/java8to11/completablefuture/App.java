package me.powerarc.java8to11.completablefuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		// executorService.submit(getRunnable("Thread"));

		// 실행을 완료하고 종료
		// executorService.shutdown();
		// 바로 종료
		// executorService.shutdownNow();

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
		// newFixedThreadPool.submit(getRunnable("Hello"));
		// newFixedThreadPool.submit(getRunnable("Kwonho"));
		// newFixedThreadPool.submit(getRunnable("The"));
		// newFixedThreadPool.submit(getRunnable("Java"));
		// newFixedThreadPool.submit(getRunnable("Thread"));

		// newFixedThreadPool.shutdown();

		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		// scheduledExecutorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);
		// scheduledExecutorService.shutdown();

		scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1,2, TimeUnit.SECONDS);


	}

	private static Runnable getRunnable(String message) {
		return () -> System.out.println(message + Thread.currentThread().getName());
	}
}
