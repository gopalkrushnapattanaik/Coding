package com.practice.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
giuven an unsorted array of integers, find the median of the array. 
The median is the middle value in an ordered integer list. 
If the size of the list is even, there is no middle value and 
the median is the mean of the two middle values.

Example 1:
Input: nums = [3,1,2]
Output: 2.00000
Explanation: After sorting the array, nums becomes [1,2,3]. The median is 2.
Example 2:
Input: nums = [1,2]
Output: 1.50000
Explanation: After sorting the array, nums becomes [1,2]. The median is (1 + 2) / 2 = 1.5.  

*/
public class MedianOfArray {
    
    public double findMedian(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array to find the median

        if (n % 2 == 1) {
            // If the number of elements is odd, return the middle element
            return nums[n / 2];
        } else {
            // If the number of elements is even, return the average of the two middle elements
            return (nums[n / 2 - 1] + nums[n / 2]) / 2.0;
        }
    }

    // Optimal approach: O(n log n) time complexity using two heaps
    // Explanation: We can use two heaps (a max heap and a min heap) 
    // to keep track of the smaller half and the larger half of the numbers in the array.  
    // The max heap will store the smaller half of the numbers and the min heap will store the larger half of the numbers.
    // We iterate through the array and add each number to the appropriate heap.
    // After adding each number, we balance the heaps so that their sizes differ at most by 1.
    // Finally, we can find the median based on the sizes of the heaps.       
    public double medianOfStream(int[] nums) {
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

        return (maxHeap.size() == minHeap.size()) ? (maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
    }

     public static void main(String[] args) {
         MedianOfArray obj = new MedianOfArray();
         int[] nums1 = {3,1,2};
         System.out.println("Median: " + obj.findMedian(nums1)); // Output: 2.00000

         int[] nums2 = {1,2};
         System.out.println("Median: " + obj.findMedian(nums2)); // Output: 1.50000
     }

}
