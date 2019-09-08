package com.completablefuture.example;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		CompletableFuture<String> completableFuture = new CompletableFuture();

		completableFuture.complete("Hello");
		System.out.println(completableFuture.get());

		CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> "Hello")
				.thenApply(s -> s + "123");
		System.out.println(completableFuture1.get());

		// Use thenCompose() to chain the completableFutires to run one after another.
		CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> "Hello")
				.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "World"))
				.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "123"));

		System.out.println(completableFuture2.get());

		// n number of independent futures , once all executed separtely then only start
		// next process
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "first");

		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "second");

		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "third");

		CompletableFuture<String> combinedFuture = CompletableFuture.allOf(future1, future2, future3)
				.thenApply(s -> s + "Final");
		System.out.println(combinedFuture.get());
		
		
		//Start next completable future  once anyOf the futures completes
		
		CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return "fourth";});

		CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return "fifth";});

		CompletableFuture<String> future6 = CompletableFuture.supplyAsync(() -> {try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return "sixth";});
		
		CompletableFuture<Object> combinedFuture2 = CompletableFuture.anyOf(future4, future5, future6);
		
		System.out.println(combinedFuture2.get());
		
		
		//running Asynchronously a task using CompletableFuture.
		
		CompletableFuture<Void> cfs = CompletableFuture.runAsync(()->{try {
			System.out.println("sleeping for 2 sec......");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		System.out.println(cfs.isDone());
		System.out.println(cfs.get());
		System.out.println(cfs.isDone());
		
		
		
		//Completable Future using exceptions , callback will be executed in case of exception
		
		 Integer age= -1;
		CompletableFuture<Serializable> cfs1 = CompletableFuture.supplyAsync(() -> {
			if(age<0) {
				return new  IllegalArgumentException("Age cannot be negative");
			}else if(age <10){
				return "child";
			}else{
				return "Adult";
			}}).exceptionally(ex->{System.out.println("exception occured"+ex); return age ;});
			
		System.out.println("Result is"+cfs1.get());
		
		
	}
	
	

}
