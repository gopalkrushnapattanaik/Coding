
package com.practice.concurrency.jobscheduler;


public class PaymentTask implements Task {


    @Override
    public void run() {
        System.out.println("Executing the Payment Task.......");
    }

}
