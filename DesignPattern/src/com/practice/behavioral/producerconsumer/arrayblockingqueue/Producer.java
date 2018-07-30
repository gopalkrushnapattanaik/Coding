package com.practice.behavioral.producerconsumer.arrayblockingqueue;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	ArrayList<Integer> list;
	AtomicInteger counter;
	int size;

	public Producer(ArrayList<Integer> list, int size, AtomicInteger counter) {
		this.list = list;
		this.size = size;
		this.counter = counter;
	}

	@Override
	public void run() {
		while (true) {
			try {
				produce(counter.get());
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			counter.incrementAndGet();
		}

	}

	private void produce(int i) throws InterruptedException {
		synchronized (list) {
			if (list.size() >= size) {
				System.out.println(
						"Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + list.size());
				list.wait();
			} else {
				Thread.sleep(500);
				list.add(i);
				System.out.println("Produced: " + i + " By :" + Thread.currentThread().getName());
				list.notifyAll();
			}
		}

	}

}
