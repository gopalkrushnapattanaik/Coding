package com.practice.datastructure.array;

import java.util.ArrayDeque;

/*

Find Next Greater Element
Given an array of integers, find the next greater element for each element in the array. 
The next greater element for an element x is the first greater element on the right side of x in the array. 
If there is no greater element on the right side, then the next greater element for x is -1.

Example 1:
Input: arr = [4, 5, 2, 10]
Output: [5, 10, 10, -1]
Explanation:
The next greater element for 4 is 5.
The next greater element for 5 is 10.
The next greater element for 2 is 10.
The next greater element for 10 is -1 since there is no greater element on the right side.
Example 2:
Input: arr = [3, 7, 1, 8]
Output: [7, 8, 8, -1]
Explanation:
The next greater element for 3 is 7.
The next greater element for 7 is 8.
The next greater element for 1 is 8.
The next greater element for 8 is -1 since there is no greater element on the right side.   

*/
public class FindNextGreaterElement {

    /* 
        Find the next greater element for each element in the array
        Time Complexity: O(n^2)
        Space Complexity: O(n)
    */
    public int [] nextgreaterElements(int [] arr) {
        int n = arr.length;
        int [] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = -1; // Initialize all elements to -1
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j]; // Update the next greater element
                    break; // Break the inner loop once we find the next greater element
                }
           }
       }
        return result;
    }
    
     /* 
        Optimized approach using stack to find the next greater element for each element in the array
        Time Complexity: O(n)
        Space Complexity: O(n)

        Explanation:
        We can use a stack to keep track of the indices of the elements for which
        we haven't found the next greater element yet. We iterate through the array and for each element, 
        we check if the current element is greater than the element at the index on the top of the stack. 
        If it is, we pop the index from the stack and update the result for that index.
        We continue this process until we find a greater element or the stack is empty. 
        Finally, we push the current index onto the stack.  
    */

    public int[] nextGreaterElementsOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    //https://www.geeksforgeeks.org/dsa/next-greater-element/
  
    public int[] NextgrtElement(int[] nums) {
       int n = nums.length; 
       int[] result = new int[n];   
       ArrayDeque<Integer> stack = new ArrayDeque<>();  
       for (int i = 0; i < n; i++) {    
           result[i] = -1;  
       }    
       for (int i = n - 1; i >= 0; i--) {
           while (!stack.isEmpty() && stack.peek() <= nums[i]) {
               stack.pop();
           }
           if (!stack.isEmpty()) {
               result[i] = nums[i];
           }
           stack.push(nums[i]);
       }
       return result;
    }

    public static void main(String[] args) {
        FindNextGreaterElement obj = new FindNextGreaterElement();
        int [] arr1 = {4, 5, 2, 10};
        int [] result1 = obj.nextgreaterElements(arr1);
        System.out.print("Next greater elements for arr1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int [] arr2 = {3, 7, 1, 8};
        int [] result2 = obj.nextgreaterElements(arr2);
        System.out.print("Next greater elements for arr2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();

        int [] arr3 = {3, 7, 1, 8};
        int [] result3 = obj.nextgreaterElements(arr3);
        System.out.print("Next greater elements for arr3: ");
        for (int num : result3 ) {
            System.out.print(num + " ");
        }
    }
}
