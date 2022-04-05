package me.powerarc.java8to11.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App3 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> future = new CompletableFuture<>();
		future.complete("kwonho");
		System.out.println(future.get());

		future = CompletableFuture.completedFuture("kwonho2");
		System.out.println(future.get());

		CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
		}).thenAccept((s) -> {
			System.out.println(Thread.currentThread().getName());
		}).thenRun(()-> {
			System.out.println("Hello Runnable");
		});

		System.out.println();
		// voidCompletableFuture.get();

		// CompletableFuture에 스레드 제공 가능
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}, executorService).thenApply((s) -> {
			System.out.println(Thread.currentThread().getName());
			return s.toUpperCase();
		}).thenApplyAsync((s)->{
			System.out.println(Thread.currentThread().getName());
			return s.toUpperCase();
		}, executorService);

		// System.out.println(supplyAsync.get());

		/**
		 * runAsync, supplyAsync에 있는 코드들은 get()을 호출하지 않더라도 main에서 스레드를 호출하면 실행 결과물을 볼 수 있다.
		 * 그 이유는 실제로는 Fork Join Pool로 가져온 쓰레드에서 runAsync, supplyAsync 코드를 바로 실행하기 때문
		 */
		Thread.sleep(1000L);

	}
}
