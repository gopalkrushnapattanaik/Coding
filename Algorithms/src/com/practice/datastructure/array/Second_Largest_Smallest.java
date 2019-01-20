package com.practice.datastructure.array;

import java.util.Arrays;
import java.util.Scanner;

public class Second_Largest_Smallest {

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
		Arrays.sort(intArray);

		System.out.println("Second largest number in array = " + intArray[n - 2]);
		System.out.println("Second smallest number in array = " + intArray[1]);

		// similarly Kth largest and Kth smallest can be found

	}

}
