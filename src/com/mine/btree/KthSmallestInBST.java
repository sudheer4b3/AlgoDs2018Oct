package com.mine.btree;

public class KthSmallestInBST {
	Node root;
	int c = 0;
	
	void kthLargestUtil(Node node, int k) {
		if (node == null || c>=k)
			return;
		
		kthLargestUtil(node.left, k);
		
		c++;
		if(c==k) {
			System.out.println(k+"thlargest element is: "+node.data);
			return;
		}
		
		kthLargestUtil(node.right, k);
	}
	
	public static void main(String[] args) {
		/* Let us create following BST
        50
     /     \
    30      70
   /  \    /  \
 20   40  60   80 */
		KthSmallestInBST tree = new KthSmallestInBST();
		int k=7;
		
		tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);
        
        tree.root.left.left.left = new Node(10);
        tree.root.left.left.right = new Node(25);
        
        tree.kthLargestUtil(tree.root, k);
	}

}
