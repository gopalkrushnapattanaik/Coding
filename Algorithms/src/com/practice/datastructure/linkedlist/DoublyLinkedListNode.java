package com.practice.datastructure.linkedlist;

public class DoublyLinkedListNode {
	int data;
	DoublyLinkedListNode next;
	DoublyLinkedListNode prev;
	
	public DoublyLinkedListNode(DoublyLinkedListNode next,DoublyLinkedListNode prev ,int data) {
		this.data=data;
		this.prev=prev;
		this.next=next;
	}
	
	public DoublyLinkedListNode(int data) {
		this.data=data;
		this.prev=null;
		this.next=null;
	}
	
}