package com.practice.datastructure.array;

/*
 Given an array of positive integers where each integer represents 
 the height of a vertical line on a graph, find two lines that together
 with the x-axis form a container that holds the most water. Return the 
 maximum amount of water a container can store. 

 example 1:
 Input: height = [1,8,6,2,5,4,8,3,7]
 Output: 49
 Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 In this case, the max area of water (blue section) the container can contain is 49.    
*/
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum area of water that can be contained: " + obj.maxArea(height)); // Output: 49
    }

    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int ans = 0;
        
        while(left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            ans = Math.max(ans, width * minHeight);
        
            if(height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        
        return ans;
    }
}
