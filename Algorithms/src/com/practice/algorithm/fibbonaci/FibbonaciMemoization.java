package com.practice.algorithm.fibbonaci;

import java.util.Scanner;
import java.util.WeakHashMap;

/**
 * @author fq63
 * 
 *         Deterioration in performance in recursion can be improved by an
 *         optimization technique called Memoization. In Memoization the results
 *         of expensive function calls, i.e. functions which take a lot of time,
 *         are cached on their first run. These cached values are then re-used
 *         when the function is called again with the same inputs.
 *
 */
public class FibbonaciMemoization {

	public static WeakHashMap<Integer, Integer> cache = new WeakHashMap<Integer, Integer>();

	public static int fibbonaciCalculator(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (cache.containsKey(n)) {
			return cache.get(n);
		} else {
			int sum = fibbonaciCalculator(n - 1) + fibbonaciCalculator(n - 2);
			cache.put(n, sum);
			return sum;
		}
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("======WELCOME TO FIBONACCI=======");
			System.out.println("Enter the fibbonaci series number you want ");
			int n = in.nextInt();
			long preTime = System.currentTimeMillis();
			System.out.println("Value of " + n + " number in fibonacci series->" + fibbonaciCalculator(n));
			long postTime = System.currentTimeMillis();
			System.out.println("Time taken to compute in milliseconds->" + (postTime - preTime));
		}

	}

}
