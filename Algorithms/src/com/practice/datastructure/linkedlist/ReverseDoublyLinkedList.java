package com.practice.datastructure.linkedlist;

public class ReverseDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
	 static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
         DoublyLinkedListNode prevNode=null;
         DoublyLinkedListNode nextNode=null;
         DoublyLinkedListNode current =head;

         while(current !=null){
             nextNode = current.next;
             current.next=prevNode;
             current.prev=nextNode;
             prevNode=current;
             current=nextNode;
         }
       
         return prevNode;
 }

}
