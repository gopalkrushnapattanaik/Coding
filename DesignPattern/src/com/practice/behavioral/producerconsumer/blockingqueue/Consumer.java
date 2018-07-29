package com.practice.behavioral.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer> sharedQueue;

	public Consumer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {

		while (true) {
			try {
				System.out.println("consuming from  queue :" + sharedQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
