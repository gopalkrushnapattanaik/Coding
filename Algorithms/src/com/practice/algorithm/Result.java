package com.practice.algorithm;

import java.util.HashSet;

public class Result {

	/*
	 * Complete the 'findSubstrings' function below.
	 *
	 * The function accepts STRING s as parameter.
	 */
	static HashSet<String> st = new HashSet<String>();
	
	
	public static void main(String[] args) {
		String s = "aab";
		findSubstrings(s);
	}

	 static void findSubstrings(String s) {
		// Write your code here

		fun(s);

		for (String substr : st) {
			System.out.println(substr);
		}

	}

	static void fun(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (isVowel(str.charAt(i))) {
				for (int j = (str.length() - 1); j >= i; j--) {
					if (isConsonant(str.charAt((j)))) {
						String str_sub = str.substring(i, j + 1);
						st.add(str_sub);
						for (int k = 1; k < str_sub.length() - 1; k++) {
							StringBuffer sb = new StringBuffer(str_sub);
							sb.deleteCharAt(k);
							fun(sb.toString());
						}
					}
				}
			}
		}

	}

	static boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	static boolean isConsonant(char c) {
		return !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
}
