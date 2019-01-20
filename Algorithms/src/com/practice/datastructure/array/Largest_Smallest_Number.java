package com.practice.datastructure.array;

import java.util.Scanner;

/**
 * @author fq63 Find the largest and smallest item in a array
 * 
 *         Suppose the largest and smallest item is first item then scan through
 *         the array and update the smallest and largest value
 * 
 */
public class Largest_Smallest_Number {

	public static void main(String[] args) {

		int n;
		int intArray[];

		// Taking inputs
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter number of elements in the array:");
			n = s.nextInt();
			intArray = new int[n];
			System.out.println("Enter elements of array:");
			for (int i = 0; i < n; i++) {
				intArray[i] = s.nextInt();
			}
		}

		System.out.println("largest number in array = " + largestNumber(intArray));
		System.out.println("smallest number in array = " + smallestNumber(intArray));

	}

	private static int largestNumber(int intArray[]) {
		int largest = intArray[0];

		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] > largest) {
				largest = intArray[i];
			}
		}
		return largest;
	}

	private static int smallestNumber(int intArray[]) {
		
		int smallest = intArray[0];

		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] < smallest) {
				smallest = intArray[i];
			}
		}
		return smallest;
	}

}
