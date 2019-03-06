package com.practice.algorithm.strings;

import java.util.Scanner;

public class WordWrap {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the String to be word wraped");
		
		String s = sc.nextLine();
		
		System.out.println("Enter the line length to be wrapped");
		
		int lineLength=sc.nextInt();
		
		/*String s = "A very long string containing " + "many many words and characters. "
				+ "Newlines will be entered at spaces.";*/
		
		System.out.println(truncate(s, lineLength));
		sc.close();

	}

	public static String truncate(final String content, final int lastIndex) {
		String result = "";
		String retResult = "";
		// Check for empty so we don't throw null pointer exception
		if (!content.isEmpty() && content.length() > lastIndex) {
			result = content.substring(0, lastIndex);
			if (content.charAt(lastIndex) != ' ') {
				// Try the split, but catch OutOfBounds in case string is an
				// uninterrupted string with no spaces
				try {
					result = result.substring(0, result.lastIndexOf(" "));
				} catch (StringIndexOutOfBoundsException e) {
					// if no spaces, force a break
					result = content.substring(0, lastIndex);
				}
				// See if we need to repeat the process again
				if (content.length() - result.length() > lastIndex) {
					retResult = truncate(content.substring(result.length(), content.length()), lastIndex);
				} else {
					return result.concat("\n").concat(content.substring(result.length(), content.length()));
				}
			}
			// Return the result concatenating a newline character on the end
			return result.concat("\n").concat(retResult);
			// May need to use this depending on your app
			// return result.concat("\r\n").concat(retResult);;
		} else {
			return content;
		}
	}

}
