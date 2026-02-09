package com.practice.heap;

import java.util.PriorityQueue;

/*
Given an unsorted array of integers nums and an integer k, return the kth largest element in the array.

By kth largest element, we mean the kth largest element in the sorted order, not the kth distinct element.

Follow-up: Can you solve it without sorting?

Example 1:

Input: nums = [2,3,1,5,4], k = 2

Output: 4
Example 2:

Input: nums = [2,3,1,1,5,5,4], k = 3

Output: 4
Constraints:

1 <= k <= nums.length <= 10000
-1000 <= nums[i] <= 1000
 */

public class KthLargestElement {

    public int kthLargest(int[] nums, int k) {
        // Using a min heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num:nums){
            minHeap.add(num);
            // If the size of the min heap exceeds k, we remove the smallest element
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        return minHeap.poll(); // The root of the min heap will be the kth largest element
     
    }
    
     public static void main(String[] args) {
         KthLargestElement obj = new KthLargestElement();
         int[] nums1 = {2,3,1,5,4};
         int k1 = 2;
         System.out.println("Kth largest element: " + obj.kthLargest(nums1, k1)); // Output: 4

         int[] nums2 = {2,3,1,1,5,5,4};
         int k2 = 3;
         System.out.println("Kth largest element: " + obj.kthLargest(nums2, k2)); // Output: 4
     }
}
