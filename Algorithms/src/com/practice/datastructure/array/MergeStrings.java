package com.practice.datastructure.array;


//You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
//
//Return the merged string.
//
//
//
//Example 1:
//
//Input: word1 = "abc", word2 = "pqr"
//Output: "apbqcr"
//Explanation: The merged string will be merged as so:
//word1:  a   b   c
//word2:    p   q   r
//merged: a p b q c r
//Example 2:
//
//Input: word1 = "ab", word2 = "pqrs"
//Output: "apbqrs"
//Explanation: Notice that as word2 is longer, "rs" is appended to the end.
//word1:  a   b
//word2:    p   q   r   s
//merged: a p b q   r   s
//Example 3:
//
//Input: word1 = "abcd", word2 = "pq"
//Output: "apbqcd"
//Explanation: Notice that as word1 is longer, "cd" is appended to the end.
//word1:  a   b   c   d
//word2:    p   q
//merged: a p b q c   d
//
//
//Constraints:
//
//1 <= word1.length, word2.length <= 100
//word1 and word2 consist of lowercase English letters.
public class MergeStrings {

    public static void main (String args[]){
        MergeStrings mergObj = new MergeStrings();
        String result = mergObj.mergeAlternately("abcd","pqrstyu");
        System.out.println(result);
    }

    public String mergeAlternately(String word1, String word2) {
        char[] word1Araay = word1.toCharArray();
        char[] word2Araay = word2.toCharArray();
        char[] resultArray = new char[word1Araay.length + word2Araay.length];
        int i=0;
        int j=0;
        for (int k=0; k < resultArray.length ; k++) {
            if ((k % 2 == 0 && i<word1Araay.length) || (i> word2Araay.length)) {
                resultArray[k] = word1Araay[i];
                i++;
            } else {
                if(j<word2Araay.length) {
                    resultArray[k] = word2Araay[j];
                    j++;
                }
            }
        }
        return String.valueOf(resultArray);
    }

}
