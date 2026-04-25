package com.practice.concurrency.jobscheduler;

public class EmailTask implements Task {

    @Override
    public void run() {
            System.out.println("Executing the Email Task.......");
    }

}
