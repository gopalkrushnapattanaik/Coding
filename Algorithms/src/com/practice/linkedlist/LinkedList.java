package src.com.practice.linkedlist;


public class LinkedList {
    LinkNode head;
    LinkNode tail;

    public LinkedList(LinkNode node){
        head=node;
        tail=node;
    }

    public void addFirst(LinkNode node){
            node.next=head;
            head=node;
    }

    public void deleteFirst(){
        head=head.next;
    }


    public void addLast(LinkNode node){
        LinkNode current = head;
        while(current.next !=null){
            current=current.next;
        }
        current.next = node;
        tail=node;
    }

    public void insertNode(LinkNode node, int k){
        LinkNode current = head;
        for(int i=0 ;i<k-1 && current.next!=null ;i++){
            current= current.next;
        }
        LinkNode tmp = current.next;
        current.next=node;
        node.next=tmp;
    }

    public void deleteNode(int k){
        LinkNode current = head;
        LinkNode prev =head;
        for(int i=0 ;i<k-1 && current.next!=null ;i++){
            prev=current;
            current= current.next;
        }
        prev.next=current.next;
    }

    public void deleteLast(){
        LinkNode current = head;
        LinkNode previous = null;
        while(current.next!=null){
            previous=current;
            current=current.next;
        }
        previous.next=null;
        tail=previous;
    }

    public void print(){
        LinkNode current =head;
        System.out.println("   *********    ");
        print(current);
    }

    public void print(LinkNode node){
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null)
                System.out.print(" -> ");
            node = node.next;
        }
    }
}