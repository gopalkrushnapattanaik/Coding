package com.practice.datastructure.heap;
import java.util.*;

public class KthLargestElement {
    public static void  main(String[] args) {
        // Implementation goes here
        int[] nums = {1,3,1,8,2,3,9,3,16,3};
        int k = 3;
        int[] result = new KthLargestElement().getKthLargetElement(nums, k);
        System.out.println("The K frequent elements are: " + Arrays.toString(result));  
    }

    public int[] getKthLargetElement(int[] inputArray, int k){
        int[] resultArray = new int[k];
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for(int num : inputArray){
            minHeap.add(num);
            if(minHeap.size() >k){
                minHeap.poll();
            }
        }
        int i=0;
        while(!minHeap.isEmpty()){
            resultArray[i++] = minHeap.poll();
        }
        return resultArray;
    }
    
}
