package com.practice.algorithm.dp;

/*
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money. 
    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.

    Example 1:
    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1

    Example 2:
    Input: coins = [2], amount = 3
    Output: -1
    Explanation: The amount of money cannot be made up by any combination of the coins.

     Example 3:
     Input: coins = [1], amount = 0
     Output: 0
     Explanation: The amount of money can be made up with no coins, so the minimum number of coins is 0.
*/
public class CoinChange {


    // Explanation: 
    // We can use dynamic programming to solve this problem.
    // The idea is to build up a solution for the amount from 0 to the given amount using the minimum number 
    // of coins needed for each sub-amount.
    // this is called the bottom-up approach to dynamic programming, where we start with the smallest subproblems and build up 
    // to the solution for the original problem.
    // memoization is a top-down approach where we start with the original problem and break it down into smaller subproblems, 
    // storing the results of those subproblems to avoid redundant calculations. In contrast, the bottom-up approach starts with 
    // the smallest subproblems and iteratively builds up to the solution for the original problem, often using an array or table 
    // to store intermediate results.

    // We create an array dp where dp[i] represents the minimum number of coins needed to make up the amount i.
    // We initialize dp[0] to 0 since no coins are needed to make up the amount 0.
    // For each amount from 1 to the given amount, we iterate through the coins and update dp[i] by taking
    // the minimum of its current value and dp[i - coin] + 1 (which represents using one more coin of the current denomination).
    // If dp[amount] is still Integer.MAX_VALUE after processing all coins, 
    // it means we cannot make up the amount with the given coins, and we return -1. 
    // Otherwise, we return dp[amount] which contains the minimum number of coins needed for the given amount.

    // Time Complexity: O(amount * n) where n is the number of coins, since we are iterating through each amount 
    // and for each amount, we are iterating through the coins.

    // Space Complexity: O(amount) since we are using an array of size amount + 1 to 
    // store the minimum number of coins needed for each amount.
   
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0; // Base case: 0 coins needed to make amount 0        
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE; // Initialize with a large value
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // Update the minimum coins needed for amount i
                }
            }
        }               
            if (dp[amount] == Integer.MAX_VALUE) {
                return -1; // If dp[amount] is still Integer.MAX_VALUE, it means we cannot make up the amount with the given coins
            }
            return dp[amount]; // Return the minimum number of coins needed for the given amount
    }

     // Driver code
        public static void main(String[] args) {    
            CoinChange coinChange = new CoinChange();
            int[] coins1 = {1, 2, 5};
            int amount1 = 11;
            System.out.println("Minimum number of coins needed: " + coinChange.coinChange(coins1, amount1)); // Output: 3

            int[] coins2 = {2};
            int amount2 = 3;
            System.out.println("Minimum number of coins needed: " + coinChange.coinChange(coins2, amount2)); // Output: -1

            int[] coins3 = {1};
            int amount3 = 0;
            System.out.println("Minimum number of coins needed: " + coinChange.coinChange(coins3, amount3)); // Output: 0
        }

}
