package com.mine.btree;

/*
 * The left view contains all nodes that are first nodes in their levels. 
 * A simple solution is to do level order traversal and print the first node in every level.
 * The problem can also be solved using simple recursive traversal. 
 * We can keep track of level of a node by passing a parameter to all recursive calls. 
 * The idea is to keep track of maximum level also. 
 * Whenever we see a node whose level is more than maximum level so far, 
 * we print the node because this is the first node in its level 
 * (Note that we traverse the left subtree before right subtree).
 * */
public class BTreeLeftView {
	
	Node root;
    static int  max_level = 0;
 
    // recursive function to print left view
    void leftViewUtil(Node node, int level)
    {
        // Base Case
        if (node==null) return;
 
        // If this is the first node of its level
        if (max_level < level)
        {
            System.out.print(" " + node.data);
            max_level = level;
        }
 
        // Recur for left and right subtrees
        leftViewUtil(node.left, level+1);
        leftViewUtil(node.right, level+1);
    }
 
    // A wrapper over leftViewUtil()
    void leftView()
    {
        leftViewUtil(root, 1);
    }
 
    /* testing for example nodes */
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
    	BTreeLeftView tree = new BTreeLeftView();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        //tree.root.left.left = new Node(11);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
 
        tree.leftView();
    }

}
