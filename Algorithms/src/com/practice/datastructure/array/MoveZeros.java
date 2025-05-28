package src.com.practice.datastructure.array;

import java.util.Arrays;

//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.
//
//
//
//Example 1:
//
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Example 2:
//
//Input: nums = [0]
//Output: [0]
//
//
//Constraints:
//
//1 <= nums.length <= 104
//-231 <= nums[i] <= 231 - 1
public class MoveZeros {

    public static void main (String[] args){
        MoveZeros moveZeros = new MoveZeros();
        int [] nums = {0,1,0,3,12};
        moveZeros.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        //define two pointers to point to both ends of array
        int ptr1=0;
        int ptr2=1;

        for(int i=0;i<nums.length;i++){

            if(nums[ptr1]!=0){
                ptr2--;
                continue;
            }

            if(nums[ptr1] ==0) {
                int temp = nums[ptr1];
                nums[ptr1] = nums[ptr2];
                nums[ptr2] = temp;
            }
                ptr1++;
                ptr2--;

        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
