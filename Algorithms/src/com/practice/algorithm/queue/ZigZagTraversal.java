package com.practice.algorithm.queue;
// ZigZag Traversal of a Binary Tree is a traversal method where the nodes of the binary tree are visited in a zigzag pattern. 
// In this traversal, the nodes at the first level are visited from left to right, 
// the nodes at the second level are visited from right to left, the nodes at the third level are visited from left to right, 
// and so on, alternating the direction of traversal at each level. 
// This traversal is also known as "spiral order traversal" or "zigzag level order traversal".    

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.practice.tree.TreeNode;

// To perform a zigzag traversal of a binary tree, we can use a double-ended queue (deque) to keep track of the nodes at each level.
// We can start by adding the root node to the deque. Then, we can use a boolean variable to keep track of the direction of traversal (left to right or right to left).
// For each level, we can iterate through the nodes in the deque and add their values to a list representing the current level. If the direction is left to right, we can add the left
//  child of the current node to the back of the deque and the right child to the front of the deque. If the direction is right to left, we can add the right child to the back of the deque 
// and the left child to the front of the deque.  

public class ZigZagTraversal {

    public static void main(String [] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result); //Expected output: [[1], [3, 2], [4, 5, 6]]
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Implementation of zigzag level order traversal
        // This method will return a list of lists, where each inner list contains the values of the nodes at that 
        // level in zigzag order.
        // The implementation will involve using a deque to keep track of the nodes at each level and a boolean 
        // variable to alternate the direction of traversal.
        List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result; // Return an empty list if the tree is empty
            }
        // We can use a deque to keep track of the nodes at each level
        // and a boolean variable to alternate the direction of traversal.
        // The implementation will involve iterating through the nodes at each level and adding their values to
        // the result list in the appropriate order based on the current direction of traversal.

            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);
            boolean leftToRight = true; // Start with left to right traversal   

            while (!deque.isEmpty()) {
                int levelSize = deque.size();
                List<Integer> currentLevel = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    if (leftToRight) {
                        TreeNode currentNode = deque.pollFirst(); // Remove from the front of the deque
                        currentLevel.add(currentNode.data); // Add the node's value to the current level list

                        // Add children to the back of the deque
                        if (currentNode.left != null) {
                            deque.addLast(currentNode.left);
                        }
                        if (currentNode.right != null) {
                            deque.addLast(currentNode.right);
                        }
                    } else {
                        TreeNode currentNode = deque.pollLast(); // Remove from the back of the deque
                        currentLevel.add(currentNode.data); // Add the node's value to the current level list

                        // Add children to the front of the deque
                        if (currentNode.right != null) {
                            deque.addFirst(currentNode.right);
                        }
                        if (currentNode.left != null) {
                            deque.addFirst(currentNode.left);
                        }
                    }
                }
                result.add(currentLevel); // Add the current level list to the result list
                leftToRight = !leftToRight; // Alternate the direction for the next level
            }
            return result;  
    }   
}
