package com.practice.algorithm.array;

import java.util.Scanner;

/**
 * @author fq63 find local maximas in an array
 * 
 *         an element in array is called maxima if it is greater than its
 *         previous and next element
 *
 */
public class Local_Maxima {

	public static void main(String[] args) {
		int n;
		int intArray[];

		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter number of elements in the array:");
			n = s.nextInt();
			intArray = new int[n];

			System.out.println("Enter elements of array:");
			for (int i = 0; i < n; i++) {
				intArray[i] = s.nextInt();
			}
		}

		findMaximas(intArray, n);
	}

	private static void findMaximas(int[] intArray, int n) {

		for (int i = 1; i < n - 1; i++) {

			if (intArray[i] > intArray[i - 1] && intArray[i] > intArray[i + 1]) {
				System.out.println("Local_Maxima is " + intArray[i]);
			}
		}
	}
}
