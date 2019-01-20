package com.practice.algorithm.hashmap;

/**
 * @author fq63
 *
 * @param <K>
 * @param <V>
 * 
 *            Custom Implementation of HashMap
 * 
 *            This is implemented using a Array of Entries called EntryTable
 * 
 *            and a Linked List to preserve the hash Collision as a linked list.
 * 
 *            Put(key,value) -> checks if hash(key) is present,if not present
 *            just creates a new node and assigns in to array, if present checks
 *            equals on key and updates value else create a new node and append
 *            to list
 * 
 * 
 *            get(key) -> checks if Entry[hash(key)] ,if present then it will
 *            check equals on the key and returns the value.
 * 
 *            if No Collision Happens, then best case time complexity of get and
 *            Put methods if O(1) , worst case O(N)
 * 
 *            remove(key) -> remove method will remove the key if its present in
 *            the map, this will check equals with key and if matches will
 *            remove else will not remove
 * 
 * 
 * 
 */
public class CustomHashMap<K, V> {

	public interface Entry<K, V> {
		K getKey();

		V getValue();
	}

	int tableSize;
	static final int DEFAULT = 10;
	Entry<K, V>[] entryTable;

	public CustomHashMap() {
		this.tableSize = DEFAULT;
		entryTable = new Entry[tableSize];
	}

	private int hash(Object key) {
		return key.hashCode() % tableSize;
	}

	public V get(Object key) {
		int keyHash = hash(key);
		V value = null;
		Node<K, V> node = (Node<K, V>) entryTable[keyHash];

		while (node != null) {
			if (node.getKey().equals(key)) {
				value = node.getValue();
				break;
			} else {
				node = node.next;
			}
		}

		return value;

	}

	public void put(K key, V value) {
		int keyHash = hash(key);
		Node<K, V> node = (Node<K, V>) entryTable[keyHash];

		if (node == null) {

			Node<K, V> newNode = new Node<K, V>(keyHash, key, value, null);
			entryTable[keyHash] = newNode;
			return;

		} else {

			Node<K, V> previous = null;
			Node<K, V> current = node;

			// linear probing till we get correct Node, if Node found update value and
			// return
			while (current != null) {

				if (current.getKey().equals(key)) {
					current.setValue(value);
					return;
				}
				previous = current;
				current = current.next;
			}

			// if we reach here means while loop finished yet we didn't have the key in any
			// node
			// so create a new node and append to end of the list , we have last node now at
			// previous

			Node<K, V> newNode = new Node<K, V>(keyHash, key, value, null);
			previous.next = newNode;
			newNode.next = null;

		}
	}

	public boolean remove(Object key) {

		int keyHash = hash(key);
		Node<K, V> node = (Node<K, V>) entryTable[keyHash];

		if (node == null) {
			System.out.println("key not there to remove");
			return false;
		} else {

			Node<K, V> previous = null;
			Node<K, V> current = node;

			while (current != null) {
				if (current.getKey().equals(key)) {
					if (previous == null) { // It is the first node that need to be deleted
						current = current.next;
						return true;
					} else { // remove the node
						previous.next = current.next;
						return true;
					}
				}

				previous = current;
				current = current.next;
			}
			// reached here means the linked list don't have the corresponding key,value
			// pair
			System.out.println("key not there to remove");
		}
		return false;
	}

}

class Node<K, V> implements CustomHashMap.Entry<K, V> {

	int hash;
	private K key;
	private V value;
	Node<K, V> next;

	public Node(int hash, K key, V value, Node<K, V> next) {
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}

	@Override
	public K getKey() {

		return this.key;
	}

	@Override
	public V getValue() {
		return this.value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
