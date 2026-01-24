package src.com.practice.linkedlist;

public class LinkedListTest {

    public static void main(String [] args){
        LinkNode node1 = new LinkNode(10);
        LinkNode node2= new LinkNode(20);
        LinkNode node3= new LinkNode(30);
        LinkNode node4= new LinkNode(40);
        LinkNode node5= new LinkNode(50);

        LinkedList list = new LinkedList(node1);
        list.print();

        //add at first of linked list
        list.addFirst(node2);
        list.addFirst(node3);
        list.print();

        // delete at first of linked list
        list.deleteFirst();
        list.print();

        // add at last of linked list
        list.addLast(node4);
        list.addLast(node5);
        list.print();

        // delete at last of linked list
        list.deleteLast();
        list.print();
        list.deleteLast();
        list.print();

        //insert a node in a position
        list.insertNode(node3,2);
        list.print();
        list.insertNode(node4,2);
        list.print();

        //delete a node in a position
        list.deleteNode(2);
        list.print();

    }
}
