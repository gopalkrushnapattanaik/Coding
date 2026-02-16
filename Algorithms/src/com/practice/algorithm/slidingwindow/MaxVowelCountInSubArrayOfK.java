package com.practice.algorithm.slidingwindow;
/*
Given a string s and an integer k, find the maximum number of vowels in any substring of s with length k.
Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains at most 2 vowel letters.
Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: The substring "lee" contains 2 vowel letters.  
*/
public class MaxVowelCountInSubArrayOfK {

    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // Check if the current character is a vowel and update the current vowel count
            if (isVowel(s.charAt(right))) {
                currentVowels++;
            }

            // Check if we have hit the window size of k
            if (right >= k - 1) {
                // Update the maximum vowel count if needed
                maxVowels = Math.max(maxVowels, currentVowels);

                // Check if the leftmost character is a vowel and update the current vowel count
                if (isVowel(s.charAt(left))) {
                    currentVowels--;
                }

                // Slide the window forward
                left++;
            }
        }

        return maxVowels;
    }

    private boolean isVowel(char charAt) {
        return charAt == 'a' || charAt == 'e' || charAt == 'i' || charAt == 'o' || charAt == 'u';
    }

    //Driver code to test the implementation
    public static void main(String[] args) {
        MaxVowelCountInSubArrayOfK maxVowelCountInSubArrayOfK = new MaxVowelCountInSubArrayOfK();
        String s1 = "abciiidef";
        int k1 = 3;
        
        System.out.println("Max number of vowels in any substring of length k: " + maxVowelCountInSubArrayOfK      
                .maxVowels(s1, k1)); // Output: 3  
    }

    /*
    Similar other problems with sliding window fixed length
    1. Max sum of subarray of size k
    2. Max sum of k-th element in all subarrays of size k   
    3. Longest substring without repeating characters
    4. Minimum size subarray sum
    5. Sliding window maximum
    6. Kth largest element in an array (using a min heap of size k)
    7. Task scheduler (using a priority queue to manage task frequencies and cooldowns)
    */
}
