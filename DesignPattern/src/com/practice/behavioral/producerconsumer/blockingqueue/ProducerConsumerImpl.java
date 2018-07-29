package com.practice.behavioral.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerImpl {

	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

		Thread t1 = new Thread(new Producer(sharedQueue));
		t1.start();

		Thread t2 = new Thread(new Consumer(sharedQueue));
		t2.start();

	}

}
