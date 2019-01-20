package com.practice.datastructure.stack;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * @author fq63
 * 
 *         A bracket is considered to be any one of the following characters: (,
 *         ), {, }, [, or ].
 * 
 *         Two brackets are considered to be a matched pair if the an opening
 *         bracket (i.e., (, [, or {) occurs to the left of a closing bracket
 *         (i.e., ), ], or }) of the exact same type. There are three types of
 *         matched pairs of brackets: [], {}, and ().
 * 
 *         A matching pair of brackets is not balanced if the set of brackets it
 *         encloses are not matched. For example, {[(])} is not balanced because
 *         the contents in between { and } are not balanced. The pair of square
 *         brackets encloses a single, unbalanced opening bracket, (, and the
 *         pair of parentheses encloses a single, unbalanced closing square
 *         bracket, ].
 * 
 *         By this logic, we say a sequence of brackets is balanced if the
 *         following conditions are met:
 * 
 *         It contains no unmatched brackets. The subset of brackets enclosed
 *         within the confines of a matched pair of brackets is also a matched
 *         pair of brackets. Given strings of brackets, determine whether each
 *         sequence of brackets is balanced. If a string is balanced, return
 *         YES. Otherwise, return NO.
 * 
 *         Function Description
 * 
 *         Complete the function isBalanced in the editor below. It must return
 *         a string: YES if the sequence is balanced or NO if it is not.
 * 
 *         isBalanced has the following parameter(s):
 * 
 *         s: a string of brackets Input Format
 * 
 *         The first line contains a single integer , the number of strings.
 *         Each of the next lines contains a single string , a sequence of
 *         brackets.
 * 
 *         Constraints
 * 
 *         , where is the length of the sequence. All chracters in the sequences
 *         ∈ { {, }, (, ), [, ] }. Output Format
 * 
 *         For each string, return YES or NO.
 * 
 *         Sample Input
 * 
 *         3 {[()]} {[(])} {{[[(())]]}} Sample Output
 * 
 *         YES NO YES Explanation
 * 
 *         The string {[()]} meets both criteria for being a balanced string, so
 *         we print YES on a new line. The string {[(])} is not balanced because
 *         the brackets enclosed by the matched pair { and } are not balanced:
 *         [(]). The string {{[[(())]]}} meets both criteria for being a
 *         balanced string, so we print YES on a new line.
 * 
 */
public class BalancedParanthesis {

	static String isBalanced(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<Character>();

		char[] charArray = s.toCharArray();
		char c;
		for (int i = 0; i < charArray.length; i++) {
			switch (charArray[i]) {
			case ('('):
				stack.push(charArray[i]);
				break;

			case ('{'):
				stack.push(charArray[i]);
				break;

			case ('['):
				stack.push(charArray[i]);
				break;

			case ('}'):
				c = stack.isEmpty() ? ' ' : stack.pop();
				if (c != '{') {
					return "NO";
				}
				break;

			case (')'):
				c = stack.isEmpty() ? ' ' : stack.pop();
				if (c != '(') {
					return "NO";
				}
				break;

			case (']'):
				c = stack.isEmpty() ? ' ' : stack.pop();
				if (c != '[') {
					return "NO";
				}
				break;

			}

		}
		if (stack.isEmpty()) {
			return "YES";
		}

		else {
			return "NO";
		}

	}

	public static void main(String[] args) throws IOException {
		String s = "}][}}(}][))]";

		String result = isBalanced(s);

		System.out.println(result);

	}
}
