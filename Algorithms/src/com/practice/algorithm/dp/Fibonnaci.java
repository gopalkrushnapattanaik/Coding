package com.practice.algorithm.dp;

/*
    The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones, 
    usually starting with 0 and 1. 
    The sequence goes: 0, 1, 1, 2, 3, 5, 8, 13, and so on. 
    The nth Fibonacci number can be calculated using the formula:
    F(n) = F(n-1) + F(n-2)
    with base cases F(0) = 0 and F(1) = 1.

    Example:
    Input: n = 5
    Output: 5
    Explanation: The Fibonacci sequence up to the 5th number is: 0, 1, 1, 2, 3, 5. So the 5th Fibonacci number is 5.
 
*/
public class Fibonnaci {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonnaci fibonnaci = new Fibonnaci();
        int n = 5;
        System.out.println("The " + n + "th Fibonacci number is: " + fibonnaci.fib(n)); // Output: 5
    }
}
