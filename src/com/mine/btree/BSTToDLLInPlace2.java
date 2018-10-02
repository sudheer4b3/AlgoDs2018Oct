package com.mine.btree;

public class BSTToDLLInPlace2 {
	static Node root;
    
    // head --> Pointer to head node of created doubly linked list
    static Node head;
    
    Node BinaryTree2DoubleLinkedList(Node root) {
    	if(root.left==null && root.right==null)
    		return root;
    	Node temp = null;
    	
    	if(root.left != null) {
    		temp = BinaryTree2DoubleLinkedList(root.left);
    		while(temp.right!=null)
    			temp = temp.right;
    		temp.right = root;
    		root.left = temp;
    	}
    	if(root.right!=null) {
    		temp = BinaryTree2DoubleLinkedList(root.right);
    		while(temp.left!=null)
    			temp=temp.left;
    		temp.left = root;
    		root.right = temp;
    	}
    	return root;
    }

	 void printList(Node node)
	    {
	        while (node != null) 
	        {
	            System.out.print(node.data + " ");
	            node = node.right;
	        }
	    }
	 
	    // Driver program to test above functions
	    public static void main(String[] args) 
	    {
	        // Let us create the tree as shown in above diagram
	    	BSTToDLLInPlace2 tree = new BSTToDLLInPlace2();
	        tree.root = new Node(10);
	        tree.root.left = new Node(12);
	        tree.root.right = new Node(15);
	        tree.root.left.left = new Node(25);
	        tree.root.left.right = new Node(30);
	        tree.root.right.left = new Node(36);
	        tree.root.right.right = new Node(45);
	 
	        // convert to DLL
	        head = tree.BinaryTree2DoubleLinkedList(root);
	        
	        while(head.left!=null)
	        	head=head.left;
	         
	        // Print the converted List
	        tree.printList(head);
	 
	    }
}
