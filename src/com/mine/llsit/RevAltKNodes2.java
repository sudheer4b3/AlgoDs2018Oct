package com.mine.llsit;

/*Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
Output:  3->2->1->6->5->4->8->7->NULL. 

Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL. 


We strongly recommend that you click here and practice it, before moving on to the solution.


Algorithm: reverse(head, k)
1) Reverse the first sub-list of size k. 
  While reversing keep track of the next node and previous node. 
  Let the pointer to the next node be next and pointer to the previous node be prev. 
2) head->next = reverse(next, k) /* Recursively call for rest of the list and link the two sub-lists 
3) return prev /* prev becomes the new head of the list (see the diagrams of iterative method of this post) */
public class RevAltKNodes2 {
	
	Node head;  // head of list
	  
    /* Linked list Node*/
    class Node {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
 
    Node reverse(Node head, int k)
    {
       Node current = head;
       Node next = null;
       Node prev = null;
        
       int count = 0;
 
       /* Reverse first k nodes of linked list */
       while (count < k && current != null) 
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
       }
 
       /* next is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
       if (next != null) 
          head.next = reverse(current, k);
 
       // prev is now head of input list
       return prev;
    }                      
 
                    
    /* Utility functions */
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
 
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
 
     /* Drier program to test above functions */
    public static void main(String args[])
    {
    	RevAltKNodes2 llist = new RevAltKNodes2();
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
    	llist.push(10);
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
         
        System.out.println("Given Linked List");
        llist.printList();
         
        llist.head = llist.reverse(llist.head, 3);
 
        System.out.println("Reversed list");
        llist.printList();
    }

}
