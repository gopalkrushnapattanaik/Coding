package com.practice.algorithm.fibbonaci;

import java.util.Scanner;

public class Fibbonaci {

	public static int fibbonaciCalculator(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibbonaciCalculator(n - 1) + fibbonaciCalculator(n - 2);

		}
	}


	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
		System.out.println("======WELCOME TO FIBONACCI=======");
		System.out.println("Enter the fibbonaci series number you want ");
		int n= in.nextInt();
		 long preTime=System.currentTimeMillis();
		  System.out.println("Value of "+ n +" number in fibonacci series->"+	fibbonaciCalculator(n));
		 long postTime=System.currentTimeMillis();
		 System.out.println("Time taken to compute in milliseconds->"+(postTime-preTime));
		}
		
	}

}
