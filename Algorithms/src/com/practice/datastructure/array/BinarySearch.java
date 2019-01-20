package com.practice.datastructure.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fq63
 * 
 *         for binary search the requirement is the input array should be a
 *         sorted array , so we are sorting the array once input is entered
 * 
 *
 *         1.check the middle element of the array if it matches the value then
 *         return true 
 *         2.if the value is more than middle element than search in
 *         the right half of array 
 *         3.if the value is less than middle element
 *         than search in the left half of array
 *
 *
 *
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		// length of array
		int n;
		// input array
		int[] intArray;
		// value to be searched
		int value;

		// Scanner is a resource so we are using try-with-resource to close it after use
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter number of elements in the array:");
			n = s.nextInt();
			intArray = new int[n];

			System.out.println("Enter elements of array:");
			for (int i = 0; i < n; i++) {
				intArray[i] = s.nextInt();
			}
			System.out.print("Enter the value to be searched:");
			value = s.nextInt();
		}

		// Sort the array as the binary search can be done only on sorted array
		Arrays.sort(intArray);

		System.out.println("found ::: " + binarySearch(intArray, value, intArray.length));
		System.out.println("found ::: " + binarySearchRecursive(intArray, value, 0, intArray.length));

	}

	// divide and conquer
	private static boolean binarySearch(int[] intArray, int value, int length) {

		int low = 0;
		int high = length - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			// 1.check the middle element of the array if it matches the value then return
			// true
			if (intArray[mid] == value) {
				return true;
			}
			// 3.if the value is less than middle element than search in the left half
			else if (intArray[mid] > value) {
				high = mid - 1;
			}
			// 2.if the value is more than middle element than search in the right half
			else {
				low = mid + 1;
			}
		}
		return false;
	}

	private static boolean binarySearchRecursive(int[] intArray, int value, int low, int high) {

		// Recursive Termination condition
		if (low > high) {
			return false;
		}

		int mid = (low + high) / 2;

		// value found so return true to exit
		if (intArray[mid] == value) {
			return true;
		}

		// if the value is less than middle element than search in the left half
		if (intArray[mid] > value) {
			high = mid - 1;
			return binarySearchRecursive(intArray, value, low, high);
		}
		// if the value is more than middle element than search in the left half
		else if (intArray[mid] < value) {
			low = mid + 1;
			return binarySearchRecursive(intArray, value, low, high);
		}

		return false;
	}

}
