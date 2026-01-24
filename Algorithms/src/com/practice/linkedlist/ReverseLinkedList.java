package src.com.practice.linkedlist;

public class ReverseLinkedList {
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
        System.out.println("\n Reversed List ");
        list.print(reverselist(list));
    }

    private static LinkNode reverselist(LinkedList list) {
        LinkNode current = list.head;
        LinkNode prev = null;
        LinkNode next;
        while(current!=null){
            next = current.next; //store the next node
            current.next=prev; //reverse at this point
            prev=current; //move prev one step ahead
            current=next; //move current to original next node
        }
        return prev;
    }
}
