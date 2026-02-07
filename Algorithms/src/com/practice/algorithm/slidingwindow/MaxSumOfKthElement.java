package com.practice.algorithm.slidingwindow;
// Max sum of k-th element in all subarrays of size k
// Given an array of integers and an integer k, find the maximum sum of the k-th
// element in all contiguous subarrays of size k.
// Example 1:
// Input: arr = [1, 3, 5, 2, 8, 7], k = 3
// Output: 15
// Explanation: The contiguous subarrays of size 3 are:
// [1, 3, 5] -> k-th element is 5
// [3, 5, 2] -> k-th element is 2
// [5, 2, 8] -> k-th element is 8
// [2, 8, 7] -> k-th element is 7
// The maximum sum of the k-th elements is 5 + 2 + 8 + 7 = 22.
// Example 2:
// Input: arr = [4, 2, 1, 6, 5, 3], k = 2
// Output: 14
// Explanation: The contiguous subarrays of size 2 are:
// [4, 2] -> k-th element is 2
// [2, 1] -> k-th element is 1
// [1, 6] -> k-th element is 6
// [6, 5] -> k-th element is 5
// [5, 3] -> k-th element is 3
// The maximum sum of the k-th elements is 2 + 1 + 6 + 5 + 3 = 17.
public class MaxSumOfKthElement {
    public int maxSumOfKthElement(int[] arr, int k) {
        int maxSum = 0;
        int n = arr.length;

        // Iterate through the array to get all subarrays of size k
        for (int i = 0; i <= n - k; i++) {
            // Add the k-th element of the current subarray to maxSum
            maxSum += arr[i + k - 1];
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumOfKthElement maxSumOfKthElement = new MaxSumOfKthElement();
        int[] arr1 = {1, 3, 5, 2, 8, 7};
        int k1 = 3;
        System.out.println("Max sum of k-th elements: " + maxSumOfKthElement.maxSumOfKthElement(arr1, k1)); // Output: 22

        int[] arr2 = {4, 2, 1, 6, 5, 3};
        int k2 = 2;
        System.out.println("Max sum of k-th elements: " + maxSumOfKthElement.maxSumOfKthElement(arr2, k2)); // Output: 17
    }
}
