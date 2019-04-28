package com.practice.algorithm.sort;

import java.util.Scanner;

public class SelectionSort {

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

			int sortedArray[] = performSelectionSort(inputArray);

			System.out.println("output Array :-");
			printArray(sortedArray);

		}
	}

	/**
	 * @param inputArray
	 * @return
	 * 
	 *         https://www.youtube.com/watch?v=xWBP4lzkoyM
	 */
	private static int[] performSelectionSort(int[] inputArray) {

		for (int i = 0; i < inputArray.length; i++) {
			int local_min = inputArray[i];
			int swap_pos = i;
			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[j] < local_min) {
					local_min = inputArray[j];
					swap_pos = j;
				}
			}
			inputArray[swap_pos] = inputArray[i];
			inputArray[i] = local_min;
		}

		return inputArray;

	}

}
