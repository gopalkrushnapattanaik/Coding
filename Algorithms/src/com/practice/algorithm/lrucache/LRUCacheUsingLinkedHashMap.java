package com.practice.algorithm.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fq63
 *
 *
 *         We will be extending LinkedHashMap class provided by Java to
 *         implement our LRUCache. LinkedHashMap can order the elements in
 *         Insertion order as well as Access order. By default, LinkedHashMap
 *         maintains the data in Insertion order. However in this case, we will
 *         be configuring LinkedHashMap to maintain the data in Access order by
 *         setting the accessOrder flag to true in its three argument copy
 *         constructor.
 * 
 *         Additionally, we will override method removeEldestEntry that
 *         LinkedHashMap calls after every put method call to check whether it
 *         should remove the eldest element. In our implementation, we will
 *         return true when size becomes greater than the capacity to let
 *         LinkedHashMap remove the least recently accessed element.
 * 
 *         Here is the implementation of LRU Cache using LinkedHashMap in Java.
 * @param <K>
 * @param <V>
 */
public class LRUCacheUsingLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;

	int cacheSize;

	// Override the method to return true only if the size of the map is > capacity
	// this method if returns true then the least used element will be evicted.
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > cacheSize;
	}

	// Constructor to create the cache , with given cache size
	// this is achieved by invoking the following constructor of LinkedHashMap Class
	public LRUCacheUsingLinkedHashMap(int cacheSize) {
		super(cacheSize, 1.0f, true);
		this.cacheSize = cacheSize;
	}

	// find the item and return from cache.
	public V find(K k) {
		return super.get(k);
	}

	// set the key, value in cache
	public void set(K key, V value) {
		super.put(key, value);
	}

	public static void main(String[] args) {

		// cache initalisation with cache capacity 3
		LRUCacheUsingLinkedHashMap<Integer, Integer> cacheMap = new LRUCacheUsingLinkedHashMap<Integer, Integer>(3);
		cacheMap.set(1, 2);
		cacheMap.set(2, 4);
		cacheMap.set(3, 6);
		System.out.println("cacheMap.find(1)" + cacheMap.find(1));
		cacheMap.set(4, 8);
		// will result in null as the key 2 has already been evicted
		System.out.println("cacheMap.find(2)" + cacheMap.find(2));

	}

}
