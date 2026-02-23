package com.practice.datastructure.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/*
Second Greater Element
Given an array of integers, find the second greater element for each element in the array.
 The second greater element for an element x is the first greater element on the right side
 of x in the array that is greater than the next greater element of x. If there is no such
 element, the second greater element is -1. 

Example 1:
Input: arr = [2, 4, 0, 9, 6]
Output: [9, 6, 6, -1, -1]
Explanation:
For element 2, the next greater element is 4 and the second greater element is 9.
For element 4, the next greater element is 9 and the second greater element is 6.
For element 0, the next greater element is 9 and the second greater element is 6.
For element 9, there is no next greater element, so the second greater element is -1.
For element 6, there is no next greater element, so the second greater element is -1.
Example 2:
Input: arr = [3, 1, 5, 0, 2]
Output: [-1, 2, -1, -1, -1]
Explanation:
For element 3, the next greater element is 5 and the second greater element is -    
1.
For element 1, the next greater element is 5 and the second greater element is 2.
For element 5, there is no next greater element, so the second greater element is -1.
For element 0, the next greater element is 2 and the second greater element is -1.
For element 2, there is no next greater element, so the second greater element is -1.

*/
public class SecondGreaterElement {

    /*
     * Find the second greater element for each element in the array.
        * Time Complexity: O(n)
        * Space Complexity: O(n)
        * Explanation:
        We can use two stacks to keep track of the indices of the elements
        for which we haven't found the next greater element and the second greater
        element yet. We iterate through the array and for each element, we check 
        if the current element is greater than the element at the index on the top of
        the second stack. If it is, we pop from the second stack and update the answer 
        for that index. Then we check if the current element is greater than the element 
        at the index on the top of the first stack. If it is, we pop from the first stack 
        and push that index onto the second stack. Finally, we push the current index onto
        the first stack. This way, we can find both the next greater element and the second
        greater element in one pass through the array.

     */
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

    // s1: looking for the 1st greater element
    // s2: looking for the 2nd greater element
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    Stack<Integer> tmp = new Stack<>(); // The "Buffer"

    for (int i = 0; i < n; i++) {
        // 1. Check if current nums[i] is the SECOND greater element for s2
        while (!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
            ans[s2.pop()] = nums[i];
        }

        // 2. Check if current nums[i] is the FIRST greater element for s1
        // If it is, move those indices to the "waiting room" (tmp)
        while (!s1.isEmpty() && nums[s1.peek()] < nums[i]) {
            tmp.push(s1.pop());
        }

        // 3. Move from tmp to s2. 
        // We use tmp to ensure s2 stays sorted (largest values at the bottom)
        while (!tmp.isEmpty()) {
            s2.push(tmp.pop());
        }

        // 4. Current element starts its journey in s1
        s1.push(i);
    }

    return ans;
    }

    public static void main(String[] args) {
        SecondGreaterElement obj = new SecondGreaterElement();
        int[] arr1 = {2, 4, 0, 9, 6};
        System.out.println("Second greater elements: " + Arrays.toString(obj.secondGreaterElement(arr1))); // Output: [9, 6, 6, -1, -1]
        int[] arr2 = {3, 1, 5, 0, 2};
        System.out.println("Second greater elements: " + Arrays.toString(obj.secondGreaterElement(arr2))); // Output: [-1, 2, -1, -1, -1]
    }

}
