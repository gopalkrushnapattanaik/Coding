package com.practice.behavioral.producerconsumer.waitnotify;

import java.util.ArrayList;

public class Producer implements Runnable {

	ArrayList<Integer> list;
	int size;

	public Producer(ArrayList<Integer> list, int size) {
		this.list = list;
		this.size = size;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				produce(i++);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	private void produce(int i) throws InterruptedException {
		synchronized (list) {
			if (list.size() >= size) {
				System.out.println(
						"Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + list.size());
				list.wait();
			} else {
				Thread.sleep(1000);
				list.add(i);
				System.out.println("Produced: " + i +" By :" + Thread.currentThread().getName());
				list.notifyAll();
			}
		}

	}

}
