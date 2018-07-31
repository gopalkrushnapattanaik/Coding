package com.practice.algorithm.array;

import java.util.Scanner;

/**
 * @author fq63
 *
 *
 *         Segregate even and odd numbers Given an array of integers, segregate
 *         even and odd numbers in the array. All the even numbers should be
 *         present first, and then the odd numbers.
 * 
 *         Examples:
 * 
 *         Input : 1 9 5 3 2 6 7 11 Output : 2 6 5 3 1 9 7 11
 * 
 *         Input : 1 3 2 4 7 6 9 10 Output : 2 4 6 10 7 1 9 3
 */
public class SegregateEvenOddNumbers {

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
		printArray(rearrangeEvenOdd(arr));
	}

	private static int[] rearrangeEvenOdd(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			/*
			 * start to scan from start of the array if even number found just increment the
			 * index
			 */
			while (arr[start] % 2 == 0 && start < end) {
				start++;
			}
			/*
			 * start scanning from end of array and if odd number found then just decrement
			 * the index
			 */
			while (arr[end] % 2 != 0 && start < end) {
				end--;
			}
			/*
			 * if start is < end and control reaches here it means we need to swap the
			 * positions as start index is now at odd number and vice versa
			 */
			if (start < end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		return arr;
	}

	 static void printArray(int arr[])
	    {
	        for (int i = 0; i < arr.length; i++)
	            System.out.print(arr[i]+" ");
	        System.out.println("");
	    }
	 

}
