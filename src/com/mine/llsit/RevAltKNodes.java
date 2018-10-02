package com.mine.llsit;

/*
 * Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function) in an efficient way. Give the complexity of your algorithm.

Example:
Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
Output:   3->2->1->4->5->6->9->8->7->NULL. 

Method 1 (Process 2k nodes and recursively call for rest of the list) 
This method is basically an extension of the method discussed in this post.

kAltReverse(struct node *head, int k)
  1)  Reverse first k nodes.
  2)  In the modified list head points to the kth node.  So change next 
       of head to (k+1)th node
  3)  Move the current pointer to skip next k nodes.
  4)  Call the kAltReverse() recursively for rest of the n - 2k nodes.
  5)  Return new head of the list.
 * */

public class RevAltKNodes {
	static Node head;
	 
    class Node {
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /* Reverses alternate k nodes and
     returns the pointer to the new head node */
    Node kAltReverse(Node node, int k) {
        Node current = node;
        Node next = null, prev = null;
        int count = 0;
 
        /*1) reverse first k nodes of the linked list */
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
 
        /* 2) Now head points to the kth node.  So change next 
         of head to (k+1)th node*/
        if (node != null) {
            node.next = current;
        }
 
        /* 3) We do not want to reverse next k nodes. So move the current 
         pointer to skip next k nodes */
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }
 
        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if (current != null) {
            current.next = kAltReverse(current.next, k);
        }
 
        /* 5) prev is new head of the input list */
        return prev;
    }
 
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    void push(int newdata) {
        Node mynode = new Node(newdata);
        mynode.next = head;
        head = mynode;
    }
 
    public static void main(String[] args) {
    	RevAltKNodes list = new RevAltKNodes();
 
        // Creating the linkedlist
        for (int i = 20; i > 0; i--) {
            list.push(i);
        }
        System.out.println("Given Linked List :");
        list.printList(head);
        head = list.kAltReverse(head, 3);
        System.out.println("");
        System.out.println("Modified Linked List :");
        list.printList(head);
 
    }

}
