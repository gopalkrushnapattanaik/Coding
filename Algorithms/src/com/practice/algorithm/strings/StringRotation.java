package com.practice.algorithm.strings;

import java.util.Scanner;

public class StringRotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input string 1 ");
		String s1 = sc.next();
		System.out.println("Enter input string 2 ");
		String s2 = sc.next();
		System.out.println(isRotated(s1, s2) ? (s2 + " " + "is rotation of " + s1) : (s2 + " " + "is Not rotation of " + s1));
		sc.close();
	}

	public static boolean isRotated(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		String s1s1 = s1 + s1;
		// if s2 is substring of s1s1 ?
		return (s1s1.indexOf(s2) >= 0 ? true : false);
	}

}
