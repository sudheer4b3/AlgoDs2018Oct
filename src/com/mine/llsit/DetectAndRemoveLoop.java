package com.mine.llsit;

class DetectAndRemoveLoop {
    static Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    // Function that detects loop in the list
    //*********************
    //If slow and fast begin from head, this algo fails. fast should begin from 2nd node.
    //*********************
    void detectAndRemoveLoop(Node node) {
    	if(node==null)
    		return;
    	
        Node slow = node;
        Node fast = node.next;
 
        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
 
        /* If loop exists */
        if (slow == fast) {
            slow = node;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
 
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
    }
 
    // Function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    // Driver program to test above functions
    public static void main(String[] args) {
        DetectAndRemoveLoop list = new DetectAndRemoveLoop();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
        list.head.next.next.next.next.next = new Node(100);
        list.head.next.next.next.next.next.next = new Node(1000);
        list.head.next.next.next.next.next.next.next = new Node(10000);
 
        // Creating a loop for testing 
        head.next.next.next.next.next.next.next.next = head.next.next.next.next;
        
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
    
    //this does not work. If slow and fast begin from head, this algo fails. fast should begin from 2nd node.
    //If we want to start slow and start from head, then after they meet, count the number of nodes in cycle (=k),
    //start 2 pointers again from head, move one pointer to k and then move both by 1 each and check if they are 
    //equal. when equal they would be at begining of loop, so traverse one pointer till end again and make its next null
    void detectAndRemoveLoop2(Node node) {
        Node slow = node;
        Node fast = node;
 
        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
 
        /* If loop exists */
        if (slow == fast) {
            slow = node;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
 
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
    }
}