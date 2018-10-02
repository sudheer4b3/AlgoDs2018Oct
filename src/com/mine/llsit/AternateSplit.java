package com.mine.llsit;

public class AternateSplit {

	public static Node head = null;
	public static Node headA = null; //linked List 1
	public static Node headB = null; // Linked List 2

	public void Altersplit() {
		Node currNode = head;
		if (currNode == null || currNode.next == null) {
			return; // we have nothing to split, return
		}
		headA = currNode; //set the head for first Linked List
		headB = currNode.next; //set the head for second Linked List
		while (currNode != null && currNode.next != null) {

			Node t = currNode.next;
			currNode.next = t.next; // set the next node for first linked list
                         // Now check if next node is available for second Linked List
			if (currNode.next != null && currNode.next.next != null) {
				t.next = currNode.next.next; // set the next node for second linked list
			} else { // we have reached to the end
				t.next = null;
				return;
			}
			currNode = currNode.next; // keep moving forward
		}

	}

	public void print(Node x) {
		System.out.println("");
		Node curr = x;
		while (curr != null) {
			System.out.print("->" + curr.data);
			curr = curr.next;
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(1);

		AternateSplit i = new AternateSplit();
		i.print(head);
		i.Altersplit();
		i.print(headA);
		i.print(headB);

	}
	
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
}

