package com.practice.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//longest substring without repeating characters
//Given a string s, find the length of the longest substring without repeating characters.
//Example 1:
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.  
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        //sliding window approach
        // expand the window by moving right pointer
        while (right < s.length()) {

            // get the current character
            char currentChar = s.charAt(right); 

            // if the character is already in the map
            //move the left pointer to the right of the previous index of the current character 
            //as we need to ensure no repeating characters in the substring
            if (charIndexMap.containsKey(currentChar)) {    
                //update the left pointer only if it's behind the last occurrence of the current character
                // This handles cases like "abba"
                left = Math.max(charIndexMap.get(currentChar) + 1, left);
                //  This ensures that the left pointer only moves forward
            }

            //update the character's latest index , add/update the character's index in the map
            charIndexMap.put(currentChar, right);
          
            //calculate the max length of the substring
            maxLength = Math.max(maxLength, right - left + 1);
           
            //move the right pointer to expand the window
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubString longestSubString = new LongestSubString();
        String input1 = "abcabcbb";
        String input2 = "bbbbb";
        String input3 = "pwwkew";
        String input4 = "abcdacade";

        System.out.println("Length of longest substring without repeating characters in \"" + input1 + "\": " +
                longestSubString.lengthOfLongestSubstring(input1)); // Output: 3

        System.out.println("Length of longest substring without repeating characters in \"" + input2 + "\": " +
                longestSubString.lengthOfLongestSubstring(input2)); // Output: 1

        System.out.println("Length of longest substring without repeating characters in \"" + input3 + "\": " +
                longestSubString.lengthOfLongestSubstring(input3)); // Output: 3
        System.out.println("Length of longest substring without repeating characters in \"" + input4 + "\": " +
                longestSubString.lengthOfLongestSubstring(input4)); // Output: 5
    }
    
}
