package com.practice.algorithm.array;

import java.util.Scanner;

/**
 * @author fq63
 * 
 *         Sort an array of 0s, 1s and 2s Given an array A[] consisting 0s, 1s
 *         and 2s, write a function that sorts A[]. The functions should put all
 *         0s first, then all 1s and all 2s in last.
 * 
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

	private static int[] seggregate012(int[] arr) {

		int start = 0;
		int mid = 0;
		int end = arr.length - 1;

		while (mid <= end) {
			switch (arr[mid]) {
			case 0:
				int temp = arr[start];
				arr[start] = arr[mid];
				arr[mid] = temp;
				start++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
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
