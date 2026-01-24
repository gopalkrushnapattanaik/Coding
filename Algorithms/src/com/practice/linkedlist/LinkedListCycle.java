package src.com.practice.linkedlist;

public class LinkedListCycle {

    public static void main(String [] args) {
        LinkNode node1 = new LinkNode(10);
        LinkNode node2 = new LinkNode(20);
        LinkNode node3 = new LinkNode(30);
        LinkNode node4 = new LinkNode(40);
        LinkNode node5 = new LinkNode(50);
        LinkNode node6 = new LinkNode(60);
        LinkNode node7 = new LinkNode(70);
        LinkedList cyclicList = new LinkedList(node1);
        cyclicList.addLast(node2);
        cyclicList.addLast(node3);
        cyclicList.addLast(node4);
        cyclicList.addLast(node5);
        cyclicList.addLast(node6);
        cyclicList.addLast(node5); //introduce cycle
        detectCycle(cyclicList); //true
    }
    public static void detectCycle(LinkedList list){
        LinkNode slowPtr = list.head;
        LinkNode fastPtr = list.head;
        boolean isCycle=false;
        while(fastPtr.next !=null && fastPtr.next.next !=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(fastPtr==slowPtr){
                isCycle=true;
                break;
            }
        }
        System.out.println("\nisCycle :: "+ isCycle);
    }

}
