package com.practice.concurrency;

public class RWLockWithFairness {

    public double balance=1000.0;
    FairLock rwlock = new FairLock(false);

    public void checkBalance() throws InterruptedException{
        rwlock.readWriteLock.readLock().lock();; //shared lock
        try{
           System.out.println(Thread.currentThread().getName() + " checkedBalance: " + balance); 
            Thread.sleep(1000);
        }finally{
            rwlock.readWriteLock.readLock().unlock();
        }

    }

    public void deposit(double amount) throws InterruptedException{
        rwlock.readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + " depositing amount: " + amount); 
            balance+=amount;
            Thread.sleep(300);
        }finally{
             rwlock.readWriteLock.writeLock().unlock();
        }

    }

}
