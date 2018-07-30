package com.practice.behavioral.producerconsumer.arrayblockingqueue;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fq63
 * 
 *         This is a simple implementation of ArrayBlockingQueue
 * 
 *         There are n number of Producers and Consumers.
 * 
 *         Producers are producing numbers(1,2,3,4..) to a queue and consumers
 *         are consuming numbers as and when they are generated
 * 
 *         Producers should not produce when the size of queue is reached at a
 *         given size Consumers should wait for producers to produce if the
 *         queue is empty
 * 
 */
public class ProducerConsumerPattern {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		int size = 10;
		AtomicInteger counter = new AtomicInteger(0);
		int numOfThreads = 2;

		ArrayList<Thread> producerThreadList = new ArrayList<>();
		ArrayList<Thread> consumerThreadList = new ArrayList<>();

		// creating threads of producers and consumers
		for (int i = 0; i < numOfThreads; i++) {
			Producer p = new Producer(list, size, counter);
			Thread t1 = new Thread(p);
			t1.setName("Producer-Thread -" + i);
			producerThreadList.add(t1);

			Consumer c = new Consumer(list);
			Thread t2 = new Thread(c);
			t2.setName("Consumer-Thread -" + i);
			consumerThreadList.add(t2);
		}

		// starting producers
		for (Thread thread : producerThreadList) {
			thread.start();
		}

		// starting consumers
		for (Thread thread : consumerThreadList) {
			thread.start();
		}

	}

}
