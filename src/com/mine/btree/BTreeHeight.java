package com.mine.btree;

public class BTreeHeight {
	
	int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
 
        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (Math.max(height(node.left), height(node.right)) + 1);
    }

	public static void main(String[] args) {
		BTreeHeight ins = new BTreeHeight();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(2);
		root.left.left.right = new Node(2);
		System.out.println("height: "+ins.height(root));
	}
}
