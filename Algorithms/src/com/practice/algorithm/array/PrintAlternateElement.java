package com.practice.algorithm.array;

public class PrintAlternateElement {

	public static void main(String[] args) {
		
		int [] intArray = {1,2,3,4,5,6,7,8,9};
		
		for(int i=0; i<intArray.length ; i=i+2) {
			System.out.println(intArray[i]);
		}

	}

}
