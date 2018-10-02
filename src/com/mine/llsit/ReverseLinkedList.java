package com.mine.llsit;

public class ReverseLinkedList {
	static class Node {
	    int data;
	    Node next;
	    Node(int d) {
	        data = d;
	        next = null;
	    }
	}

	Node head;
	static ReverseLinkedList list = new ReverseLinkedList();
	static int count = 0;
	void recursiveReverse(Node head) {
		Node first;
		Node rest;
		
		/* empty list */
		if(head ==null)
			return;
		
		first = head;
		rest = first.next;
		/* List has only one node */
		if (rest == null)
		       return;
		/* reverse the rest list and put the first element at the end */
		recursiveReverse(rest);
		first.next.next = first;
		if(count ==0) {
			list.head = rest;
			count++;
		}
		
		//my addition
		//System.out.println(first.next.data);
		/* tricky step */
	    first.next  = null;          
	 
	    /* fix the head pointer */
	    head = rest;
	}
	
	void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
	
	public static void main(String[] args) {
		//ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
        list.head.next.next.next.next = new Node(100);
        list.head.next.next.next.next.next = new Node(1000);
         
        System.out.println("Original Linked list is :");
        list.printList(list.head);
        list.recursiveReverse(list.head);
        System.out.println("");
        System.out.println("Recursively Reversed linked list : ");
        list.printList(list.head);
        
        System.out.println();
        list.head = list.reverse(list.head);
        System.out.println("Reversed linked list : ");
        list.printList(list.head);
    }
	
	Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        //node = prev;
        //return node;
        return prev;
    }

}
