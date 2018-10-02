package com.mine.btree;

/*
 * Given a BST, find pairs such that sum of which is Zero.
 * It is a BST (hint). BST will obviously have +ve and -ve elements
 * */

public class FindPairToZero {
	static Node root;
	
	void findPairUtil(int value, Node node) {
		if(node == null)
			return;
		if(value<node.data) {
			findPairUtil(value, node.left);
		} else if(value>node.data) {
			findPairUtil(value, node.right);
		}
		
		if(value==node.data)
			System.out.println("("+-value+","+node.data+")");
	}
	
	void findPair(Node node) {
		if (node == null)
			return;
		findPair(node.left);
		if(node.data > 0) {
			findPairUtil(-node.data, root);
		}
		findPair(node.right);
	}
	
	public static void main(String[] args) {
		FindPairToZero tree = new FindPairToZero();
		tree.root = new Node(60);
        tree.root.left = new Node(40);
        tree.root.right = new Node(80);
        
        tree.root.left.left = new Node(-40);
        tree.root.left.right = new Node(20);
        tree.root.right.right = new Node(100);
        
        tree.root.left.left.left = new Node(-60);
        tree.root.left.left.right = new Node(-20);
        
        tree.root.left.left.left.left = new Node(-80);
        
        tree.findPair(tree.root);
        
	}

}
