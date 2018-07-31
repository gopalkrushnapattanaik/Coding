package com.practice.algorithm.array;

import java.util.Scanner;

/**
 * @author fq63
 * 
 *         logically divide the array to 2 parts at the index of rotation factor
 * 
 *         1. reverse first logical half 
 *         2. reverse second logical half
 *         3.reverse the whole array
 *
 */
public class RotateArray {

	public static void main(String[] args) {

		// input array
		int[] arr;
		// input array length;
		int n;
		// rotationFactor
		int rotationFactor;

		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter number of elements in the array:");
			n = s.nextInt();
			arr = new int[n];

			System.out.println("Enter elements of array:");
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			System.out.print("Enter rotation factor:");
			rotationFactor = s.nextInt();
		}
		
		System.out.println("Array Before rotation....");
		printArray(arr);

		// 1. reverse first logical half
		reverseArray(arr, 0, rotationFactor - 1);

		// 2. reverse second logical half
		reverseArray(arr, rotationFactor, arr.length - 1);

		// 3. reverse the whole array
		reverseArray(arr, 0, arr.length - 1);

		System.out.println("Array After rotation by rotationFactor " + rotationFactor +"....");
		printArray(arr);
	}

	// reverse the sub array from index start to index end.
	private static void reverseArray(int[] arr, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
	 static void printArray(int arr[])
	    {
	        for (int i = 0; i < arr.length; i++)
	            System.out.print(arr[i]+" ");
	        System.out.println("");
	    }

}
