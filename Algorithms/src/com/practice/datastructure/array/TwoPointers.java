package com.practice.datastructure.array;
/*

The two-pointer technique is a common algorithmic approach used to solve problems
involving arrays or linked lists, often reducing time complexity by avoiding nested loops.
It involves using two pointers (indices or references) to traverse the data structure,
typically from different positions or directions, to find a solution efficiently.

Key Concepts :
   Two Pointers: Two variables (pointers) track positions in the array or list,
    moving based on specific conditions.

   Common Use Cases: Problems involving searching, partitioning, or finding pairs/sequences
   that satisfy certain conditions.

   Time Complexity: Often reduces complexity from O(n²) to O(n) or O(n log n) by processing
   elements in a single pass or with sorted data.

   Space Complexity: Typically O(1) as it uses constant extra space (excluding input/output).

Types of Two-Pointer Techniques
      1. Opposite Ends (Left and Right):
               One pointer starts at the beginning (left), and the other at the end (right).
               They move toward each other based on conditions.

               Example: Finding a pair in a sorted array that sums to a target value.
              Common Problems:
                   1. Two Sum II (sorted array)
                   2. Reverse an array
                   3. Container With Most Water

     2. Fast and Slow Pointers:
               Both pointers start at the beginning; one moves faster (e.g., twice as fast) than the other.
               Used in linked lists or arrays to detect cycles or find midpoints.

                Example: Detecting a cycle in a linked list (Floyd’s Cycle Detection).

            Common Problems:
                1. Find the middle of a linked list
                2. Remove duplicates from a sorted array
                3. Detect cycle in a linked list


    3. Sliding Window (Variable/Fixed Size):
               Two pointers define a window that expands or contracts based on conditions.
               Often used for substring/subarray problems.

               Example: Finding the longest subarray with a sum less than or equal to a target.

                Common Problems:
                    1. Longest Substring Without Repeating Characters
                    2. Maximum Sum Subarray of Size K

 */
/*Example 1: Two Sum II (Sorted Array)
Problem: Given a sorted array and a target sum, find two numbers that add up to the target.
         Return their 1-based indices.

Java Solution (Opposite Ends Two-Pointer):

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                return new int[]{left + 1, right + 1}; // 1-based indexing
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{}; // Return empty array if no solution found
    }
}

Explanation: The array is sorted, so we use two pointers: left starts at the beginning,
and right at the end. If the sum of numbers[left] + numbers[right] equals the target,
return their 1-based indices. If the sum is too small, increment left to increase the sum;
if too large, decrement right to decrease it. Time complexity is O(n), and space complexity
is O(1) excluding the output array.

Example 2: Remove Duplicates from Sorted Array
Problem: Remove duplicates in-place from a sorted array and return the length of the new
array with unique elements.

Java Solution (Fast and Slow Pointers):

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

Explanation: Use two pointers: slow tracks the position where the next unique element
should be placed, and fast scans through the array. When nums[fast] is different from the
previous unique element (nums[slow - 1]), copy it to nums[slow] and increment slow. The
function returns the count of unique elements (slow). Time complexity is O(n),
and space complexity is O(1) as it modifies the array in-place.

*/
public class TwoPointers {
}
