package com.practice.datastructure.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author fq63
 * 
 *         Given an array nums of n integers, are there elements a, b, c in nums
 *         such that a + b + c = 0? Find all unique triplets in the array which
 *         gives the sum of zero.
 * 
 *         Note:
 * 
 *         The solution set must not contain duplicate triplets.
 * 
 *         Example:
 * 
 *         Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 *         A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum {

	public static void main(String[] args) {
		// input array
		int[] arr;
		// input array length;
		int n;
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Enter number of elements in the array:");
			n = s.nextInt();
			arr = new int[n];

			System.out.println("Enter elements of array:");
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
		}

		Set<ArrayList<Integer>> result = threeSum(arr);
		System.out.println("The triplets collections are " + result);
		
		Set<ArrayList<Integer>> result1 = threeSumOptimised(arr);
		System.out.println("The triplets collections are " + result1);

	}

	/**
	 * @param arr
	 * @return
	 * 
	 * TimeCompelxity = O(N3)
	 */
	private static Set<ArrayList<Integer>> threeSum(int[] arr) {
		HashSet<ArrayList<Integer>> triplets = new HashSet<ArrayList<Integer>>();

		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						ArrayList<Integer> triplet = new ArrayList<Integer>();
						triplet.add(arr[i]);
						triplet.add(arr[j]);
						triplet.add(arr[k]);
						Collections.sort(triplet);
						triplets.add(triplet);
					}
				}
			}
		}

		return triplets;
	}
	
	/**
	 * @param arr
	 * @return
	 * O(N2)
	 */
	private static Set<ArrayList<Integer>> threeSumOptimised(int[] arr) {
		HashSet<ArrayList<Integer>> triplets = new HashSet<ArrayList<Integer>>();
		
		if(arr.length<3)
			return triplets;
		
		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> couplet =twoSum(arr,-arr[i]);
			if(!couplet.isEmpty()) {
				ArrayList<Integer> triplet = new ArrayList<Integer>();
				triplet.addAll(couplet);
				triplet.add(arr[i]);
				Collections.sort(triplet);
				triplets.add(triplet);
			}
		}
		
		
		return triplets;
		
	}

	/**
	 * @param nums
	 * @param target
	 * @return
	 * O(N)
	 */
	public static ArrayList<Integer> twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> couplet = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null && map.get(target - nums[i]) != i) {
				couplet.add(nums[i]);
				couplet.add(nums[map.get(target - nums[i])]);
				break;
			}
		}

		return couplet;
	}

}
