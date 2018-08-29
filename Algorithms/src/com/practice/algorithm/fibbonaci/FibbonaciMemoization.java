package com.practice.algorithm.fibbonaci;

import java.math.BigInteger;
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

	public static WeakHashMap<Integer, Long> cache = new WeakHashMap<Integer, Long>();

	/**
	 * Recurisive memoization implementation for nth fibonacci number
	 * 
	 * Time complexity - O(n)
	 * 
	 * Space complexity - O(1)
	 * 
	 */
	public static Long fibbonaciRecurisive(int n) {
		if (n == 0) {
			return (long) 0;
		} else if (n == 1) {
			return (long) 1;
		} else if (cache.containsKey(n)) {
			return cache.get(n);
		} else {
			Long fibNo = fibbonaciRecurisive(n - 1) + fibbonaciRecurisive(n - 2);
			cache.put(n, fibNo);
			return fibNo;
		}
	}

	/**
	 * Iterative implementation for nth fibonacci number
	 * 
	 * Time complexity - O(n)
	 * 
	 * Space complexity - O(1)
	 * 
	 */
	public static long fibbonaciIterative(int n) {
		if (n <= 1) {
			return n;
		}

		long fib = 1;
		long lastfib = 1;
		for (int i = 2; i < n; i++) {
			long temp = fib;
			fib = fib + lastfib;
			lastfib = temp;
		}
		return fib;
	}

	private static Long fibbnaciMatrixMultiplication(int n) {
		if (n <= 1)
			return (long) n;

		Long[][] f = new Long[][] { { (long) 1, (long) 1 }, { (long) 1, (long) 0 } };
		power(f, (long) n - 1);

		return f[0][0];
	}

	// method to calculate power of the initial matrix (M = [][]{{1,1},{1,0}})

	private static void power(Long[][] f, Long n) {
		Long[][] m = new Long[][] { { (long) 1, (long) 1 }, { (long) 1, (long) 0 } };

		for (int i = 2; i <= n; i++)
			multiply(f, m);

	}

	// method to multiply two matrices
	private static void multiply(Long[][] f, Long[][] m) {

		Long x = f[0][0] * m[0][0] + f[0][1] * m[1][0];
		Long y = f[0][0] * m[0][1] + f[0][1] * m[1][1];
		Long z = f[1][0] * m[0][0] + f[1][1] * m[1][0];
		Long w = f[1][0] * m[0][1] + f[1][1] * m[1][1];

		f[0][0] = x;
		f[0][1] = y;
		f[1][0] = z;
		f[1][1] = w;

	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("======WELCOME TO FIBONACCI=======");
			System.out.println("Enter the fibbonaci series number you want ");
			int n = in.nextInt();
			long preTime = System.currentTimeMillis();
			System.out.println("Value of " + n + " number in fibonacci series->" + fibbonaciIterative(n));
			long postTime = System.currentTimeMillis();
			System.out.println("Time taken to compute iteratively in milliseconds->" + (postTime - preTime));

			long preTime1 = System.currentTimeMillis();
			System.out.println("Value of " + n + " number in fibonacci series->" + fibbonaciRecurisive(n));
			long postTime1 = System.currentTimeMillis();
			System.out.println("Time taken to compute Recursively in milliseconds->" + (postTime1 - preTime1));

			long preTime2 = System.currentTimeMillis();
			System.out.println("Value of " + n + " number in fibonacci series->" + fibbnaciMatrixMultiplication(n));
			long postTime2 = System.currentTimeMillis();
			System.out
					.println("Time taken to compute Matrix Multiplication in milliseconds->" + (postTime2 - preTime2));
		}

	}

}
