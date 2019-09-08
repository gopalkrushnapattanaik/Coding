package com.completablefuture.example;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		// Default Constructor
		CompletableFuture<String> completableFuture = new CompletableFuture();
		completableFuture.complete("Hello");
		System.out.println(completableFuture.get());

		// Execute Computation Asyncronously using supplySync , this returns value
		CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> "Hello")
				.thenApply(s -> s + "123");
		System.out.println(completableFuture1.get());

		// Execute Computation Async way but no need to return value then use runAsync
		CompletableFuture.runAsync(() -> System.out.println("Asynchronous CFS"));
		

		// Use thenCompose() to chain the completableFutires to run one after another.
		CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> "Hello")
				.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "World"))
				.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "123"));

		System.out.println(completableFuture2.get());

		// n number of independent futures , once all executed separtely then only start
		// next process using allOff
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "first");

		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "second");

		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "third");

		CompletableFuture.allOf(future1, future2, future3);
		// allOf doesn't return results of threads ,just returns a void
		// completableFuture
		// which can be chained further
		CompletableFuture.runAsync(() -> System.out.println("All f1 f2 f3 finished"));

		// After calling allOf , it will finish execution of all future tasks and them
		// use join to get results and collect them in to a List
		List<String> futureResults = Stream.of(future1, future2, future3).map(f -> f.join())
				.collect(Collectors.toList());

		// Print the results from all futures
		CompletableFuture.runAsync(() -> System.out.println("results from f1,f2,f3" + futureResults));

		// Start next completable future once anyOf the futures completes

		CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "fourth";
		});

		CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "fifth";
		});

		CompletableFuture<String> future6 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "sixth";
		});

		CompletableFuture<Object> combinedFuture2 = CompletableFuture.anyOf(future4, future5, future6);

		System.out.println(combinedFuture2.get());

		// running Asynchronously a task using CompletableFuture.

		CompletableFuture<Void> cfs = CompletableFuture.runAsync(() -> {
			try {
				System.out.println("sleeping for 2 sec......");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println(cfs.isDone());
		System.out.println(cfs.get());
		System.out.println(cfs.isDone());

		// Completable Future using exceptions , callback will be executed in case of
		// exception

		Integer age = -1;
		CompletableFuture<Serializable> cfs1 = CompletableFuture.supplyAsync(() -> {
			if (age < 0) {
				return new IllegalArgumentException("Age cannot be negative");
			} else if (age < 10) {
				return "child";
			} else {
				return "Adult";
			}
		}).exceptionally(ex -> {
			System.out.println("exception occured" + ex);
			return age;
		});

		System.out.println("Result is" + cfs1.get());

	}

}
