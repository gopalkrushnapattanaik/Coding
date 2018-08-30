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

	private static int[] performBubbleSort(int[] inputArray) {

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray.length - i - 1; j++) {
				if (inputArray[j] > inputArray[j + 1]) {
					int temp = inputArray[j];
					inputArray[j] = inputArray[j + 1];
					inputArray[j + 1] = temp;
				}
			}
		}

		return inputArray;
	}

}
