package com.mine.btree;

public class SecondLargestInBST {
	Node root;
	int c = 0;
	
	void kthLargestUtil(Node node) {
		if (node == null || c>=2)
			return;
		
		kthLargestUtil(node.right);
		
		c++;
		if(c==2) {
			System.out.println("2nd largest element is: "+node.data);
			return;
		}
		
		kthLargestUtil(node.left);
	}
	
	public static void main(String[] args) {
		/* Let us create following BST
        50
     /     \
    30      70
   /  \    /  \
 20   40  60   80 */
		SecondLargestInBST tree = new SecondLargestInBST();
		int k=5;
		
		tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        //tree.root.right.right = new Node(80);
        
        tree.root.left.left.left = new Node(10);
        tree.root.left.left.right = new Node(25);
        
        tree.kthLargestUtil(tree.root);
	}

}
