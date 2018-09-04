package com.practice.algorithm.linkedlist;

import java.io.IOException;
import java.util.Scanner;

import com.practice.algorithm.linkedlist.mergeSortedLinkedLists.SinglyLinkedList;
import com.practice.algorithm.linkedlist.mergeSortedLinkedLists.SinglyLinkedListNode;

public class ReverseLinkedList {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);

		SinglyLinkedList llist1 = new SinglyLinkedList();
		
		System.out.print("Enter length of first linked list");

		int llist1Count = s.nextInt();
		System.out.println("Enter elements of first linked list");

		for (int i = 0; i < llist1Count; i++) {
			llist1.insertNode(s.nextInt());
		}
		
		System.out.println("Here is the linked list post reversing::");
		
		System.out.println("before reversing::");
		
		printSinglyLinkedList(llist1.head);
		
		
		
		SinglyLinkedListNode llist2 = reverseList(llist1.head);
		
		System.out.println("After reversing::");
		printSinglyLinkedList(llist2);

		s.close();
	}
	
	private static SinglyLinkedListNode reverseList(SinglyLinkedListNode head) {
		
		SinglyLinkedListNode current=head;
		SinglyLinkedListNode previous=null;
		SinglyLinkedListNode next=null;
		
		while(current!=null) {
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		
		
		head=previous;
		return head;
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
		while (node != null) {
			System.out.print(String.valueOf(node.data) + " ");
			node = node.next;
		}
		System.out.println("");
	}

}
