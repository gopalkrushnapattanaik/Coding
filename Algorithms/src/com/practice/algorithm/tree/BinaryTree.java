package com.practice.algorithm.tree;

public class BinaryTree {

	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static Node insert(Node root, int data) {

		if (root == null) {
			return new Node(data);
		} else {
			Node current;
			if (root.data < data) {
				current = insert(root.left, data);
				root.left = current;
			} else {
				current = insert(root.right, data);
				root.right = current;
			}
		}
		return root;
	}

}
