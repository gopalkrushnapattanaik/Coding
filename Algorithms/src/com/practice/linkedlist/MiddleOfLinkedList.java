package src.com.practice.linkedlist;

public class MiddleOfLinkedList {

    public static void main(String [] args){
        LinkNode node1 = new LinkNode(10);
        LinkNode node2= new LinkNode(20);
        LinkNode node3= new LinkNode(30);
        LinkNode node4= new LinkNode(40);
        LinkNode node5= new LinkNode(50);
        LinkNode node6= new LinkNode(60);
        LinkNode node7= new LinkNode(70);

        LinkedList list = new LinkedList(node1);
        list.addLast(node2);
        list.addLast(node3);
        list.addLast(node4);
        list.addLast(node5);
        list.addLast(node6);
        list.print();
        middleNode(list); //print middle node , else 2 middle print first middle
    }


    public static void middleNode(LinkedList list){
        LinkNode slowPtr = list.head;
        LinkNode current = list.head;

        while(current.next!=null && current.next.next !=null){
            current= current.next.next;
            slowPtr = slowPtr.next;
        }
        System.out.println("\nMiddle Node : "+slowPtr.data );
    }
}
