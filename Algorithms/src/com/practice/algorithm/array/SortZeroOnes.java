package com.practice.algorithm.array;

import java.util.Arrays;
import java.util.Scanner;

public class SortZeroOnes {

	public static void main(String[] args) throws Exception {

		int n;
		int[] arr;

		try (Scanner s = new Scanner(System.in)) {

			System.out.print("Enter number of elements in the array:");
			n = s.nextInt();
			arr = new int[n];

			System.out.println("Enter elements of array:");
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
				if (!(arr[i] == 0 || arr[i] == 1)) {
					throw new Exception("invalid element " + arr[i] + " only 0s and 1s allowed ");
				}
			}
		}

		arr = sortZeroOnes(arr);
		printArray(arr);

	}

	private static void printArray(int[] arr) {
		System.out.println("Array Elements : {");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("'" + arr[i] + "'");
		}
		System.out.println("}");

	}

	private static int[] sortZeroOnes(int[] arr) {

		int left=0;
		int right= arr.length-1;
	
		 
	        while (left < right) 
	        {
	            /* Increment left index while we see 0 at left */
	            while (arr[left] == 0 && left < right)
	               left++;
	 
	            /* Decrement right index while we see 1 at right */
	            while (arr[right] == 1 && left < right)
	                right--;
	 
	            /* If left is smaller than right then there is a 1 at left
	               and a 0 at right.  Exchange arr[left] and arr[right]*/
	            if (left < right) 
	            {
	                arr[left] = 0;
	                arr[right] = 1;
	                left++;
	                right--;
	            }
	        }
	        return arr;
	    }
		
		
		



}
