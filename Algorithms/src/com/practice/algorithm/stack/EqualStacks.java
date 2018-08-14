package com.practice.algorithm.stack;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * @author fq63
 * 
 *         You have three stacks of cylinders where each cylinder has the same
 *         diameter, but they may vary in height. You can change the height of a
 *         stack by removing and discarding its topmost cylinder any number of
 *         times.
 * 
 *         Find the maximum possible height of the stacks such that all of the
 *         stacks are exactly the same height. This means you must remove zero
 *         or more cylinders from the top of zero or more of the three stacks
 *         until they're all the same height, then print the height. The
 *         removals must be performed in such a way as to maximize the height.
 * 
 *         Note: An empty stack is still a stack.
 * 
 *         Input Format
 * 
 *         The first line contains three space-separated integers, , , and ,
 *         describing the respective number of cylinders in stacks , , and . The
 *         subsequent lines describe the respective heights of each cylinder in
 *         a stack from top to bottom:
 * 
 *         The second line contains space-separated integers describing the
 *         cylinder heights in stack . The first element is the top of the
 *         stack. The third line contains space-separated integers describing
 *         the cylinder heights in stack . The first element is the top of the
 *         stack. The fourth line contains space-separated integers describing
 *         the cylinder heights in stack . The first element is the top of the
 *         stack. Constraints
 * 
 *         Output Format
 * 
 *         Print a single integer denoting the maximum height at which all
 *         stacks will be of equal height.
 * 
 *         Sample Input
 * 
 *         5 3 4
 * 
 *         3 2 1 1 1
 * 
 *         4 3 2
 * 
 *         1 1 4 1
 * 
 *         Sample Output
 * 
 *         5
 * 
 *         Explanation
 * 
 *         Initially, the stacks look like this:
 * 
 *         initial stacks
 * 
 *         Observe that the three stacks are not all the same height. To make
 *         all stacks of equal height, we remove the first cylinder from stacks
 *         and , and then remove the top two cylinders from stack (shown below).
 * 
 *         modified stacks
 * 
 *         As a result, the stacks undergo the following change in height:
 * 
 *         All three stacks now have . Thus, we print as our answer.
 *
 */

public class EqualStacks {

	/*
	 * Complete the equalStacks function below.
	 */
	static int equalStacks(int[] h1, int[] h2, int[] h3) {
		/*
		 * Write your code here.
		 */
		ArrayDeque<Integer> stack1 = new ArrayDeque();
		ArrayDeque<Integer> stack2 = new ArrayDeque();
		ArrayDeque<Integer> stack3 = new ArrayDeque();

		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;

		for (int i = 0; i < h1.length; i++) {
			sum1 += h1[i];
			stack1.push(h1[i]);
		}
		for (int i = 0; i < h2.length; i++) {
			sum2 += h2[i];
			stack2.push(h2[i]);
		}

		for (int i = 0; i < h3.length; i++) {
			sum3 += h1[3];
			stack3.push(h3[i]);
		}

		while (!(sum1 == sum2 && sum2 == sum3)) {

			if (sum1!=0 &&(sum1 > sum2 || sum1 > sum3)) {
				sum1 -= stack1.peek();
				stack1.pop();
			}

			else if (sum2!=0&&(sum2 > sum3 || sum2 > sum1)) {
				sum2 -= stack2.peek();
				stack2.pop();
			}

			else if (sum3!=0&&(sum3 > sum1 || sum3 > sum1)) {
				sum3 -= stack3.peek();
				stack3.pop();
			}
		}

		return sum1;
	}

	public static void main(String[] args) throws IOException {

		int[] h1 = { 3, 2, 1, 1, 1 };
		int[] h2 = { 4, 3, 2 };
		int[] h3 = { 1, 1, 4, 1 };

		int result = equalStacks(h1, h2, h3);

		System.out.println(result);
	}
}
