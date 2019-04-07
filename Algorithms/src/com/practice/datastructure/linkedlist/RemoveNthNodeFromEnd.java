package com.practice.datastructure.linkedlist;

import java.io.IOException;
import java.util.Scanner;

import com.practice.datastructure.linkedlist.mergeSortedLinkedLists.SinglyLinkedList;
import com.practice.datastructure.linkedlist.mergeSortedLinkedLists.SinglyLinkedListNode;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);

		SinglyLinkedList llist = new SinglyLinkedList();

		System.out.print("Enter length of first linked list");

		int llistCount = s.nextInt();

		System.out.println("Enter elements of linked list");
		for (int i = 0; i < llistCount; i++) {
			llist.insertNode(s.nextInt());
		}

		System.out.println("Enter postion of node from end of linked list");
		int positionFromTail = s.nextInt();
		printSinglyLinkedList(llist.head);
		printSinglyLinkedList(removeNthFromEnd(llist.head, positionFromTail));
		s.close();
	}

	private static SinglyLinkedListNode removeNthFromEnd(SinglyLinkedListNode head, int n) {

		SinglyLinkedListNode dummy = head;
		SinglyLinkedListNode first = dummy;
		SinglyLinkedListNode second = dummy;
		// Advances first pointer so that the gap between first and second is n nodes
		// apart
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		// Move first to the end, maintaining the gap
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy;

	}


	public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
		while (node != null) {
			System.out.print(String.valueOf(node.data) + " ");
			node = node.next;
		}
		System.out.println("");
	}

}
