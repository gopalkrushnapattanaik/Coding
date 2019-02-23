package com.practice.datastructure.array;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author fq63 .
 * 
 *         Given an array of int (say [4,6,5,3,2,7,6,5]), print each number
 *         against how much time they occur in the array(say 4 -> 1, 6 -> 2, 5
 *         -> 2 and so on)
 */
public class NumberCounts {

	public static void main(String[] args) {

		try(Scanner sc = new Scanner(System.in)){
		int n =0;
		HashMap<Integer, Integer> countMap = new HashMap<Integer,Integer>();
		int i=0;
		System.out.println("enter the number of elements in input array");
		n = sc.nextInt();
		while(i<n) {
			int data = sc.nextInt();
			if(countMap.get(data)!= null) {
				countMap.put(data,countMap.get(data)+1);
			}else {
				countMap.put(data, 1);
			}
			i++;
		}
		
		System.out.println(countMap);
		}
		
	}

}
