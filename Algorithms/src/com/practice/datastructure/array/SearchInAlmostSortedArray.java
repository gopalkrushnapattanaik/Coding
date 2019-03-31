package com.practice.datastructure.array;

import java.util.Scanner;

/**
 * @author fq63
 * 
 *         Search in an almost sorted array Given an array which is sorted, but
 *         after sorting some elements are moved to either of the adjacent
 *         positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write
 *         an efficient function to search an element in this array. Basically
 *         the element arr[i] can only be swapped with either arr[i+1] or
 *         arr[i-1].
 * 
 *         For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next
 *         position and 10 is moved to previous position.
 */
public class SearchInAlmostSortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the number of elements in the array");
		
		int length = sc.nextInt();
		int[] intArray = new int[length];
		
		System.out.println("enter the elements of array");
		
		for(int i=0;i<length ;i++) {
			intArray[i]=sc.nextInt();
		}
		System.out.println("enter the elements to search");
		
		int value= sc.nextInt();
		
		sc.close();
		
		boolean ispresent = search(intArray,value,0,intArray.length-1);
		
		System.out.println("ispresent :::::  "+ ispresent);
		
	}

	private static boolean search(int[] intArray, int value,int low,int high) {
		int mid = (low+high)/2;
		
		if(low>high) {
			return false;
		}
		
		if(value==intArray[mid] || value==intArray[mid-1]|| value==intArray[mid+1]) {
			return true;
		}
		if(value>intArray[mid]) {
			low=mid-2;
			search(intArray,value,low,high);
		}
		
		if(value<intArray[mid]) {
			high=mid+2;
			search(intArray,value,low,high);
		}
		
		return false;
		
	}

}
