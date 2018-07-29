package com.practice.algorithm.array;

public class Pyramid {

	 public static void printTriagle(int n)
	    {
		   // number of spaces
	        int k = 2*n - 2;
	  
	        // outer loop to handle number of rows
	        //  n in this case
	        for (int i=0; i<n; i++)
	        {
	 
	            // inner loop to handle number spaces
	            // values changing acc. to requirement
	            for (int j=0; j<k; j++)
	            {
	                // printing spaces
	                System.out.print(" ");
	            }
	  
	            // decrementing k after each loop
	            k = k - 1;
	  
	            //  inner loop to handle number of columns
	            //  values changing acc. to outer loop
	            for (int j=0; j<=i; j++ )
	            {
	                // printing stars
	                System.out.print("* ");
	            }
	  
	            // ending line after each row
	            System.out.println();
	        }
	    }
	     
	 	public static void printLeftStars(int n)
	    {
	        int i, j;
	 
	        // outer loop to handle number of rows
	        //  n in this case
	        for(i=0; i<n; i++)
	        {
	 
	            //  inner loop to handle number of columns
	            //  values changing acc. to outer loop  
	            for(j=0; j<=i; j++)
	            {
	                // printing stars
	                System.out.print("* ");
	            }
	 
	            // ending line after each row
	            System.out.println();
	        }
	    }
	 	
	 	public static void printRightStars(int n)
	    {
	        // number of spaces
	        int i, j, k=2*n-2;
	 
	        // outer loop to handle number of rows
	        //  n in this case
	        for(i=0; i<n; i++)
	        {
	 
	            // inner loop to handle number spaces
	            // values changing acc. to requirement
	            for(j=0; j<k; j++)
	            {
	                // printing spaces
	                System.out.print(" ");
	            }
	             
	            // decrementing k after each loop
	            k = k - 2;
	             
	            //  inner loop to handle number of columns
	            //  values changing acc. to outer loop
	            for(j=0; j<=i; j++)
	            {
	                // printing stars
	                System.out.print("* ");
	            }
	             
	            // ending line after each row
	            System.out.println();
	        }
	    }
	    // Driver Function
	    public static void main(String args[])
	    {
	        int n = 10;
	        printLeftStars(n);
	        System.out.println();
	        System.out.println();
	        printRightStars(n);
	        System.out.println();
	        System.out.println();
	        printTriagle(n);
	    }

}
