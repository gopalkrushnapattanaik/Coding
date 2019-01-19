package com.practice.algorithm.lrucache;

public class LRUCacheTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create the Lru cache
		
		LRUCache cache = new LRUCache(5);
		cache.set(1, 2);
		cache.set(2, 4);
		cache.set(3, 6);
		System.out.println("value @ 1: "+ cache.get(1));
		System.out.println("value @ 2: "+ cache.get(2));
		cache.set(4, 8);
		cache.set(5, 10);
		cache.set(6, 12);
		cache.set(7, 14);
		System.out.println("value @ 1: "+ cache.get(1));
		System.out.println("value @ 2: "+ cache.get(2));
		System.out.println("value @ 3: "+ cache.get(3));
		
	}

}
