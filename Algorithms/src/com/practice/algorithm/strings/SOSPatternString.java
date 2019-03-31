package com.practice.algorithm.strings;

import java.util.Scanner;

/**
 * @author fq63 Check pattern SOS , a input can contain only SOS check how many
 *         error/dirty characters.
 */
public class SOSPatternString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String inputString = sc.nextLine();

		int errorBitCount = 0;

		errorBitCount = calculateErrorBits(inputString);
		System.out.println("input :: "+ errorBitCount);
		System.out.println("Number of Error chars :- " + errorBitCount);

	}

	private static int calculateErrorBits(String inputString) {
		// TODO Auto-generated method stub
		int errorCount = 0;
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			switch(i % 3) {
				
			case 0 :
				errorCount = (c!='S') ?errorCount+1:errorCount;
			case 1 :
				errorCount = (c!='O') ?errorCount+1:errorCount;
			case 2 :
				errorCount = (c!='S') ?errorCount+1:errorCount;
			case 3 :
				errorCount = (c!='S') ?errorCount+1:errorCount;
			}
			
		}

		return errorCount;
	}

}
