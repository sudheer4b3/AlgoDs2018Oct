package com.mine.btree;

public class PrintNodesHavingKLeaves {
	
	private static int kLeaves(Node node, int k){
		
		if(node==null) 
			return 0;

		if(node.left==null && node.right==null)
			return 1;
		
		int total= kLeaves(node.left, k) + kLeaves(node.right, k);
		
		if(k==total)
			System.out.println(node.data);
		
		return total;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(4);
		
		root.left.left = new Node(5);
		root.left.right = new Node(6);
		root.right.left = new Node(7);
		root.right.right = new Node(8);
		
		root.left.left.left = new Node(9);
		root.left.left.right = new Node(10);
		root.right.left.left = new Node(11);
		root.right.left.right = new Node(12);
		root.right.left.right.left = new Node(13);
		kLeaves(root, 6);
	}
}
