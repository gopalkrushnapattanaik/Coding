package com.practice.datastructure.array;

import java.util.ArrayDeque;

/**
 * @author gopal
 * 
 *         Given n non-negative integers representing an elevation map where the
 *         width of each bar is 1, compute how much water it is able to trap
 *         after raining.
 * 
 *         Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 *
 */
/**
 * @author gopal
 *
 */
public class TrappingRainWater {

	/**
	 * @param height
	 * @return
	 * 
	 *         Do as directed in question. For each element in the array, we find
	 *         the maximum level of water it can trap after the rain, which is equal
	 *         to the minimum of maximum height of bars on both the sides minus its
	 *         own height.
	 * 
	 *         Algorithm :-
	 * 
	 *         Initialize ans=0
	 * 
	 *         Iterate the array from left to right:
	 * 
	 *         Initialize max_left=0 and max_right=0
	 * 
	 *         Iterate from the current element to the beginning of array updating:
	 * 
	 *         max_left=max(max_left,height[j])
	 * 
	 *         Iterate from the current element to the end of array updating:
	 * 
	 *         max_right=max(max_right,height[j])
	 * 
	 *         Add min(max_left,max_right)−height[i] to ans
	 * 
	 * 
	 *         Time complexity: O(n^2).
	 * 
	 *         For each element of array, we iterate the left and right parts.
	 * 
	 *         Space complexity: O(1) extra space.
	 * 
	 */
	/**
	 * @param height
	 * @return
	 */
	static int trap_bruteforce(int[] height) {

		int ans = 0;
		int size = height.length;

		if (size <= 1) {
			return 0;
		}

		for (int i = 0; i < size; i++) {
			int max_left = 0;
			int max_right = 0;

			for (int j = i; j >= 0; j--) {
				max_left = max(max_left, height[j]);
			}

			for (int j = i; j < size; j++) {
				max_right = max(max_right, height[j]);
			}

			ans += (min(max_left, max_right) - height[i]) > 0 ? min(max_left, max_right) - height[i] : 0;
		}

		return ans;
	}

	/**
	 * @param height
	 * @return
	 * 
	 * 
	 *         In brute force, we iterate over the left and right parts again and
	 *         again just to find the highest bar size upto that index. But, this
	 *         could be stored. dynamic programming.
	 * 
	 *         Find maximum height of bar from the left end upto an index i in the
	 *         array left_max.
	 * 
	 *         Find maximum height of bar from the right end upto an index i in the
	 *         array right_max.
	 * 
	 *         Iterate over the height array and update ans: Add
	 *         min(max_left[i],max_right[i])−height[i] to ans
	 * 
	 * 
	 *         Time complexity: O(n).
	 * 
	 *         We store the maximum heights upto a point using 2 iterations of O(n)
	 *         each. We finally update ans using the stored values in O(n).
	 * 
	 *         Space complexity: O(n) extra space.
	 * 
	 *         Additional O(n) space for left_max and right_max arrays than in
	 *         Approach 1.
	 */
	static int trap_dp(int[] height) {

		int ans = 0;
		int size = height.length;
		int[] max_left = new int[size];
		int[] max_right = new int[size];

		if (size <= 1) {
			return 0;
		}

		max_left[0] = height[0];
		max_right[size - 1] = height[size - 1];

		for (int i = 1; i < size; i++) {
			max_left[i] = max(max_left[i - 1], height[i]);
		}

		for (int j = size - 2; j > 0; j--) {
			max_right[j] = max(max_right[j + 1], height[j]);
		}

		for (int i = 0; i < size; i++) {
			ans += (min(max_left[i], max_right[i]) - height[i]) > 0 ? min(max_left[i], max_right[i]) - height[i] : 0;
		}

		return ans;
	}

	/**
	 * @param height
	 * @return
	 * 
	 *         Instead of storing the largest bar upto an index as in Approach 2, we
	 *         can use stack to keep track of the bars that are bounded by longer
	 *         bars and hence, may store water.
	 * 
	 *         Using the stack, we can do the calculations in only one iteration.
	 * 
	 *         We keep a stack and iterate over the array.
	 * 
	 *         We add the index of the bar to the stack if bar is smaller than or
	 *         equal to the bar at top of stack, which means that the current bar is
	 *         bounded by the previous bar in the stack.
	 * 
	 *         If we found a bar longer than that at the top, we are sure that the
	 *         bar at the top of the stack is bounded by the current bar and a
	 *         previous bar in the stack, hence, we can pop it and add resulting
	 *         trapped water to ans.
	 * 
	 * 
	 */
	static int trap_stack(int[] height) {
		int ans = 0;

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		int current = 0;

		while (current < height.length) {

			while (!stack.isEmpty() && (height[current] > height[stack.getFirst()])) {

				int top = stack.getFirst();
				stack.pop();
				if (stack.isEmpty())
					break;
				int distance = current - stack.getFirst() - 1;
				int bounded_height = min(height[current], height[stack.getFirst()]) - height[top];
				ans += distance * bounded_height;
			}
			stack.push(current++);
		}

		return ans;
	}

	/**
	 * @param height
	 * @return
	 * 
	 * 
	 *         Instead of computing the left and right parts separately, we may
	 *         think of some way to do it in one iteration. From the dynamic
	 *         programming approach, notice that as long as right_max[i]>left_max[i]
	 *         (from element 0 to 6), the water trapped depends upon the left_max,
	 *         and similar is the case when left_max[i]>right_max[i] (from element 8
	 *         to 11). So, we can say that if there is a larger bar at one end (say
	 *         right), we are assured that the water trapped would be dependant on
	 *         height of bar in current direction (from left to right). As soon as
	 *         we find the bar at other end (right) is smaller, we start iterating
	 *         in opposite direction (from right to left). We must maintain left_max
	 *         and right_max during the iteration, but now we can do it in one
	 *         iteration using 2 pointers, switching between the two.
	 * 
	 *         Algorithm :-
	 * 
	 *         Initialize ans=0, left pointer to 0 and right pointer to size-1
	 *         
	 *          While left<right, 
	 *          {
	 *         			If (height[left] < height[right]){
	 *         				If  height[left]≥left_max, 
	 *         					update left_max 
	 *         				Else 
	 *                           add left_max−height[left] to ans 
	 *                           Add 1 to left. 
	 *                  }
	 *                  Else {
	 *                  
	 *                  	If height[right]≥right_max,
	 *                            update right_max 
	 *                      Else
	 *                      	  add right_max−height[right] to ans 
	 *                            Subtract 1 from right.
	 *                       }
	 *          }
	 *                        
	 * 
	 * 
	 */
	public static int trap(int[] height) {
		int ans = 0;
		int size = height.length;

		if (size < 2) {
			return 0;
		}

		int left = 0;
		int right = size - 1;
		int left_max = 0;
		int right_max = 0;

		while (left < right) {
			if (height[left] < height[right]) {

				if (height[left] >= left_max) {
					left_max = height[left];
				} else {
					ans += left_max - height[left];
				}
				left++;
			} else {
				if (height[right] >= right_max) {
					right_max = height[right];
				} else {
					ans += right_max - height[right];
				}
				right--;
			}

		}

		return ans;
	}

	static int min(int x, int y) {

		if (x < y) {
			return x;
		} else {
			return y;
		}
	}

	static int max(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

	public static void main(String[] args) {

		int[] input = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		System.out.println("trap_bruteforce " + trap_bruteforce(input));
		System.out.println("trap_dp " + trap_dp(input));
		System.out.println("trap_stack " + trap_stack(input));
		System.out.println("trap " + trap(input));
		
	}

}
