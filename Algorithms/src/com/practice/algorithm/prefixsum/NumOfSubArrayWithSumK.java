package com.practice.algorithm.prefixsum;
// Given an integer array arr[] and an integer k,
//find how many subarrays with sum equal to k are present in the array. 
//Algorithm should be of O(n) time complexity. 
public class NumOfSubArrayWithSumK {
 

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        System.out.println("Number of subarrays with sum " + k + ": " + numOfSubarraysWithSumK(arr, k)); // Expected output: 2
        System.out.println("Number of subarrays with sum " + k + " (Optimised): " + numOfSubarraysWithSumKOptimised(arr, k)); // Expected output: 2
    }

    //Time Complexity: O(n^2)
    public static int numOfSubarraysWithSumK(int[] arr, int k) {
        int count = 0;
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    //Helper method to create prefix sum array
    public static int[] prefixSumArray(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];

        for (int i = 1; i < n; i++) { 
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }

    //Time Complexity: O(n)
    //using prefixSum and HashMap to store the frequency of prefix sums
    public static int numOfSubarraysWithSumKOptimised(int[] arr, int k) {
        int count = 0;
        int[] prefixSum = prefixSumArray(arr);

        // HashMap to store the frequency of prefix sums
        java.util.HashMap<Integer, Integer> prefixSumFrequency = new java.util.HashMap<>();
        prefixSumFrequency.put(0, 1); // Base case: there's one way to have a prefix sum of 0 (by taking no elements)   
        for (int sum : prefixSum) {
            int complement = sum - k;
            if (prefixSumFrequency.containsKey(complement)) {
                count += prefixSumFrequency.get(complement);
            }
            prefixSumFrequency.put(sum, prefixSumFrequency.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}