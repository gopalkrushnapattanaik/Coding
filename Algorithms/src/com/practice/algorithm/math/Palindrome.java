package src.com.practice.algorithm.math;
/*Given an integer x, return true if x is a palindrome, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/
public class Palindrome {

    public static void main (String [] args){
        System.out.println("isPalindrome :: " + new  Palindrome().isPalindrome(-121));
    }

    public boolean isPalindrome(int x) {
        char[] charArray = String.valueOf(x).toCharArray();
        for (int i = 0, j = charArray.length - 1; i <= j; i++, j--) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
        }
        return true;
    }
}
