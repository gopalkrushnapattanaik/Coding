package com.practice.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class RWLockWithFairnessTester {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> balanceThreadList = new ArrayList<>();
         List<Thread> depositThreadList = new ArrayList<>();
        RWLockWithFairness rwLockWithFairness = new RWLockWithFairness();

        for(int i=0;i<10;i++){
            Thread t = new Thread(()->{
                try {
                    rwLockWithFairness.checkBalance();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
            t.setName("Check Ballance Thread"+i);
           balanceThreadList.add(t);
        }

        for(int i=0;i<5;i++){
            Thread t = new Thread(()->{
                try {
                    rwLockWithFairness.deposit(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
            t.setName("depsiting balance from Thread"+i);
           depositThreadList.add(t);
        }

         //run the balance and deposit threads in parallell

         new Thread(()->{
            balanceThreadList.forEach(t1->t1.start());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         }).start();;
        
        new Thread(()->{
            depositThreadList.forEach(t1->t1.start());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         }).start();;
        
    }

}
