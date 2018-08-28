package com.practice.algorithm.strings;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author fq63
 * 
 *         In this challenge, you must implement a simple text editor.
 *         Initially, your editor contains an empty string, . You must perform
 *         operations of the following types:
 * 
 *         append - Append string to the end of . delete - Delete the last
 *         characters of . print - Print the character of . undo - Undo the last
 *         (not previously undone) operation of type or , reverting to the state
 *         it was in prior to that operation. Input Format
 * 
 *         The first line contains an integer, , denoting the number of
 *         operations. Each line of the subsequent lines (where ) defines an
 *         operation to be performed. Each operation starts with a single
 *         integer, (where ), denoting a type of operation as defined in the
 *         Problem Statement above. If the operation requires an argument, is
 *         followed by its space-separated argument. For example, if and , line
 *         will be 1 abcd.
 *
 */
public class SimpleTextEditor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = "";
		Stack<String> st = new Stack<String>();
		st.push(s);
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			if (t == 1) {
				s = s + in.next();
				st.push(s);
			} else if (t == 2) {
				s = s.substring(0, s.length() - in.nextInt());
				st.push(s);
			} else if (t == 3) {
				System.out.println(s.charAt(in.nextInt() - 1));
			} else {
				st.pop();
				s = st.peek();
			}
		}
		in.close();
	}

}
