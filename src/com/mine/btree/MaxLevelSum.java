package com.mine.btree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
	
	static int maximumLevelSum(Node node) {
		if(node==null)
			return 0;
		
		int result = node.data;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			int count = queue.size();
			int sum = 0;
			while((count--)>0) {
				Node temp = queue.peek();
				queue.remove();
				sum+=temp.data;
				
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
			result = Math.max(sum, result);
		}
		return result;
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
		
		System.out.println(maximumLevelSum(root));
	}

}

/*
 * Input :            4
                    /   \
                   2    -5
                  / \    /\
                -1   3 -2  6
Output: 6
Explanation :
Sum of all nodes of 0'th level is 4
Sum of all nodes of 1'th level is -3
Sum of all nodes of 0'th level is 6
Hence maximum sum is 6

Input :          1
               /   \
             2      3
           /  \      \
          4    5      8
                    /   \
                   6     7  
Output :  17
 * 
 * 
 * Time Complexity : O(n)
Auxiliary Space : O(n)
 * 
 * */
