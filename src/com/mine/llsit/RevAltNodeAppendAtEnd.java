package com.mine.llsit;


/*
 * Given a linked list, reverse alternate nodes and append them to end of list. Extra allowed space is O(1) 
Examples

Input List:  1->2->3->4->5->6
Output List: 1->3->5->6->4->2

Input List:  12->14->16->18->20
Output List: 12->16->20->18->14

The idea is to maintain two linked lists, one list of all odd positioned nodes (1, 3, 5 in above example) and 
other list of all even positioned nodes (6, 4 and 2 in above example). Following are detailed steps.
1) Traverse the given linked list which is considered as odd list. Do following for every visited node.
……a) If the node is even node, remove it from odd list and add it to the front of even node list. 
     Nodes are added at front to keep the reverse order.
2) Append the even node list at the end of odd node list.
 * */
public class RevAltNodeAppendAtEnd {
	static Node head;
	 
    static class Node {
        int data;
        Node next;
 
        Node(int item) {
            data = item;
            next = null;
        }
    }
 
    /* Function to reverse all even positioned node and append at the end
     odd is the head node of given linked list */
    void rearrange(Node odd) {
         
        // If linked list has less than 3 nodes, no change is required
        if (odd == null || odd.next == null || odd.next.next == null) {
            return;
        }
 
        // even points to the beginning of even list
        Node even = odd.next;
 
        // Remove the first even node
        odd.next = odd.next.next;
 
        // odd points to next node in odd list
        odd = odd.next;
 
        // Set terminator for even list
        even.next = null;
 
        // Traverse the  list
        while (odd != null && odd.next != null) {
             
            // Store the next node in odd list 
            Node temp = odd.next.next;
 
            // Link the next even node at the beginning of even list
            odd.next.next = even;
            even = odd.next;
 
            // Remove the even node from middle
            odd.next = temp;
 
            // Move odd to the next odd node
            if (temp != null) {
                odd = temp;
            }
        }
 
        // Append the even list at the end of odd list
        odd.next = even;
    }
 
    /* Function to print nodes in a given linked list */
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    public static void main(String[] args) {
    	RevAltNodeAppendAtEnd list = new RevAltNodeAppendAtEnd();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
 
        System.out.println("Linked list before calling rearrange : ");
        list.printList(head);
 
        System.out.println("");
        list.rearrange(head);
 
        System.out.println("Linked list after calling rearrange : ");
        list.printList(head);
 
    }

}
