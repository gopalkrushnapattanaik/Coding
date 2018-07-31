package com.practice.algorithm.linkedlist;

public class SinglyLinkedList {

	public Node start;
	public Node end;
	public int size;

	/* Constructor */
	public SinglyLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	/* Function to check if list is empty */
	public boolean isEmpty() {
		return start == null;
	}

	/* Function to get size of list */
	public int getSize() {
		return size;
	}

	/* Function to insert an element at begining */
	public void insertAtStart(int val) {
		Node new_node = new Node(val, null);
		size++;
		if (start == null) {
			start = new_node;
			end = start;
		} else {
			new_node.setNext(start);
			start = new_node;
		}
	}

	/* Function to insert an element at end */
	public void insertAtEnd(int val) {
		Node new_node = new Node(val, null);
		size++;
		if (start == null) {
			start = new_node;
			end = start;
		} else {
			end.setNext(new_node);
			end = new_node;
		}
	}

	/* Function to insert an element at position */
	public void insertAtPos(int val, int pos) {
		Node new_node = new Node(val, null);
		Node ptr = start;
		pos = pos - 1;
		for (int i = 0; i < size; i++) {

			if (i == pos) {
				Node temp = ptr.getNext();
				ptr.setNext(new_node);
				new_node.setNext(temp);
				break;
			}

			ptr = ptr.getNext();

		}

		size++;

	}

	/* Function to delete an element at position */
	public void deleteAtPos(int pos) {
		
		//removing first node
		if (pos == 1) {
			start = start.getNext();
			size--;
			return;
		}
		//removing end node
		if (pos == size) {
			Node s = start;
			Node t = start;
			while (s != end) {
				t = s;
				s = s.getNext();
			}
			end = t;
			end.setNext(null);
			size--;
			return;
		}
		
		//removing a middle node
		Node ptr = start;
		pos = pos - 1;
		
		for (int i = 1; i < size; i++) {
			if (i == pos) {
				Node temp = ptr.getNext();
				temp = temp.getNext();
				ptr.setNext(temp);
			}
			ptr = ptr.getNext();
		}
		size--;
	}

	/* Function to display elements */
	public void display() {
		System.out.print("\nSingly Linked List = ");
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getNext() == null) {
			System.out.println(start.getData());
			return;
		}
		Node ptr = start;
		System.out.print(start.getData() + "->");
		ptr = start.getNext();
		while (ptr.getNext() != null) {
			System.out.print(ptr.getData() + "->");
			ptr = ptr.getNext();
		}
		System.out.print(ptr.getData() + "\n");
	}

}
