package com.practice.datastructure.array;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author fq63
 * 
 *         Given an array of integers, return indices of the two numbers such
 *         that they add up to a specific target.
 * 
 *         You may assume that each input would have exactly one solution, and
 *         you may not use the same element twice.
 * 
 *         Example:
 * 
 *         Given nums = [2, 7, 11, 15], target = 9,
 * 
 *         Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * 
 */
public class TwoSum {

	public static void main(String[] args) {
		// input array
		int[] arr;
		// input array length;
		int n;
		// target
		int target;
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter number of elements in the array:");
			n = s.nextInt();
			arr = new int[n];

			System.out.println("Enter elements of array:");
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			System.out.print("Enter sum target:");
			target = s.nextInt();
		}
		long preTime = System.currentTimeMillis();
		int[] result = twoSum(arr, target);
		long postTime = System.currentTimeMillis();
		System.out.print("["+result[0]+ ",");
		System.out.print(result[1]+"]");
		System.out.println("Time taken to compute  in milliseconds->" + (postTime - preTime));

		long preTime1 = System.currentTimeMillis();
		int[] result1 = twoSum_bruteforce(arr, target);
		long postTime1 = System.currentTimeMillis();
		System.out.println("Time taken to compute  in milliseconds->" + (postTime1 - preTime1));
		System.out.print("["+result1[0]+ ",");
		System.out.print(result1[1]+"]");


	}

	public static int[] twoSum(int[] nums, int target) {

		int[] arr = new int[2];

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null && map.get(target - nums[i]) != i) {
				arr[0] = i;
				arr[1] = map.get(target - nums[i]);
				break;
			}
		}

		return arr;
	}
	
	public static int[] twoSum_bruteforce(int[] nums, int target) {
		
		int[] arr = new int[2];
		
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					arr[0]=i;
					arr[1]=j;
					break;
				}
			}
		}
		
		return arr;
		
	}
}
