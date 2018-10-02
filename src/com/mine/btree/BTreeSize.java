package com.mine.btree;

public class BTreeSize {
	static int size(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
 
        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (size(node.left) + size(node.right) + 1);
    }

	public static void main(String[] args) {
		//BTreeSize instance = new BTreeSize();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(2);
		root.left.left.right = new Node(2);
		System.out.println("size: "+BTreeSize.size(root));
	}

}
