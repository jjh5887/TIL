package me.powerarc.java8to11.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App2 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Callable<String> hello = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};

		Callable<String> java = () -> {
			Thread.sleep(3000L);
			return "Java";
		};

		Callable<String> kwonho = () -> {
			Thread.sleep(1000L);
			return "Kwonho";
		};

		// Future<String> helloFuture = executorService.submit(hello);
		// System.out.println(helloFuture.isDone());
		// System.out.println("Started!");
		//
		// helloFuture.cancel(false); // true: 취소, false: 기다림, 일단 cancel하면 get 불가능
		//
		// // helloFuture.get(); // 블록킹
		//
		// System.out.println(helloFuture.isDone());
		// System.out.println("End!!");
		// executorService.shutdown();

		List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, kwonho));
		for (Future<String> future : futures) {
			System.out.println(future.get());
		}

		System.out.println("=================");

		String s = executorService.invokeAny(Arrays.asList(hello, java, kwonho));
		System.out.println(s);

		executorService.shutdown();
	}
}
