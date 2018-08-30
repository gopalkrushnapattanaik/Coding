package com.practice.algorithm.array.sorting;

import java.util.Scanner;

public class BubbleSort {

	private static void printArray(int[] values) {
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}

		System.out.println("");
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Enter the length of the integer Array to be sorted");
			int length = s.nextInt();
			int inputArray[] = new int[length];
			System.out.println("Enter the elements of the integer Array to be sorted");

			for (int i = 0; i < length; i++) {
				inputArray[i] = s.nextInt();
			}

			System.out.println("intput Array :-");
			printArray(inputArray);

			int sortedArray[] = performBubbleSort(inputArray);

			System.out.println("output Array :-");
			printArray(sortedArray);

		}
	}

	/**
	 * @param inputArray
	 * @return
	 * 
	 * 		   There are 2 loops. The loop with the counter outer represents the
	 *         passes and continues for 0 to length – 1 times. ie. 1 less than the
	 *         number of items times.
	 * 
	 *         The loop with the counter inner represents the sorted element being
	 *         moved/bubbled forward. It continues from 0 to length-outer-1 times.
	 * 
	 *         This is because the size of the unsorted part of the array keeps
	 *         reducing in exact correlation with the number of passes completed i.e
	 *         number of elements sorted and put in their correct place.
	 *         
	 *         Space Complexity= Constant Space O(1)
	 *         Time Complexity= 2 loops -> O(N^2)
	 */
	private static int[] performBubbleSort(int[] inputArray) {

		for (int outer = 0; outer < inputArray.length; outer++) {
			for (int inner = 0; inner < inputArray.length - outer - 1; inner++) {
				if (inputArray[inner] > inputArray[inner + 1]) {
					int temp = inputArray[inner];
					inputArray[inner] = inputArray[inner + 1];
					inputArray[inner + 1] = temp;
				}
			}
		}

		return inputArray;
	}

}
