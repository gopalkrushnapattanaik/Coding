package com.practice.linkedlist;

public class LinkedListKthElementFromEnd {
    public static void main(String [] args) {
        LinkNode node1 = new LinkNode(10);
        LinkNode node2 = new LinkNode(20);
        LinkNode node3 = new LinkNode(30);
        LinkNode node4 = new LinkNode(40);
        LinkNode node5 = new LinkNode(50);
        LinkNode node6 = new LinkNode(60);
        LinkNode node7 = new LinkNode(70);

        LinkedList list = new LinkedList(node1);
        list.addLast(node2);
        list.addLast(node3);
        list.addLast(node4);
        list.addLast(node5);
        list.addLast(node6);
        list.print();
        int k=2;
       LinkNode result=  kthNodeFromEnd(list, k);
       System.out.println("\n " + k+ "th element from the end of the list is "+result.data);
    }

    private static LinkNode kthNodeFromEnd(LinkedList list, int k) {
        LinkNode current = list.head;
        LinkNode slowPtr = list.head;

        for(int i=0;i <k-1 &&current.next!=null;i++){
            current=current.next;
        }
        while(current.next !=null){
            current=current.next;
            slowPtr=slowPtr.next;
        }
        return slowPtr;
    }
}
