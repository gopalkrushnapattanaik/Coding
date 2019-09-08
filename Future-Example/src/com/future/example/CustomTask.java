package com.future.example;

import java.util.concurrent.Callable;

public class CustomTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("before sleep");
		Thread.sleep(10500);
		 System.out.println("after sleep");
		return "Hello";
	}

}
