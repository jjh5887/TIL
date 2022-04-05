package me.powerarc.java8to11.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App4 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		boolean throwError = false;
		boolean throwErrorWorld = true;

		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			if (throwError) {
				throw new IllegalStateException();
			}
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}).exceptionally(ex -> { // 예외 처리
			System.out.println("Hello " + ex);
			return "Hello Error!";
		});

		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
			if (throwErrorWorld) {
				throw new IllegalStateException();
			}
			System.out.println("World " + Thread.currentThread().getName());
			return "World";
		}).handle((result, ex) -> { // result: 성공 결과값, ex: 에러
			if (ex != null) {
				System.out.println("World " + ex);
				return "World Error!";
			}
			return result;
		});

		// CompletableFuture<String> future = hello.thenCompose(App4::getWorld);
		// System.out.println(future.get());

		// CompletableFuture<String> completableFuture = hello.thenCombine(world, (h, w) -> h + " " + w);
		// System.out.println(completableFuture.get());

		// CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(hello, world)
		// 	.thenAccept(System.out::println); // null
		//
		// System.out.println(voidCompletableFuture.get()); // null

		// List<CompletableFuture<String>> completableFutures = Arrays.asList(hello, world);
		// CompletableFuture[] futures = completableFutures.toArray(
		// 	completableFutures.toArray(new CompletableFuture[completableFutures.size()]));
		// CompletableFuture<List<String>> results = CompletableFuture.allOf(futures)
		// 	.thenApply(v -> completableFutures.stream()
		// 		.map(CompletableFuture::join)
		// 		.collect(Collectors.toList()));

		// // results.get().forEach(System.out::println);

		CompletableFuture<Void> future = CompletableFuture.anyOf(hello, world)
			.thenAccept(System.out::println);
		future.get();

	}

	private static CompletableFuture<String> getWorld(String message) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + Thread.currentThread().getName());
			return message + "World";
		});
	}
}
