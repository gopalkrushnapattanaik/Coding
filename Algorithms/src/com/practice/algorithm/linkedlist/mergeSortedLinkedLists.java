package com.practice.algorithm.linkedlist;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author fq63
 * 
 *         You’re given the pointer to the head nodes of two sorted linked
 *         lists. The data in both lists will be sorted in ascending order.
 *         Change the next pointers to obtain a single, merged linked list which
 *         also has data in ascending order. Either head pointer given may be
 *         null meaning that the corresponding list is empty.
 * 
 * 		   input format:
 * 
 *         The first line contains an integer , denoting the length of the first
 *         linked list. The next lines contain an integer each, denoting the
 *         elements of the linked list. The next line contains an integer ,
 *         denoting the length of the second linked list. The next lines contain
 *         an integer each, denoting the elements of the second linked list.
 *   
 *   	   Output Format
 * 
 *         Change the next pointer of individual nodes so that nodes from both
 *         lists are merged into a single list. Then return the head of this
 *         merged list. Do NOT print anything to stdout/console.
 * 
 *         The output is handled by the editor and the format is as follows:
 * 
 *         For each test case, print in a new line, the linked list after
 *         merging them separated by spaces.
 * 
 *         Sample Input
 * 
 *         1 3 1 2 3 2 3 4 
 *         
 *         Sample Output
 * 
 *         1 2 3 3 4 
 *         
 *         Explanation
 * 
 *         The first linked list is: 1 -> 2 -> 3 -> NULL
 * 
 *         The second linked list is: 3 -> 4 -> NULL
 * 
 *         Hence, the merged linked list is: 1 -> 2 -> 3 -> 3 -> 4 -> NULL
 *
 */
public class mergeSortedLinkedLists {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
		while (node != null) {
			System.out.print(String.valueOf(node.data) + " ");
			node = node.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);

		SinglyLinkedList llist1 = new SinglyLinkedList();
		SinglyLinkedList llist2 = new SinglyLinkedList();

		System.out.print("Enter length of first linked list");

		int llist1Count = s.nextInt();

		System.out.println("Enter length of second linked list");

		int llist2Count = s.nextInt();

		System.out.println("Enter elements of first linked list");

		for (int i = 0; i < llist1Count; i++) {
			llist1.insertNode(s.nextInt());
		}

		System.out.println("Enter elements of second linked list");

		for (int i = 0; i < llist2Count; i++) {
			llist2.insertNode(s.nextInt());
		}

		System.out.println("Here is the linked list post sort merge::");

		SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

		printSinglyLinkedList(llist3);

		s.close();

	}

	private static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		if (head1 == null && head2 == null)
			return null;
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		if (head1.data <= head2.data) {
			head1.next = mergeLists(head1.next, head2);
		} else {
			SinglyLinkedListNode temp = head2;
			head2 = head2.next;
			temp.next = head1;
			head1 = temp;
			head1.next = mergeLists(head1.next, head2);
		}

		return head1;
	}

}
