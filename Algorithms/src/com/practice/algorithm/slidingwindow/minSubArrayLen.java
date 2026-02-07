package com.practice.algorithm.slidingwindow;
/*
Given an array of positive integers nums and a positive integer target, 
return the minimal length of a subarray whose sum is greater than or equal to target. 
If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */
public class minSubArrayLen {

    public static void main(String[] args) {
        minSubArrayLen obj = new minSubArrayLen();
        int target1 = 7;
        int[] nums1 = {2,3,1,2,4,3};
        System.out.println("Minimum subarray length: " + obj.minSubArray(target1, nums1)); // Output: 2

        int target2 = 4;
        int[] nums2 = {1,4,4};
        System.out.println("Minimum subarray length: " + obj.minSubArray(target2, nums2)); // Output: 1

        int target3 = 11;
        int[] nums3 = {1,1,1,1,1,1,1,1};
        System.out.println("Minimum subarray length: " + obj.minSubArray(target3, nums3)); // Output: 0
    }

    public int minSubArray(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < nums.length) {
            // Expand the window by adding the right element
            windowSum += nums[right];

            // Shrink the window from the left as long as the window sum is >= target
            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= nums[left];
                left++;
            }

            // Move the right pointer to expand the window
            right++;
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
    
    //analysed time complexity: O(n)
    //Explanation: 
    //  In the worst case, each element is visited twice (once by the right pointer and once by the left pointer),
    //  resulting in a linear time complexity of O(n), where n is the number of elements in the array.


    //analysed space complexity: O(1)
    //Explanation:
    //  We are using a constant amount of extra space for variables like left, right, windowSum, and minLength,
    //  regardless of the input size. Therefore, the space complexity is O(1).
}
