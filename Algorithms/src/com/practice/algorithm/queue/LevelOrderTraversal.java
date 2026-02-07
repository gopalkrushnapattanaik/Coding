package com.practice.algorithm.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.practice.tree.TreeNode;

// Given the root of a binary tree, return the level order traversal of its nodes values'. 
// (i.e., from left to right, level by level).
//Logic : We can use a queue to perform a breadth-first traversal of the tree. 
// We start by adding the root node to the queue. 
// Then, we repeatedly remove nodes from the front of the queue, add their values to a list representing the current level, 
// and add their children to the back of the queue. Once we have processed all nodes at the current level, 
// we add the list of values to our result list and move on to the next level until the queue is empty.
public class LevelOrderTraversal {

        public static void main(String [] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(6);
    
            List<List<Integer>> result = levelOrder(root);
            System.out.println(result); //Expected output: [[1], [2, 3], [4, 5, 6]]
        }
    
        public static List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
    
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
    
            //Time complexity : O(n) where n is the number of nodes in the tree. We visit each node exactly once.
            //Space complexity : O(n) in the worst case, when the tree is 
            // completely unbalanced (e.g., a linked list). In the best case, when the tree is perfectly balanced
            while (!queue.isEmpty()) {
                int levelSize = queue.size(); //queue size at the start of each level represents the number of nodes at that level
                List<Integer> currentLevel = new ArrayList<>(); //list to store the values of the current level
    
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll(); //remove the node from the front of the queue
                    currentLevel.add(currentNode.data); //add the node's value to the current level list
    
                    if (currentNode.left != null) {
                        queue.add(currentNode.left); //add the left child to the back of the queue if it exists
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right); //add the right child to the back of the queue if it exists
                    }
                }
                result.add(currentLevel); //add the current level list to the result list after processing all nodes at that level
            }
            return result;
        }
}
