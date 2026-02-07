package com.practice.heap;

import java.util.PriorityQueue;

/*
//given a array of stones, each stone has a weight.
//  we need to smash the stones together. 
// if the weights are same both will be destroyed, 
// if they are different the smaller one will be destroyed and the bigger 
// one will have its weight reduced by the smaller one. we need to find the weight of the last remaining stone.
eg: stones = [2,7,4,1,8,1]
output: 1
Explanation:
We can combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then, we can combine 2 and 4 to get 2 
so the array converts to [2,1,1,1] then, we can combine 2 and 1 to get 1 
so the array converts to [1,1,1] then, we can combine 1 and 1 to get 0 
so the array converts to [1,1] then, we can combine 1 and 1 to get   0 
so the array converts to [0] then, the last stone has a weight of 1. 
*/
public class SmashStones {

    public static void main(String [] args){
        int [] stones = {2,7,4,1,8,1};
        System.out.println("last remaining stone weight :: " + lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        //define the max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

        //add all the stones to the max heap
        for(int stone:stones){
            maxHeap.add(stone);
        }

        //keep smashing the stones until we have one or zero stones left
        while(maxHeap.size()>1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if(stone1!=stone2){
                maxHeap.add(Math.abs(stone1-stone2));
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.poll();
    }

}
