package com.practice.datastructure.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {

public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//Explain Logic of two heaps
//maxHeap to store the smaller half of the numbers
//minHeap to store the larger half of the numbers           
//This way, the median can be easily found from the tops of the heaps
//If the total number of elements is odd, maxHeap will have one extra element
//If even, both heaps will have equal number of elements
//This allows us to efficiently find the median in O(1) time after each insertion
//Adding a number takes O(log n) time due to heap insertions
//Overall, this approach ensures efficient median finding in a dynamic data stream
//while maintaining balanced heaps
public static void addNum(int num){
        //add the number to maxHeap
        maxHeap.add(num);
        
        //move the largest from maxHeap to minHeap to maintain invariant
        minHeap.add(maxHeap.poll());
        
        //balance the heaps: maxHeap should have equal or 1 more element than minHeap
        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }        
}

public static int findMedian(){
    //if the maxHeap has more elements, return the top of maxHeap
    if(maxHeap.size() > minHeap.size()){
        return maxHeap.peek();
    } else {
        //else the numbers are even, return the average of the tops of both heaps
        return (maxHeap.peek() + minHeap.peek()) / 2;
    }
}

public static void main (String[] args){
    addNum(1);
    System.out.println("Median after adding 1: " + findMedian()); // 1
    addNum(5);
    System.out.println("Median after adding 5: " + findMedian()); // 3
    addNum(2);
    System.out.println("Median after adding 2: " + findMedian()); // 2
    addNum(8);
    System.out.println("Median after adding 8: " + findMedian()); // 3.5
    addNum(3);
    System.out.println("Median after adding 3: " + findMedian()); // 3  
}

}
