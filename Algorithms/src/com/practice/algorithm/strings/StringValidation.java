package com.practice.algorithm.strings;

import java.util.*;

/**
 * input - only digits 0-9 , then output :- Valid Format
 * 
 * input - both digit + alphabets , then output :- Its an AlphaNumeric
 * 
 * input - only alphabets , then output :- Its a String
 * 
 *  Create 2 Exception classes to achieve it
 */
public class StringValidation {
	public static void main(String args[]) throws Exception {
		try (Scanner s = new Scanner(System.in)) {
			int inputCount = Integer.parseInt(s.nextLine());
			for (int i = 0; i < inputCount; i++) {
				String name = s.nextLine(); // Reading input from STDIN
				System.out.println(isValid(name)); // Writing output to STDOUT
			}

		}
	}

	static String isValid(String name) {
		String output = null;
		try {
			Integer.parseInt(name);
			output = "Valid Format";
		} catch (NumberFormatException ex) {
			try {
				char[] arr = name.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					if (Character.isDigit(arr[i])) {
						throw new AlphaNumericException();
					}
				}
				throw new StringException();
			} catch (AlphaNumericException ex1) {
				output = "Its an AlphaNumeric";
			} catch (StringException ex2) {
				output = "Its a String";
			}
		}

		return output;
	}
}

class AlphaNumericException extends Exception {
	private static final long serialVersionUID = 1L;

	public AlphaNumericException() {
		super();
	}
}

class StringException extends Exception {
	private static final long serialVersionUID = 1L;

	public StringException() {
		super();
	}
}