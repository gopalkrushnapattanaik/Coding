package com.practice.algorithm.slidingwindow;

// Max sum of subarray of size k
// Given an array of integers and an integer k, find the maximum sum of any contiguous subarray of size k.
// Example 1:
// Input: arr = [1, 3, 5, 2, 8, 7], k = 3
// Output: 17                   
public class MaxSumSubArrayOfK {
    public int maxSumSubArrayOfK(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;
        int left = 0;

        //sliding window approach
        for (int right = 0; right < arr.length; right++) {
            //add the current element to the window sum
            windowSum += arr[right];

            //check if we have hit the window size of k
            if (right >= k - 1) {
                //update the max sum if needed
                maxSum = Math.max(maxSum, windowSum);
                //subtract the element going out of the window
                windowSum -= arr[left];
                //slide the window forward
                left++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumSubArrayOfK maxSumSubArrayOfK = new MaxSumSubArrayOfK();
        int[] arr1 = {1, 3, 5, 2, 8, 7};
        int k1 = 3;
        System.out.println("Max sum of subarray of size k: " + maxSumSubArrayOfK.maxSumSubArrayOfK(arr1, k1)); // Output: 17

        int[] arr2 = {4, 2, 1, 6, 5, 3};
        int k2 = 2;
        System.out.println("Max sum of subarray of size k: " + maxSumSubArrayOfK.maxSumSubArrayOfK(arr2, k2)); // Output: 11
    }
}
