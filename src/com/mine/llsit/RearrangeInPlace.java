package com.mine.llsit;

/*
 * You are required do this in-place without altering the nodes’ values.

Examples:
Input:  1 -> 2 -> 3 -> 4
Output: 1 -> 4 -> 2 -> 3

Input:  1 -> 2 -> 3 -> 4 -> 5
Output: 1 -> 5 -> 2 -> 4 -> 3 


We strongly recommend that you click here and practice it, before moving on to the solution.


Simple Solution

1) Initialize current node as head.
2) While next of current node is not null, do following
    a) Find the last node, remove it from end and insert it as next
       of current node.
    b) Move current to next to next of current
Time complexity of the above simple solution is O(n2) where n is number of nodes in linked list.

Efficient Solution:

1) Find the middle point using tortoise and hare method.
2) Split the linked list in two halves using found middle point in step 1.
3) Reverse the second half.
4) Do alternate merge of first and second halves. 
Time Complexity of this solution is O(n).

Below is the implementation of this method.
 * */
public class RearrangeInPlace {
	
	static Node head;  // head of list
	 
    /* Node Class */
    static class Node {
        int data;
        Node next;
 
        // Constructor to create a new node
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    void printlist(Node node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }
 
    Node reverselist(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
 
    void rearrange(Node node) {
 
        // 1) Find the middle point using tortoise and hare method 
        Node slow = node, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
 
        // 2) Split the linked list in two halves
        // node1, head of first half    1 -> 2 -> 3
        // node2, head of second half   4 -> 5
        Node node1 = node;
        Node node2 = slow.next;
        slow.next = null;
 
        // 3) Reverse the second half, i.e., 5 -> 4
        node2 = reverselist(node2);
 
        // 4) Merge alternate nodes
        node = new Node(0); // Assign dummy Node
 
        // curr is the pointer to this dummy Node, which will
        // be used to form the new list
        Node curr = node;
        while (node1 != null || node2 != null) {
 
            // First add the element from first list
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }
 
            // Then add the element from second list
            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }
 
        // Assign the head of the new list to head pointer
        node = node.next;
    }
 
    public static void main(String[] args) {
 
    	RearrangeInPlace list = new RearrangeInPlace();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
 
        list.printlist(head); // print original list
        list.rearrange(head); // rearrange list as per ques
        System.out.println("");
        list.printlist(head); // print modified list
 
    }

}
