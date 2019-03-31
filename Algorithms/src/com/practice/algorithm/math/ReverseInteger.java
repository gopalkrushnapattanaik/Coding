package com.practice.algorithm.math;

import java.util.Scanner;

/**
 * @author fq63
 * 
 *         Given a 32-bit signed integer, reverse digits of an integer.
 * 
 *         Assume we are dealing with an environment which could only store
 *         integers within the 32-bit signed integer range: [−2^31, 2^31 − 1].
 *         For the purpose of this problem, assume that your function returns 0
 *         when the reversed integer overflows.
 * 
 * 
 */
public class ReverseInteger {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a 32 bit signed integer");
		int num = sc.nextInt();

		System.out.println("Reverse of input is :- " + reverse(num));
		sc.close();
	}

	/**
	 * @param x
	 * @return
	 * 
	 * 		Reversing an integer can be done similarly to reversing a string.
	 * 
	 *         We want to repeatedly "pop" the last digit off of x and "push" it to
	 *         the back of the reverse. In the end, reverse will be the reverse of
	 *         the x.
	 * 
	 *         To "pop" and "push" digits without the help of some auxiliary
	 *         stack/array, we can use math.
	 * 
	 *         Overflow conditions.
	 * 
	 *         Integer_MAX value :- 2147483647
	 * 
	 *         Integer_MIN Value :- -2147483648
	 * 
	 *         so if reverse > (Max/10 ) then reverse*10 will over flow similarly
	 * 
	 *         if reverse < (Min/10) value then *10 will also over flow
	 * 
	 *         if(reverse == Max/10 then if we add >7 it will overflow)
	 * 
	 *         if(reverse == Min/10 then if we add <-8 it will overflow)
	 */
	public static int reverse(int x) {

		if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
			return 0;
		}

		int reverse = 0;

		while (x != 0) {
			int pop = x % 10;
			x = x / 10;
			if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;

			reverse = reverse * 10 + pop;

		}

		return reverse;
	}
}
