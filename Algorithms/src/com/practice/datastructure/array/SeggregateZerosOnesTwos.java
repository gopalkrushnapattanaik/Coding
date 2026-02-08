package com.practice.datastructure.array;

import java.util.Scanner;

/**
 * @author fq63
 * 
 *         Sort an array of 0s, 1s and 2s Given an array A[] consisting 0s, 1s
 *         and 2s, write a function that sorts A[]. The functions should put all
 *         0s first, then all 1s and all 2s in last.
 * 			
 * 	   	Note:
 * 			 Do not use any sorting algorithm to solve this problem. 
 *           Do it in O(n) time complexity and using constant space.
 * 
 * 			This is Known as Dutch National Flag problem. 
 * 			The idea is to maintain three pointers low, mid and high.
 * 
 *         Examples:
 * 
 *         Input : {0, 1, 2, 0, 1, 2} 
 *         
 *         Output : {0, 0, 1, 1, 2, 2}
 * 
 *         Input : {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 *         
 *         Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 *
 */
public class SeggregateZerosOnesTwos {

	public static void main(String[] args) {
		int n;
		int[] arr;

		try (Scanner s = new Scanner(System.in)) {

			System.out.print("Enter number of elements in the array:");
			n = s.nextInt();
			arr = new int[n];

			System.out.println("Enter elements of array:");
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
		}
		printArray(seggregate012(arr));
	}

	//Time complexity: O(n) where n is the number of elements in the array. 
	// We traverse the array once.
	//Space complexity: O(1) as we are using only a constant amount of extra space 
	// for the three pointers.


	// Logic: We maintain three pointers low, mid and high.
	// low points to the next position of 0, mid points to the current element
	//  being processed, and high points to the next position of 2. We iterate 
	// through the array and swap elements based on the value at mid. If it's 0, 
	// we swap it with the element at
	private static int[] seggregate012(int[] arr) {
		//low pointer is used to keep track of the position 
		// where the next 0 should be placed.
		int start = 0;

		//mid pointer is used to traverse the array and process each element. 
		// It starts at the beginning of the array and moves forward until it reaches the end.
		int mid = 0; 

		//high pointer is used to keep track of the position where the next 2 should be placed.
		int end = arr.length - 1;

		while (mid <= end) { // We process elements until mid is less than or equal to end

			switch (arr[mid]) {  // We check the value at mid and perform actions based on whether it's 0, 1, or 2
			case 0:  // If the value at mid is 0, we swap it with the element at start and move both pointers forward
				int temp = arr[start];
				arr[start] = arr[mid];
				arr[mid] = temp;
				start++;
				mid++;
				break; //Is this break necessary? Yes, it is necessary to prevent fall-through to the next case.
			case 1: // If the value at mid is 1, we simply move the mid pointer forward as 1s are in the correct position
				mid++;
				break;
			case 2: // If the value at mid is 2, we swap it with the element at end and move the end pointer backward.
				int temp1 = arr[end];
				arr[end] = arr[mid];
				arr[mid] = temp1;
				end--;
				break;
			}

		}

		return arr;
	}

	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

}
