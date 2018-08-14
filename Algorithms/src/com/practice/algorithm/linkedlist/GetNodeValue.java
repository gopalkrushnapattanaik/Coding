package com.practice.algorithm.linkedlist;

import java.util.Scanner;

import com.practice.algorithm.linkedlist.mergeSortedLinkedLists.SinglyLinkedList;
import com.practice.algorithm.linkedlist.mergeSortedLinkedLists.SinglyLinkedListNode;

public class GetNodeValue {

	public static void main(String[] args) {
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
		System.out.println("The element at position " + positionFromTail + " from tail" + " is "
				+ getNode(llist.head, positionFromTail));
		s.close();
	}

	static int getNode(SinglyLinkedListNode head, int positionFromTail) {

		SinglyLinkedListNode pointer = head;
		int pointerPosition = 0;

		while (head.next != null) {
			head = head.next;
			if (pointerPosition >= positionFromTail) {
				pointer = pointer.next;
			} else {
				pointerPosition++;
			}
		}

		return pointer.data;
	}

}
