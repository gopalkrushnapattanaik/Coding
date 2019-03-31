package com.practice.algorithm.math;


public class Factorial {

	 static int findTrailingZeros(int n) 
	    { 
	        // Initialize result 
	        int count = 0; 
	  
	        // Keep dividing n by powers  
	        // of 5 and update count 
	        for (int i = 5; n / i >= 1; i *= 5) 
	            count += n / i; 
	  
	        return count; 
	    } 
	      
	    // Driver Code 
	    public static void main (String[] args)  
	    { 
	        int n = 100; 
	        System.out.println("Count of trailing 0s in " +  
	                                           n +"! is " +  
	                                 findTrailingZeros(n)); 
	    } 
}
