/*
Thread-Safe Components: "Implement a thread-safe FrequencyTracker that can support increment(key) and getTopK() operations. 
How do you ensure high throughput if multiple threads are incrementing the same key?"
*/
package com.practice.concurrency;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class FrequencyTracker<K> {

    /*
        The Power of ConcurrentHashMap Lock Stripping: Unlike Hashtable or Collections.synchronizedMap,
        ConcurrentHashMap doesn't lock the whole map. It locks specific segments (buckets), allowing multiple threads 
        to write to different parts of the map simultaneously. 

        Weakly Consistent Iterators: When you call entrySet(), it returns an iterator that does not require locking the
        entire map and will not throw a ConcurrentModificationException if the map is modified during iteration. 
        This allows getTopK to run without stopping your increment threads.
        
    
    Time Complexity: 
       increment is O(1). 
       getTopK is O(Nlog K), where N is the number of unique keys.
       
       Freshness: Because LongAdder.sum() and the map iterator are "weakly consistent," 
       your getTopK results represent a "recent" state of the tracker,
       but might not include an increment that happened a microsecond ago.
       In high-throughput systems, this is a standard and necessary trade-off.
   
     */
    public final Map<K,LongAdder> frequencyMap = new ConcurrentHashMap<>();

    public void increment(K key){
        // computeIfAbsent is atomic: it ensures only one LongAdder is created per key
        frequencyMap.computeIfAbsent(key,k-> new LongAdder()).increment();;

    }

   
    public List<K> getTopK(int k){
    // Min-Heap to track the top K
      PriorityQueue<Map.Entry<K,LongAdder>> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(e->e.getValue().sum()));;
      
      //linked list to maintain the order of topK
      List<K> topKList = new LinkedList<>();

        for(Map.Entry<K,LongAdder> entry :frequencyMap.entrySet()){
            priorityQueue.add(entry);
            while(priorityQueue.size() > k){
             priorityQueue.poll();
           }
        }
  
        while (!priorityQueue.isEmpty()) {
            //Poll to remove so that quque will become empty after k items polled
             topKList.addFirst(priorityQueue.poll().getKey());
        }
       
        return topKList;
    }

}
