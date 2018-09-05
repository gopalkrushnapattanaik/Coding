package com.practice.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Scanner;

import com.practice.algorithm.tree.BinaryTree.Node;

/**
 * @author fq63
 * 
 *         ****** Level Order Traversal*******
 * 
 *         Create empty queue and push root node to it.
 * 
 *         Do the following when queue is not empty
 * 
 *         1>Pop a node from queue and print it
 * 
 *         2>Push left child of popped node to queue if not null
 * 
 *         3>Push right child of popped node to queue if not null
 *
 */
public class BinaryTreeBFS {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the count of elements of tree");
		int t = scan.nextInt();
		System.out.println("Enter the elements of tree");
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = BinaryTree.insert(root, data);
		}
		scan.close();
		
		levelOrderTraversal(root);

	}

	private static void levelOrderTraversal(Node root) {

		ArrayDeque<Node> queue = new ArrayDeque<>();
		// add root to queue
		queue.add(root);
		// while queue is not empty
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data+" ");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}

	}

}
