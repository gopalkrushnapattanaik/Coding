package com.practice.concurrency.jobscheduler;

import java.util.ArrayList;
import java.util.List;

public class JobSchedulerTester {

    long delay = 3000;
    List<Job> jobList = new ArrayList<>();

    Job job1 = new Job(new PaymentTask(), System.currentTimeMillis()+delay);
    Job job2 = new Job(new PaymentTask(), System.currentTimeMillis()+delay);
    jobList.add(job1);
    jobList.add(job2);


}
