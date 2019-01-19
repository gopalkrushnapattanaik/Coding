package com.practice.algorithm.lrucache;

import java.util.HashMap;

/**
 * @author fq63
 * 
 *         Design a data structure for LRU Cache Design a data structure for LRU
 *         Cache. It should support the following operations: get and set.
 * 
 *         get(key) – Get the value (will always be positive) of the key if the
 *         key exists in the cache, otherwise return -1.
 * 
 *         set(key, value) – Set or insert the value if the key is not already
 *         present. When the cache reached its capacity, it should invalidate
 *         the least recently used item before inserting a new item.
 * 
 *         We can achieve all these Operations in Constant time if we use to
 *         keep the values in a Hash table. to check the least recently use we
 *         can additionally use a double linked Linked list which will help in
 *         keep the track of the elements accessed from Hash Table.
 * 
 *         We can define a head and tail Node at the beginning, the moment we
 *         will insert the element in to HashTable we will add the same value in
 *         the Linked list next to head if during setting the value if the
 *         capacity of the cache reached then remove the node previous to tail.
 * 
 *         during get , just delete the node from the list and re insert it next
 *         to node so that we can know it is used most recently
 *
 */
public class LRUCache {

	final int capacity;
	Node head;
	Node tail;
	int elementCount;
	HashMap<Integer, Node> cacheMap = new HashMap<>();

	public LRUCache(int capacity) {

		this.capacity = capacity;
		this.elementCount = 0;

		this.head = new Node(0, 0);
		this.head.key = 0;
		this.head.value = 0;

		this.tail = new Node(0, 0);
		this.tail.key = 0;
		this.tail.value = 0;

		this.head.next = tail;
		this.head.prev = null;

		this.tail.next = null;
		this.tail.prev = head;

	}

	// Add to the head , means create the node just after node -- O(1)
	public void addNextToHead(Node node) {
		head.next.prev = node;
		node.next = head.next;
		node.prev = head;
		head.next = node;

	}

	// delete the node -- O(1)
	public void deleteNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	// fetch the cache hit value in O(1)
	public int get(int key) {

		int value = -1;

		if (cacheMap.get(key) != null) {
			Node node = cacheMap.get(key);
			value = node.value;
			deleteNode(node);
			addNextToHead(node);
			System.out.println("Cache hit for key :" + key + " value : " + value);
		} else {
			System.out.println("Cache miss for key :" + key + " value : " + value);
		}
		return value;
	}

	/*
	 * set value in Cache, add to head, remove the tail if the count reaches
	 * capacity -- O(1)
	 */
	public void set(int key, int value) {
		if (cacheMap.get(key) != null) {
			/*
			 * the key is already present , so just update the value and remove the node and
			 * add it next to head
			 */
			Node node = cacheMap.get(key);
			node.value = value;
			deleteNode(node);
			addNextToHead(node);
		} else {
			/*
			 * The key is not there in map, so create the node using key and value, put in
			 * map. 
			 * 
			 * check for capacity if it already reached then remove the tail.prev node
			 * from list and also the corresponding key from map and add this new node next
			 * to head. 
			 * 
			 * if capacity is not reached then just remove the node and add to next
			 * to head and increase element count.
			 */ 
			
			Node node = new Node(key, value);
			cacheMap.put(key, node);
			if (elementCount < capacity) {
				elementCount++;
				addNextToHead(node);
			} else {
				cacheMap.remove(tail.prev.key);
				deleteNode(tail.prev);
				addNextToHead(node);
			}

		}

	}

}
