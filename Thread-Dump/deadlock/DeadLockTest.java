package com.practice.deadlock;

public class DeadLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(()->{synchronized(A.class) {
			System.out.println("Thread1 locked A ****");
			try{
				Thread.sleep(1000);
			}catch(Exception ex) {
				
			}
			synchronized(B.class) {
				System.out.println("Thread1 locked B ****");
			}
		}}) ;
		
		Thread t2 = new Thread(()->{synchronized(B.class) {
			System.out.println("Thread2 locked B ****");
			try{
				Thread.sleep(1000);
			}catch(Exception ex) {
				
			}
			synchronized(A.class) {
				System.out.println("Thread2 locked A ****");
			}
		}});
		
		t1.start();
		t2.start();
	}


	
}
