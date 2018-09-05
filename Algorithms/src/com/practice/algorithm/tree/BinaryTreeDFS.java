package com.practice.algorithm.tree;

import java.util.Scanner;

import com.practice.algorithm.tree.BinaryTree.Node;

/**
 * @author fq63
 *
 *
 *         Depth First Traversals of Binary Tree
 * 
 *         Inorder Traversal (Left-Root-Right)
 * 
 *         PreorderTraversal (Root-Left-Right)
 * 
 *         Postorder Traversal (Left-Right-Root)
 * 
 */
public class BinaryTreeDFS {

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
		System.out.println("Pre Order traversal ") ;
		printPreOrder(root);
		System.out.println();
		System.out.println("Post Order traversal ") ;
		printPostOrder(root);
		System.out.println();
		System.out.println("In Order traversal ") ;
		printInOrder(root);
	}

	public static void printPreOrder(Node root) {
		if (root != null) {
			System.out.print(root.data+" ");
			printPreOrder(root.left);
			printPreOrder(root.right);

		}
	}
	
	public static void printPostOrder(Node root) {
		if (root != null) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	public static void printInOrder(Node root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.print(root.data+" ");
			printInOrder(root.right);		
		}
	}

}
