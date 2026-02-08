package com.practice.algorithm.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// Given a characters array tasks, representing the tasks a CPU needs to do, 
// where each letter represents a different task. Tasks could be done in any order.
//  Each task is done in one unit of time. 
// For each unit of time, the CPU could complete either one task or just be idle.
// However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
// Return the least number of units of times that the CPU will take to finish all the given tasks.  
//Example 1:
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: A -> B -> idle -> A -> B -> idle -> A -> B
//There is at least 2 units of time between any two same tasks.
//Example 2:
//Input: tasks = ["A","A","A","B","B","B"], n = 0
//Output: 6
//Explanation: On this case any permutation of size 6 would work since n is 0
//Example 3:
//Input: tasks = ["A","A","A","A","A","A","B","B","B","C","C","C"], n = 2
//Output: 16
//Explanation: One possible solution is: A -> B -> C -> A -> B -> C -> A -> B -> C -> A -> A -> A
//Constraints:
//1 <= task.length <= 104
//tasks[i] is an uppercase English letter.
//The integer n is in the range [0, 100].   
public class TaskScheduler {

    /*
    Explanation:
1. Count the frequency of each task and find the maximum frequency (maxCount) 
    and the number of tasks that have this maximum frequency (maxCountTasks).
2. The minimum time required to complete all tasks can be calculated using the formula:
   (maxCount - 1) * (n + 1) + maxCountTasks
   This formula accounts for the idle time needed to separate the most frequent
   tasks and the additional tasks that have the same maximum frequency.
3. Finally, we take the maximum of the total number of tasks and the calculated 
   minimum time to ensure that we account for cases where the number of tasks is
   greater than the calculated minimum time.

   //This is a greedy approach to solve the problem, as we are trying   
   // to schedule the most  frequent tasks first and then filling in the idle time 
   // with less frequent tasks.
   

   Time Complexity: O(N) where N is the number of tasks, since we need to count 
   the frequency of each task and find the maximum frequency.
   Space Complexity: O(1) since we are using a fixed-size array of length 26 
   to count the frequency of tasks, which does not grow with the input size.

    */
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        int maxCount = 0;
        for (int count : taskCounts) {
            maxCount = Math.max(maxCount, count);
        }

        int maxCountTasks = 0;
        for (int count : taskCounts) {
            if (count == maxCount) {
                maxCountTasks++;
            }
        }

        // We take the maximum of the total number of tasks and the calculated minimum time to ensure that 
        // we account for cases where the number of tasks is greater than the calculated minimum time.
        // The formula (maxCount - 1) * (n + 1) + maxCountTasks accounts for the idle time needed to separate the most 
        // frequent tasks and the additional tasks that have the same maximum frequency.
        // If the number of tasks is greater than the calculated minimum time, it means that we can schedule 
        // all tasks without needing to be idle, so we return the total number of tasks.
        // If the calculated minimum time is greater than the total number of tasks, it means that we need to be idle for some time
        //  to separate the most frequent tasks, so we return the calculated minimum time.  
        // This ensures that we are returning the correct minimum time to complete all tasks, whether it involves idle time or not.
        // For example, if we have tasks = ["A","A","A","B","B","B"] and n = 2, 
        // the maximum frequency is 3 (for task A and B), and there are 2 tasks with this maximum frequency.
        // The calculated minimum time would be (3 - 1) * (2 + 1) + 2 = 8, 
        // which is the correct minimum time to complete all tasks with the given cooldown period.  

        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + maxCountTasks); 
    }

    //Using Priority Queue approach
    /*
    Explanation:
1. Count the frequency of each task and store it in a max heap (priority queue) based 
   on the frequency of tasks.
2. Initialize a variable time to keep track of the total time taken to complete all tasks.
3. While there are still tasks in the priority queue:
   a. Create a temporary list to store tasks that are being processed in the current cycle.     
    b. For i from 0 to n (inclusive), do the following:
        i. If the priority queue is not empty, poll the task with the highest frequency and add it to the temporary list.
        ii. If the polled task's frequency is greater than 1, decrement its frequency and add it back to the priority queue.        
    c. Increment the time by 1 for each task processed in the current cycle. If there are still tasks in the priority queue 
      after processing, add idle time for the remaining cycles.           
4. Return the total time taken to complete all tasks.     

    Time Complexity: O(N log K) where N is the number of tasks and K is the number of unique tasks, since we are adding and removing tasks from the priority queue.     
    Space Complexity: O(K) where K is the number of unique tasks, since we are storing the frequency of each unique task in the priority queue.
    */
    public int leastIntervalPriorityQueue(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : taskCounts) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int count = maxHeap.poll();
                    if (count > 1) {
                        tempList.add(count - 1);
                    }
                }
                time++;
                if (maxHeap.isEmpty() && tempList.isEmpty()) {
                    break;
                }
            }
            for (int count : tempList) {
                maxHeap.offer(count);
            }
        }

        return time;
    }

        public static void main(String[] args) {
            TaskScheduler scheduler = new TaskScheduler();

            //Test cases for Greedy approach
            char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
            int n1 = 2;
            System.out.println("Minimum time to complete tasks: " + scheduler.leastInterval(tasks1, n1)); // Output: 8
        
            char[] tasks2 = {'A', 'A', 'A', 'B', 'B', 'B'};
            int n2 = 0;
            System.out.println("Minimum time to complete tasks: " + scheduler.leastInterval(tasks2, n2)); // Output: 6
    
            char[] tasks3 = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C'};
            int n3 = 2;
            System.out.println("Minimum time to complete tasks: " + scheduler.leastInterval(tasks3, n3)); // Output: 16

            //Test cases for Priority Queue approach
            System.out.println("Minimum time to complete tasks (Priority Queue): " + scheduler.leastIntervalPriorityQueue(tasks1, n1)); // Output: 8
            System.out.println("Minimum time to complete tasks (Priority Queue): " + scheduler.leastIntervalPriorityQueue(tasks2, n2)); // Output: 6
            System.out.println("Minimum time to complete tasks (Priority Queue): " + scheduler.leastIntervalPriorityQueue(tasks3, n3)); // Output: 16
        }

}
