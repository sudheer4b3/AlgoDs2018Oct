package com.mine.btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/*
 * Input : 
       1
    /    \
   2      3
Output
       2            2
    /    \   OR   /   \
   1      3      3     1 
  

Input : 
       1
     /    \
    5       8
  /  \     /  \
 2    4   9    10
Output :
    2                 4
  /    \            /    \     
 4       8    OR   2      8    OR .. (any tree with 
/  \    /  \      /  \   / \          same keys and 
5   1  9   10    5    1 9   10        no odd is parent
                                      of even)
 * */
public class SinkOddNodes {
	boolean isLeaf(Node root)
	{
	    return (root.left == null && root.right == null);
	}
	 
	// A recursive method to sink a tree with odd root
	// This method assumes that the subtrees are already
	// sinked. This method is similar to Heapify of
	// Heap-Sort
	void sink(Node root)
	{
	    // If NULL or is a leaf, do nothing
	    if (root == null || isLeaf(root))
	        return;
	 
	    // if left subtree exists and left child is even
	    if (root.left != null && ((root.left.data & 1) == 0))
	    {
	        // swap root's data with left child and
	        // fix left subtree
	        //swap(root.data, root.left.data);
	    	int temp = root.data;
	    	root.data = root.left.data;
	    	root.left.data = temp;
	        sink(root.left);
	    }
	 
	    // if right subtree exists and right child is even
	    else if(root.right != null && ((root.right.data & 1) == 0))
	    {
	        // swap root's data with right child and
	        // fix right subtree
	        //swap(root.data, root.right.data);
	    	int temp = root.data;
	    	root.data = root.right.data;
	    	root.right.data = temp;
	        sink(root.right);
	    }
	}
	 
	// Function to sink all odd nodes to the bottom of binary
	// tree. It does a postorder traversal and calls sink()
	// if any odd node is found
	void sinkOddNodes(Node root)
	{
	    // If NULL or is a leaf, do nothing
	    if (root == null || isLeaf(root))
	        return;
	 
	    // Process left and right subtrees before this node
	    sinkOddNodes(root.left);
	    sinkOddNodes(root.right);
	 
	    // If root is odd, sink it
	    if ((root.data & 1) != 0)
	        sink(root);
	}
	 
	// Helper function to do Level Order Traversal of
	// Binary Tree level by level. This function is used
	// here only for showing modified tree.
	void printLevelOrder(Node root)
	{
		Queue<Node> q = new LinkedList<>();
		q.add(root);
	 
	    // Do Level order traversal
	    while (!q.isEmpty()) 
	    {
	        int nodeCount = q.size(); 
	 
	        // Print one level at a time
	        while (nodeCount > 0)
	        {
	            Node node = q.peek();
	            System.out.print(node.data+" ");
	            
	            q.remove();
	            if (node.left != null)
	            	q.add(node.left);
	            	
	            if (node.right != null)
	            	q.add(node.right);
	            
	            nodeCount--;
	        }
	        // Line separator for levels
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		/* Constructed binary tree is
        1
      /   \
     5      8
    / \   /  \
   2   4 9   10     */

		Node root = new Node(1);
		/*root.left = new Node(5);
		root.right    = new Node(8);
		
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.left = new Node(9);
		root.right.right = new Node(10);*/
		
		root.left = new Node(7);
		root.right    = new Node(11);
		
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(9);
		root.right.right = new Node(13);
		
		SinkOddNodes instance = new SinkOddNodes();
		
		instance.sinkOddNodes(root);
		
		System.out.println("Level order traversal of modified tree");
		instance.printLevelOrder(root);
	}

}

/*
 * Level order traversal of modified tree
1 
5 10 
2 4 9 8 
 * */
