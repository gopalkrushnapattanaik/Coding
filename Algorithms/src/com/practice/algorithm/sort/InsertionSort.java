package com.practice.algorithm.sort;

import java.util.Scanner;

public class InsertionSort {

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

			int sortedArray[] = performInsertionSort(inputArray);

			System.out.println("output Array :-");
			printArray(sortedArray);

		}
	}

	/**
	 * @param inputArray
	 * @return
	 * 
	 *         https://www.youtube.com/watch?v=OGzPmgsI-pQ
	 */
	private static int[] performInsertionSort(int[] inputArray) {

		int length = inputArray.length;
		int insert_key;
		int j;

		for (int i = 1; i < length; i++) {

			insert_key = inputArray[i];
			j = i - 1;

			while (j >= 0 && inputArray[j] > insert_key) {
				inputArray[j + 1] = inputArray[j];
				j = j - 1;
			}
			inputArray[j + 1] = insert_key;
		}
		return inputArray;
	}

}
