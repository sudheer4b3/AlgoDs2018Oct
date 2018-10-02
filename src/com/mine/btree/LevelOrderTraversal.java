package com.mine.btree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void levelOrderTraversal(Node startNode) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(startNode);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.printf("%d ", tempNode.data);
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right    = new Node(4);
		
		root.left.left = new Node(5);
		root.left.right = new Node(6);
		root.right.left = new Node(7);
		root.right.right = new Node(8);
		
		root.left.left.left = new Node(9);
		root.left.left.right = new Node(10);
		root.right.left.left = new Node(11);
		root.right.left.right = new Node(12);
		root.right.left.right.left = new Node(13);
		
		System.out.println("Level Order traversal of binary tree will be:");
		  levelOrderTraversal(root);
		
		System.out.println();
		System.out.println("***********");
		System.out.println("Level Order traversal of binary tree by line will be:");
		levelOrderTraversalByLine(root);
		
		
		LevelOrderTraversal ins = new LevelOrderTraversal();
		System.out.println();
		System.out.println("***********");
		System.out.println("Level Order traversal of binary tree will be:");
		ins.printLevelOrder(root);
		
		System.out.println();
		System.out.println("***********");
		System.out.println("Reverse Level Order traversal of binary tree will be:");
		ins.reverseLevelOrder(root);
	}
	
	public static void levelOrderTraversalByLine(Node startNode) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(startNode);
		
		while(true) {
			int nodeCount = queue.size();
	        if (nodeCount == 0)
	            break;
	 
	        // Dequeue all nodes of current level and Enqueue all
	        // nodes of next level
	        while (nodeCount > 0)
	        {
	        	Node tempNode = queue.poll();
	        	System.out.printf("%d ", tempNode.data);
	        	if (tempNode.left != null)
					queue.add(tempNode.left);
				if (tempNode.right != null)
					queue.add(tempNode.right);
				nodeCount--;
	        }
	        System.out.println();
		}
	}
	
	//Another Method for Level Order Traversal
	void printLevelOrder(Node root)
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
 
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
           return 0;
        /*else
        {
             compute  height of each subtree 
            int lheight = height(root.left);
            int rheight = height(root.right);
             
             use the larger one 
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }*/
        return 1+Math.max(height(root.left), height(root.right));
    }
 
    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
    
    
    //REverse level order
    void reverseLevelOrder(Node node) 
    {
        int h = height(node);
        int i;
        for (i = h; i >= 1; i--) 
        //THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
        {
            printGivenLevel(node, i);
            System.out.println();
        }
    }
}
