package com.practice.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
// Problem: Last Stone Weight
// You are given an array of integers stones where stones[i] is the weight of the ith stone.
// We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
// Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
// If x == y, both stones are destroyed,
// If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
// At the end of the game, there is at most one stone left.
// Return the weight of the last remaining stone. If there are no stones left, return 0.    
class LastStone {
    public int lastStoneWeight(int[] stones) {
        //maxHeap to store the stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        //build the maxHeap
        for(int stone : stones){
            maxHeap.add(stone);
        }

        //process the stones
        while(maxHeap.size() > 1){
            //get the two heaviest stones
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            //if they are not equal, add the difference back to the heap
            if(stone1 != stone2){
                maxHeap.add(Math.abs(stone1 - stone2));
            }
        }
        //return the weight of the last stone or 0 if none left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        LastStone lastStone = new LastStone();
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStone.lastStoneWeight(stones));  // Output: 1
        
    }
}
