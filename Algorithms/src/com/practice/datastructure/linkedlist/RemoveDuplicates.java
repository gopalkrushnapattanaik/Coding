package com.practice.datastructure.linkedlist;

import java.util.Scanner;

import com.practice.datastructure.linkedlist.mergeSortedLinkedLists.SinglyLinkedList;
import com.practice.datastructure.linkedlist.mergeSortedLinkedLists.SinglyLinkedListNode;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		SinglyLinkedList llist = new SinglyLinkedList();

		System.out.print("Enter length of first linked list");

		int llistCount = s.nextInt();

		System.out.println("Enter elements of linked list");
		for (int i = 0; i < llistCount; i++) {
			llist.insertNode(s.nextInt());
		}

		SinglyLinkedListNode result=removeDuplicates(llist.head);
		System.out.println(result);
		s.close();
	}

	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {

		if (head == null) {
			return null;
		}

		SinglyLinkedListNode ptr = head;

		while (head.next != null) {
			if (head.data == head.next.data) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return ptr;

	}
	
	static boolean hasCycle(SinglyLinkedListNode head) {

		SinglyLinkedListNode fastPtr = head;
		SinglyLinkedListNode slowPtr = head;

		if (head == null || head.next == null) {
			return false;
		} 
			while (slowPtr.next != null) {
				fastPtr = fastPtr.next.next;
				slowPtr = slowPtr.next;
				if(fastPtr==slowPtr) {
					return true;
				}
			}
		
		return false;
	}

}
