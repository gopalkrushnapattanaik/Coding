package com.practice.algorithm.strings;

import java.util.HashMap;

/**
 * @author fq63
 *
 *
 *         Longest Substring Without Repeating Characters
 *
 *         Given a string, find the length of the longest substring without
 *         repeating characters.
 * 
 *         Example 1:
 * 
 *         Input: "abcabcbb"
 *         Output: 3
 *         Explanation: The answer is "abc", with the length of 3.
 *         
 *         Example 2:
 * 
 *         Input: "bbbbb" 
 *         Output: 1 
 *         Explanation: The answer is "b", with the length of 1. 
 *         
 *         
 *         Example 3:
 * 
 *         Input: "pwwkew" 
 *         Output: 3 
 *         Explanation: The answer is "wke", with the length of 3. 
 *         Note that the answer must be a substring, "pwke" is a
 *         subsequence and not a substring.
 */
public class LongetSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "pwwkew";
		int max_length = 0;
		int curr_length = 0;
		char[] charArray = s.toCharArray();
		HashMap<Character, Character> charMap = new HashMap<>();

		if (s.length()==1) {
			max_length = 1;
		} else {

			for (char c : charArray) {
				if (charMap.get(c) == null) {
					charMap.put(c, c);
					curr_length++;
					max_length = (max_length < curr_length) ? curr_length : max_length;
				} else if(charMap.get(c) != null ){
					charMap.clear();
					charMap.put(c, c);
					max_length = (max_length < curr_length) ? curr_length : max_length;
					curr_length = 1;
				}
			}
		}
		System.out.println(max_length);
	}

}
