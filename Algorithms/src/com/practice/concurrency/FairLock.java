package com.practice.concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FairLock {

  ReentrantReadWriteLock readWriteLock ;

  public FairLock(boolean fairness){

    this.readWriteLock=new ReentrantReadWriteLock(fairness);
  }
}
