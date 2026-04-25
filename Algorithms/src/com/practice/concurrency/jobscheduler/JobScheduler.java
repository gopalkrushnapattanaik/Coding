package com.practice.concurrency.jobscheduler;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;


public class JobScheduler {
    private PriorityBlockingQueue<Job> priorityQueue;
    private final ExecutorService pool;

    public JobScheduler(int capacity ,List<Job> jobs){
        this.pool = Executors.newFixedThreadPool(5);
        this.priorityQueue =  new PriorityBlockingQueue<>(capacity);
        jobs.forEach(job->this.priorityQueue.add(job)); //add Jobs to the queue according to schedule Time
    }

    public void executeJobs(){
        while(!priorityQueue.isEmpty()){
            long now = System.currentTimeMillis();
            Job jobToCheck = priorityQueue.peek(); //peek the lowest scheduleTime job
            if(now >= jobToCheck.getScheduleTime()){ //check if the job schedule time is now or in past
                //scheduleTime is in past so execute the jon
                Job jobToRun = priorityQueue.poll(); //remove the job from queue to execute
                try{
                    pool.submit(jobToRun.getTask()); //run the job in Thread Pool
                }catch(Exception ex){
                    System.out.println("Exception while performing Job :" + jobToRun.getJobId());
                }
            }else{
                try{
                Thread.sleep(500); // sleep for a while as jobs time not yet met
                }catch(InterruptedException iex){
                    System.out.println("InterruptedException .......");
                }
            }
         }
    }

}
