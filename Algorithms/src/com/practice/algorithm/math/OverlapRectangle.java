package com.practice.algorithm.math;

/*
An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.

Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.



Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Example 3:

Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
Output: false


Constraints:

rec1.length == 4
rec2.length == 4
-109 <= rec1[i], rec2[i] <= 109
rec1 and rec2 represent a valid rectangle with a non-zero area.
* */
public class OverlapRectangle {

    public static void main(String[] args) {
        OverlapRectangle obj = new OverlapRectangle();
        int[] rec1 = {0, 0, 1, 1};
        int[] rec2 = {1, 0, 2, 1};
        System.out.println("isRectangleOverlap :: " + obj.isRectangleOverlap(rec1, rec2));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean result = true;
        //take input points of rec1
        int r1x1 = rec1[0];
        int r1y1 = rec1[1];
        int r1x2 = rec1[2];
        int r1y2 = rec1[3];
        //take input points of rec2
        int r2x1 = rec2[0];
        int r2y1 = rec2[1];
        int r2x2 = rec2[2];
        int r2y2 = rec2[3];

        //the rectangle is to the right or left or top bottom
        if (r1x2 <= r2x1 || r2x2 <= r1x1 || r1y2 <= r2y1 || r2y2 <= r1y1) {
            return false;
        }
        return result;
    }
}
