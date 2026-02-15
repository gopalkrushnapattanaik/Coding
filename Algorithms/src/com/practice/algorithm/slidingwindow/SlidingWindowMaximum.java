package com.practice.algorithm.slidingwindow;
/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left 
of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves
 right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    // Brute force approach: O(n*k) time complexity
    public int[] maxSlidingWindow_BruteForce(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int maxIndex = 0;

        // Find the maximum for the first window
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        result[0] = nums[maxIndex];

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            // If the maximum is out of the current window, find the new maximum
            if (maxIndex <= i - k) {
                maxIndex = i - k + 1;
                for (int j = maxIndex + 1; j <= i; j++) {
                    if (nums[j] > nums[maxIndex]) {
                        maxIndex = j;
                    }
                }
            } else if (nums[i] > nums[maxIndex]) { // If the new element is greater than the current maximum
                maxIndex = i;
            }
            result[i - k + 1] = nums[maxIndex];
        }

        return result;
    }

    //Optimal approach: O(n) time complexity using Deque
    // Explanation: We use a deque to store the indices of the elements in the current window
    // The deque will always have the indices of the elements in decreasing order of their values
    // When we slide the window, we remove the indices of the elements that are out of the current window
    // We also remove the indices of the elements that are smaller than the new element being added to the window,
    // as they will not be the maximum in the current window
    // The maximum element in the current window will always be at the front of the deque
    // Time Complexity: O(n) where n is the length of the input array, since we are iterating through the array once and 
    // each element is added and removed from the deque at most once.
    // Space Complexity: O(k) since we are storing at most k indices in the deque at any time.
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // Deque to store indices of elements in the current window

        for (int i = 0; i < n; i++) {
            // Remove indices of elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of elements that are smaller than the new element being added to the window
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the index of the new element to the deque
            deque.offerLast(i);

            // The maximum element in the current window is at the front of the deque
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
        
    }
}