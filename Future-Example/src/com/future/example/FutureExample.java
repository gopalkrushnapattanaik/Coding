package com.future.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		ExecutorService ex = Executors.newFixedThreadPool(4);
		Future<String> future = ex.submit(new CustomTask());
		System.out.println("before getting result");
	
		System.out.println("result is " + future.get()); // This is Blocking call and the current thread blocks till
															// result is returned

		System.out.println("after getting result");

	}

}
