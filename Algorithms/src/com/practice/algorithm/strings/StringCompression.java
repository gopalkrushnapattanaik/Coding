package com.practice.algorithm.strings;

import java.util.Scanner;

/**
 * @author fq63
 * 
 *         String compression - Warm up problem statement (approx. 15 minutes to
 *         solve)
 * 
 *         Input: aaabbccddd
 * 
 *         Output: a3b2c2d3
 * 
 * 
 * 
 */
public class StringCompression {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input string to be compressed");
		String inputStr = sc.next();
		System.out.println("input string :- "+inputStr);
		System.out.println("compressed output :-"+compress(inputStr));
		sc.close();
	}
	
	private static String compress(String input) {
		String output=null;
		int consucativeCount =0;
		StringBuilder compressedString = new StringBuilder();
		for(int i=0;i<input.length();i++) {
			consucativeCount++;
			/* If next character is different than current, append this char to result.*/
			if(i+1>=input.length() ||input.charAt(i)!= input.charAt(i+1)) {
				compressedString.append(input.charAt(i));
				compressedString.append(consucativeCount);
				consucativeCount=0;
			}
		}
		output =compressedString.length() <input.length()?compressedString.toString():input;
		return output;
	}

}
