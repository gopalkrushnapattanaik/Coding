package com.practice.algorithm.lrucache;

public class Node {
	
	Node prev;
    Node next;
    int key ;
    int value;
    
    Node(int key,int value){
    	this.key=key;
    	this.value=value;
    }
}
