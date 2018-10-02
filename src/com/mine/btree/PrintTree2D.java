package com.mine.btree;

/*
 * Input : Pointer to root of below tree
             1
            /  \
           2    3 
          / \   / \
         4   5  6  7 

Output :
                    7

          3

                    6

1

                    5

          2

                    4
 * */

public class PrintTree2D {
	
	static Node root;
	
	// Function to print binary tree in 2D
	// It does reverse inorder traversal
	private void print2DUtil(Node root, int space)
	{
	    // Base case
	    if (root == null)
	        return;
	 
	    // Increase distance between levels
	    space += 10;
	 
	    // Process right child first
	    print2DUtil(root.right, space);
	 
	    // Print current node after space
	    // count
	    System.out.print("\n");
	    for (int i = 10; i < space; i++)
	    	System.out.print(" ");
	    System.out.print(root.data+"\n");
	 
	    // Process left child
	    print2DUtil(root.left, space);
	}
	 
	// Wrapper over print2DUtil()
	void print2D(Node root)
	{
	   // Pass initial space count as 0
	   print2DUtil(root, 0);
	}

	public static void main(String[] args) {
		PrintTree2D tree = new PrintTree2D();
		
		tree.root = new Node(1);
	    tree.root.left = new Node(2);
	    tree.root.right = new Node(3);
	    
	    tree.root.left.left = new Node(4);
	    tree.root.left.right = new Node(5);
	    tree.root.right.left= new Node(6);
	    tree.root.right.right = new Node(7);
	    
	    tree.root.left.left.left = new Node(8);
	    tree.root.left.left.right = new Node(9);
	    tree.root.left.right.left = new Node(10);
	    tree.root.left.right.right = new Node(11);
	    tree.root.right.left.left = new Node(12);
	    tree.root.right.left.right = new Node(13);
	    tree.root.right.right.left = new Node(14);
	    tree.root.right.right.right = new Node(15);
	    tree.root.right.right.right.left = new Node(150);
	    
	    tree.print2D(tree.root);
	}
}
