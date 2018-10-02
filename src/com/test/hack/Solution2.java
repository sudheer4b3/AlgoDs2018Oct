package com.test.hack;

class Node {

	 public int data;
	 public Node left;
	public Node right;

	 public Node(int item) {
	     data = item;
	     left = right = null;
	}
}

public class Solution2 {
	
	int sum=0;
    void findSum(Node node) {
        if(node==null) {
            return;
        }

        findSum(node.right);
        sum = sum + node.data;
        node.data = sum;

        findSum(node.left);
    }
    
    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
 
    Node root;
    
    public static void main(String[] args) {
    	Solution2 tree = new Solution2();
        tree.root = new Node(11);
        tree.root.left = new Node(2);
        tree.root.right = new Node(29);
        
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(40);
        
        tree.root.right.right.left = new Node(35);
 
        System.out.println("Inorder traversal of given tree ");
        tree.printInorder(tree.root);
        tree.findSum(tree.root);
        System.out.println("");
        System.out.println("Inorder traversal of modified tree ");
        tree.printInorder(tree.root);
    }

}
