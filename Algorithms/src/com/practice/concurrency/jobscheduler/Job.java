package com.practice.concurrency.jobscheduler;
import java.util.UUID;

public class Job implements Comparable<Job>{

    private long scheduleTime;
    private String jobId;
    private Task task;

    
    public Job(Task task, long scheduleTime ){
        this.jobId= UUID.randomUUID().toString();
        this.task = task;
        this.scheduleTime = scheduleTime;
    }   

    //Execute the Task
    public void execute(){
        System.out.println("Executing jobId : "+ jobId);
        this.task.run();
    }

    public long getScheduleTime() {
        return scheduleTime;
    }

    public String getJobId() {
        return jobId;
    }

    public Task getTask() {
        return task;
    }

    // Comparator to priortise earlier Tasks to run first
    @Override
    public int compareTo(Job otherJob) {
        return Long.compare(this.scheduleTime, otherJob.scheduleTime);
    }

    

}
