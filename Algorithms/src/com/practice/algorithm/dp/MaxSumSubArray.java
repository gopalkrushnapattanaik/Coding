package com.practice.algorithm.dp;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) 
which has the largest sum and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The contiguous subarray [4,-1,2,1] has the largest sum = 6.        
Example 2:
Input: nums = [1]
Output: 1
Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23  

*/
// Kadane's Algorithm
public class MaxSumSubArray {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer
        int currentSum = 0; // This will store the sum of the current subarray

        for (int num : nums) {
            currentSum += num; // Add the current number to the current sum

            // Update maxSum if currentSum is greater than maxSum
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // If currentSum drops below 0, reset it to 0
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum; // Return the maximum sum found
    }

    // Another implementation of Kadane's Algorithm without resetting currentSum to 0
    // This implementation keeps track of the maximum sum ending at the current index and the maximum sum found so far.
    // This approach is more efficient as it avoids the need to reset currentSum to 0 and can handle cases 
    // where all numbers are negative.

    // Explanation:
    // 1. We initialize two variables: maxSumEndingHere to store the maximum sum ending at the current index, 
    //    and maxSumSoFar to store the maximum sum found so far.        

    // 2. We iterate through the array starting from the second element, and for each element, we update maxSumEndingHere 
    //    to be the maximum of the current element itself or the sum of maxSumEndingHere and the current element. 
    //    This step decides whether to start a new subarray at the current element or to continue the existing subarray.

    // 3. We then update maxSumSoFar to be the maximum of maxSumEndingHere and maxSumSoFar. This step keeps track 
    //    of the maximum sum found so far.
    
    // 4. Finally, we return maxSumSoFar, which contains the largest sum of a contiguous subarray found in the input array.

    // Time Complexity: O(n) where n is the length of the input array, since we are iterating through the array once.
    // Space Complexity: O(1) since we are using only a constant amount of extra space.
     public int maxSubArray_(int[] nums) {
        int maxSumEndingHere=nums[0];
        int maxSumSoFar=nums[0];

        for(int i=1;i<nums.length;i++){
            maxSumEndingHere= Math.max(nums[i],maxSumEndingHere+nums[i]);
            maxSumSoFar=Math.max(maxSumEndingHere,maxSumSoFar);
        }
        return maxSumSoFar;
     }


    // Explanation of Kadane's Algorithm:
    // 1. We initialize two variables: maxSum to store the maximum sum found so far, 
    // and currentSum to store the sum of the current subarray we are evaluating.
    // 2. We iterate through each number in the input array, adding it to currentSum.
    // 3. After adding the current number to currentSum, we check if currentSum is greater than maxSum.
    //    If it is, we update maxSum to be the value of currentSum.
    // 4. If at any point currentSum drops below 0, we reset it to 0, 
    // because a negative sum would not contribute to a maximum sum in future iterations.
    // 5. Finally, we return maxSum, which contains the largest sum of a contiguous subarray found in the input array.      

    public static void main(String[] args) {
        MaxSumSubArray maxSumSubArray = new MaxSumSubArray();
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum subarray sum: " + maxSumSubArray.maxSubArray(nums1)); // Output: 6
         System.out.println("Maximum subarray sum: " + maxSumSubArray.maxSubArray_(nums1)); // Output: 6
        

        int[] nums2 = {1};
        System.out.println("Maximum subarray sum: " + maxSumSubArray.maxSubArray(nums2)); // Output: 1
           System.out.println("Maximum subarray sum: " + maxSumSubArray.maxSubArray_(nums2)); // Output: 1

        int[] nums3 = {5,4,-1,7,8};
        System.out.println("Maximum subarray sum: " + maxSumSubArray.maxSubArray(nums3)); // Output: 23
           System.out.println("Maximum subarray sum: " + maxSumSubArray.maxSubArray_(nums3)); // Output: 1
    }

}
