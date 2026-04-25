package com.practice.algorithm.prefixsum;
// Given an integer array arr[], find the subarray (containing at least one element) 
// which has the maximum possible sum, and return that sum.
// Note: A subarray is a continuous part of an array.

// Examples:

// Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
// Output: 11
// Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.

// Input: arr[] = [-2, -4]
// Output: -2
// Explanation: The subarray [-2] has the largest sum -2.

// Input: arr[] = [5, 4, 1, 7, 8]
// Output: 25
// Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.


//Explain : kadane's algorithm
// The idea is to maintain two variables, maxSoFar and maxEndingHere.
// maxEndingHere is the maximum sum of the subarray that ends at the current position.
// maxSoFar is the maximum sum of any subarray found so far.    
public class MaxSumSubArray {

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {2, 3, -8, 7, -1, 2, 3};
        System.out.println("Max Sum Subarray (Test case 1): " + maxSumSubArray(arr1)); // Expected output: 11       
        // Test case 2
        int[] arr2 = {-2, -4};
        System.out.println("Max Sum Subarray (Test case 2): " + maxSumSubArray(arr2)); // Expected output: -2       
        // Test case 3
        int[] arr3 = {5, 4, 1, 7, 8};
        System.out.println("Max Sum Subarray (Test case 3): " + maxSumSubArray(arr3)); // Expected output: 25   
    }

    public static int maxSumSubArray(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);       
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }       

}