package com.practice.behavioral.producerconsumer.waitnotify;

import java.util.ArrayList;

public class Consumer implements Runnable {

	ArrayList<Integer> list;
	int size;

	public Consumer(ArrayList<Integer> list, int size) {
		this.list = list;
		this.size = size;

	}

	@Override
	public void run() {

		while (true) {
			try {
				consume();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	public void consume() throws InterruptedException {

		int i = 0;
		synchronized (list) {
			if (list.isEmpty()) {
				System.out.println(
						"Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + list.size());
				list.wait();

			} else {
				Thread.sleep(500);
				System.out.println("Consumed " + list.get(i) + " By :" + Thread.currentThread().getName() );
				list.remove(i);
				i++;
				list.notifyAll();
			}

		}
	}

}
