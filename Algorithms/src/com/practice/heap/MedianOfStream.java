package com.practice.heap;

import java.util.PriorityQueue;

/*
Median of Stream
Given a stream of integers, find the median of the stream at any given point in time.   
The median is the middle value in an ordered integer list. If the size of the list is even, 
the median is the average of the two middle values.
Example 1:
Input: stream = [5, 15, 1, 3]
Output: [5, 10, 5, 4]
Explanation:
After inserting 5, the stream is [5]. The median is 5.
After inserting 15, the stream is [5, 15]. The median is (5 + 15) / 2 = 10.
After inserting 1, the stream is [5, 15, 1]. The median is 5.
After inserting 3, the stream is [5, 15, 1, 3]. The median is (3 + 5) / 2 = 4.
Example 2:
Input: stream = [2, 4, 6, 8]
Output: [2, 3, 4, 5]
Explanation:
After inserting 2, the stream is [2]. The median is 2.
After inserting 4, the stream is [2, 4]. The median is (2   + 4) / 2 = 3.
After inserting 6, the stream is [2, 4, 6]. The median is 4.
After inserting 8, the stream is [2, 4, 6, 8]. The median is (4 + 6) / 2 = 5.       
*/
public class MedianOfStream {

        public double medianOfStream(int[] nums) {
            // We can use two heaps (a max heap and a min heap) to keep track of the smaller half and the larger half of the numbers in the stream.  
            // The max heap will store the smaller half of the numbers and the min heap will store the larger half of the numbers.
            // We iterate through the stream and add each number to the appropriate heap.
            // After adding each number, we balance the heaps so that their sizes differ at most by 1.
            // Finally, we can find the median based on the sizes of the heaps.       

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min heap to store the larger half of the numbers
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max heap to store the smaller half of the numbers 
        
            for (int num : nums) {
                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }

                // Balance the heaps so that their sizes differ at most by 1
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
            }
                return maxHeap.size() >= minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
        }   
        public static void main(String[] args) {
            MedianOfStream obj = new MedianOfStream();
            int[] stream1 = {5, 15, 1, 3};
            System.out.println("Median of stream: " + obj.medianOfStream(stream1)); // Output: [5, 10, 5, 4]    
            int[] stream2 = {2, 4, 6, 8};
            System.out.println("Median of stream: " + obj.medianOfStream(stream2)); // Output: [2, 3, 4, 5] 

            }   
}
