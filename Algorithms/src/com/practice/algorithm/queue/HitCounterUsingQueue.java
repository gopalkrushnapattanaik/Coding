package com.practice.algorithm.queue;

import java.util.ArrayDeque;

// Design a hit counter which counts the number of hits received in the past 5 minutes (i.e., the past 300 seconds).
// Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being
// made to the system in chronological order (i.e., timestamp is monotonically increasing). You may assume that
// the earliest timestamp starts at 1. You may call the hit function several times with the same timestamp.
// Implement the HitCounter class:
// HitCounter() Initializes the object of the hit counter system.
// void hit(int timestamp) Records a hit that happened at timestamp (in seconds). Several hits may happen at the same timestamp.
// int getHits(int timestamp) Returns the number of hits in the
// past 5 minutes from the given timestamp (i.e., the past 300 seconds). The timestamp is in seconds granularity.
//Eg: Input
//["HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]
//[[], [1], [2], [3], [4], [300], [300], [301]]     
//Output
//[null, null, null, null, 3, null, 4, 3]
//Explanation
//HitCounter hitCounter = new HitCounter();
//hitCounter.hit(1);       // hit at timestamp 1.
//hitCounter.hit(2);       // hit at timestamp 2.
//hitCounter.hit(3);       // hit at timestamp 3.
//hitCounter.getHits(4);   // get hits at timestamp 4, returns 3.
//hitCounter.hit(300);     // hit at timestamp 300.
//hitCounter.getHits(300); // get hits at timestamp 300, returns 4.
//hitCounter.getHits(301); // get hits at timestamp 301, returns 3. The hit at timestamp 1 is now expired, while the hits at timestamps 2, 3, and 300 are still valid.
//Constraints:
//1 <= timestamp <= 2 * 109
//All the calls are being made to the system in chronological order (i.e., timestamp is monotonically increasing).
//At most 300 calls will be made to hit and getHits.    
public class HitCounterUsingQueue {

    ArrayDeque<Integer> queue; 

        public static void main(String [] args) {
            HitCounterUsingQueue hitCounter = new HitCounterUsingQueue();
            hitCounter.hit(1);       // hit at timestamp 1.
            hitCounter.hit(2);       // hit at timestamp 2.
            hitCounter.hit(3);       // hit at timestamp 3.
            System.out.println(hitCounter.getHits(4));   // get hits at timestamp 4, returns 3.
            hitCounter.hit(300);     // hit at timestamp 300.
            System.out.println(hitCounter.getHits(300)); // get hits at timestamp 300, returns 4.
            System.out.println(hitCounter.getHits(301)); // get hits at timestamp 301, returns 3. The hit at timestamp 1 is now expired, while the hits at timestamps 2, 3, and 300 are still valid.
        }   

        public HitCounterUsingQueue() {
            this.queue = new ArrayDeque<>();
        }
        public void hit(int timestamp) {
            this.queue.add(timestamp);
        }     
        
        public int getHits(int timestamp) {
            while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
                queue.poll();
            }
            return queue.size();
        }
    
}
