package com.mine.btree;

import java.util.Stack;

public class BSTIterator {
	Stack<Node> stack;

	public BSTIterator(Node root) {
		stack = new Stack<Node>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		Node node = stack.pop();
		int result = node.data;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(40);
		root.right.left = new Node(30);
		root.right.right = new Node(50);
		root.right.left.left = new Node(25);
		
		BSTIterator ins = new BSTIterator(root);
		
		while(ins.hasNext()) {
			System.out.println(ins.next());
		}
	}
}