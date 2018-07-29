package com.practice.behavioral.producerconsumer.waitnotify;

import java.util.ArrayList;

public class ProducerConsumerPattern {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		int size = 10;

		Producer p = new Producer(list, size);
		Thread t1 = new Thread(p);
		t1.setName("Producer-Thread");
		t1.start();

		Consumer c = new Consumer(list, size);
		Thread t2 = new Thread(c);
		t2.setName("Consumer-Thread");
		t2.start();

	}

}
