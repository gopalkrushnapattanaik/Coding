package com.practice.heap;

import java.util.*;
/*
*
*
*
*
*
*
*
*
* */
public class TopKFrequentElements {

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 3, 5, 12, 11, 12, 11, 12, 5},
                {1, 3, 5, 14, 18, 14, 5},
                {2, 3, 4, 5, 6, 7, 7},
                {9, 8, 7, 6, 6, 5, 4, 3, 2, 1},
                {2, 4, 3, 2, 3, 4, 5, 4, 4, 4},
                {1, 1, 1, 1, 1, 1},
                {2, 3}
        };
        int[] inputK = {3, 2, 1, 1, 3, 1, 2};
        for (int i = 0; i < inputK.length; i++) {
            System.out.println("Top " + inputK[i] + " frequent elements in " +
                    Arrays.toString(inputs[i]) + " are: " +
                    Arrays.toString(topKFrequent(inputs[i], inputK[i])));
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] resultArray= new int[k];

        //define the frequnecy map
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        //define the frquency comparator minheap
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap =
                new PriorityQueue<>((e1,e2)->e1.getValue()-e2.getValue());

        //create the ffequency map
        for(int i= 0; i<nums.length;i++){
            if(!frequencyMap.containsKey(nums[i])){
                frequencyMap.put(nums[i],1);
            }else{
                int existing_count = frequencyMap.get(nums[i]);
                frequencyMap.put(nums[i],++existing_count);
            }
        }
        //build the meanHeap
        frequencyMap.entrySet().forEach(e->{
            minHeap.add(e);
            //if the size exceeds k remove smallest frequnecy entry
            if(minHeap.size()>k){
                minHeap.poll();
            }
        });

        //At this point we have most frequent items present in minHeap
        //we will extract the minHeap keys and add to result array
        for(int i= k-1;i>=0;i--){
            resultArray[i]= minHeap.poll().getKey();
        }

        return resultArray;
    }
}
