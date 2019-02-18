package com.practice.datastructure.array;

import java.util.Scanner;

/**
 * @author fq63
 * 
 *         Given a N X N Square Matrix. Find out the Sum of the Diagonals
 *
 */
public class MatrixDiagonalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the N X N matrix value for N :-");
		int n = sc.nextInt();

		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter elements of row :" + i);
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		System.out.println("The input Matrix is...");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}

		int sum = calculateDiagonalSum(matrix, n);

		System.out.println("diagonal sum of Matrix is :-" + sum);
	}

	
	/**
	 * @param matrix
	 * @param n
	 * @return
	 * 
	 * This solution have Time Complexity - O(n)
	 */
	private static int calculateDiagonalSum(int[][] matrix, int n) {
		int sum = 0;
		int principalDiagonalSum = 0;
		int secondaryDiagonalSum = 0;

		for (int i = 0; i < n; i++) {
			principalDiagonalSum += matrix[i][i];
		}

		for (int row = n - 1, col = 0; row >= 0 && col < n; row--, col++) {
			if(row==col)
				continue; //skipping middle element as it is part of principal diagonal sum
			secondaryDiagonalSum += matrix[row][col];
		}
		sum = principalDiagonalSum + secondaryDiagonalSum;
		return sum;
	}

}
