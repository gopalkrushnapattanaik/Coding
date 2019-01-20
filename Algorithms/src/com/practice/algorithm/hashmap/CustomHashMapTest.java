package com.practice.algorithm.hashmap;

public class CustomHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomHashMap<Integer,Integer> map = new CustomHashMap<>();
		
		map.put(12, 24);
		map.put(11, 22);
		map.put(23,46);
		map.put(32, 64);
		System.out.println("map.get(12)"+ map.get(12));
		System.out.println("map.get(11)"+ map.get(11));
		System.out.println("map.get(23)"+ map.get(23));
		System.out.println("map.get(32)"+ map.get(32));
		
		map.remove(32);
		
		System.out.println("map.get(12)"+ map.get(12));
		System.out.println("map.get(11)"+ map.get(11));
		System.out.println("map.get(23)"+ map.get(23));
		System.out.println("map.get(32)"+ map.get(32));
	}

}
