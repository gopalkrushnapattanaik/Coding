package com.practice.algorithm.array.sorting;

import java.util.Scanner;

/**
 * @author fq63
 * 
 *         The performMergeSort() method is responsible for merge sorting of a
 *         list of elements passed to it.
 * 
 *         It does the following –
 * 
 *         Divides the list passed to it into 2 lists – leftArray and
 *         rightArray.
 * 
 *         Recursively calls performMergeSort() on the left and right sub-arrays
 *         It merges the left and right sub-arrays by calling the merge() method.
 * 
 *         The boundary condition for this method is 1. I.e. if the size of the
 *         list being sorted by this method is 1 then the list is returned back
 *         as it is.
 * 
 *         The merge() method iterates over the two sub-lists left and right
 *         passed to it and merges them in the correct sorting order.
 * 
 *         Mechanism of merging –
 * 
 *         Merging of the sub-lists works as follows –
 * 
 *         Both of the sub-lists are read with individual pointers.
 * 
 *         The elements at the heads of the two sub-lists are compared and the
 *         lesser one is picked and pushed into a third list , called say the
 *         merged-list.
 * 
 *         The pointer for the sub-list from which the element was picked is
 *         moved forward to point to the next element.
 * 
 *         The main() method orchestrates the sorting. The instance element
 *         inputArray[] holds the list to be sorted.
 * 
 *         Time Complexity :- O(NlogN)
 *
 */
public class MergeSort {

	public static int[] performMergeSort(int[] values) {

		// Boundary condition ,divide the arrays till sub Array have 1 element
		if (values.length <= 1) {
			return values;
		}

		// decide the sub array lengths
		int leftLength = values.length / 2;
		int rightLength = values.length - leftLength;

		// initalise the left and right arrays
		int leftArray[] = new int[leftLength];
		int rightArray[] = new int[rightLength];

		// populate left array
		for (int leftCount = 0; leftCount < leftLength; leftCount++) {
			leftArray[leftCount] = values[leftCount];
		}

		// populate right array
		for (int rightCount = 0; rightCount < rightLength; rightCount++) {
			rightArray[rightCount] = values[leftLength + rightCount];
		}

		return merge(performMergeSort(leftArray), performMergeSort(rightArray));

	}

	private static int[] merge(int[] leftArray, int[] rightArray) {

		// initialize the merged array
		int mergedArray[] = new int[leftArray.length + rightArray.length];
		int leftCount = 0;
		int rightCount = 0;
		int mergedCount = 0;

		// compare left and right array and sort them
		while (leftCount < leftArray.length && rightCount < rightArray.length) {
			if (leftArray[leftCount] <= rightArray[rightCount]) {
				mergedArray[mergedCount] = leftArray[leftCount];
				mergedCount++;
				leftCount++;
			} else {
				mergedArray[mergedCount] = rightArray[rightCount];
				mergedCount++;
				rightCount++;
			}

		}
		// once one of the array exhausted just append the rest elements in merged array
		// from the remaining elements
		while (leftCount < leftArray.length) {
			mergedArray[mergedCount] = leftArray[leftCount];
			mergedCount++;
			leftCount++;
		}

		while (rightCount < rightArray.length) {
			mergedArray[mergedCount] = rightArray[rightCount];
			mergedCount++;
			rightCount++;
		}

		return mergedArray;
	}

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

			int sortedArray[] = performMergeSort(inputArray);

			System.out.println("output Array :-");
			printArray(sortedArray);

		}
	}

}
