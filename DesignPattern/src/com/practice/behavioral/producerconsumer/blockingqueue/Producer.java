package com.practice.behavioral.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue<Integer> sharedQueue;

	public Producer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			System.out.println("Producing to queue :" + i);
			sharedQueue.add(i);
		}
	}

}
