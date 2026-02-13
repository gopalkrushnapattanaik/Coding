package com.practice.algorithm.dp;

/*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    
    Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    
    Example 2:
    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
    
*/
public class CombinationSteps {

        public int climbStairs(int n) {
            if (n <= 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
    
            int[] dp = new int[n + 1];
            dp[1] = 1; // There is one way to climb one step
            dp[2] = 2; // There are two ways to climb two steps
    
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2]; // The number of ways to climb to the current step is the sum of the ways to climb to the previous step and the step before that
            }
    
            return dp[n];
        }

      //Driver code
        public static void main(String[] args) {
            CombinationSteps combinationSteps = new CombinationSteps();
            int n1 = 2;
            System.out.println("Number of ways to climb " + n1 + " steps: " + combinationSteps.climbStairs(n1)); // Output: 2

            int n2 = 3;
            System.out.println("Number of ways to climb " + n2 + " steps: " + combinationSteps.climbStairs(n2)); // Output: 3

            int n3 = 5;
            System.out.println("Number of ways to climb " + n3 + " steps: " + combinationSteps.climbStairs(n3)); // Output: 8
        }


}
