package com.mine.btree;

public class KthLargestInBST {
	Node root;
	int c = 0;
	Node tmp = null;
	Node kthLargestUtil(Node node, int k) {
		if (node == null || c>=k)
			return null;
		
		kthLargestUtil(node.right, k);
		
		c++;
		if(c==k) {
			System.out.println(k+"thlargest element is: "+node.data);
			tmp = node;
			return node;
		}
		
		kthLargestUtil(node.left, k);
		return tmp;
	}
	
	public static void main(String[] args) {
		/* Let us create following BST
        50
     /     \
    30      70
   /  \    /  \
 20   40  60   80 */
		KthLargestInBST tree = new KthLargestInBST();
		
		tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);
        
        tree.root.left.left.left = new Node(10);
        tree.root.left.left.right = new Node(25);
        
        Node node = tree.kthLargestUtil(tree.root, 2);
        System.out.println(node.data);
	}

}
