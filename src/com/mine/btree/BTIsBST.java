package com.mine.btree;

import java.util.LinkedList;

public class BTIsBST {
	
	Node root;
	 
    /* can give min and max value according to your code or
    can write a function to find min and max value of tree. */
 
    /* returns true if given search tree is binary
     search tree (efficient version) */
    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }
 
    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;
 
        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
    	BTIsBST tree = new BTIsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
 
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
        
        if (tree.isBST2())
            System.out.println("IS BST by method 2");
        else
            System.out.println("Not a BST by method 2");
    }
    
    
    //Method 2
    
    /*
     * METHOD 4(Using In-Order Traversal)
Thanks to LJW489 for suggesting this method.
1) Do In-Order Traversal of the given tree and store the result in a temp array.
3) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.

Time Complexity: O(n)

We can avoid the use of Auxiliary Array.
While doing In-Order traversal, we can keep track of previously visited node. 
If the value of the currently visited node is less than the previous value, then tree is not BST.
     * */
 // To keep tract of previous node in Inorder Traversal
    Node prev;
 
    boolean isBST2()  {
        prev = null;
        return isBST(root);
    }
 
    /* Returns true if given search tree is binary
       search tree (efficient version) */
    boolean isBST(Node node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null)
        {
            if (!isBST(node.left))
                return false;
 
            // allows only distinct values node
            if (prev != null && node.data <= prev.data )
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }
    
    
    //Another solution: recursive
    public boolean isValidBST(Node root) {
        if(root==null)
            return true;
     
        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
     
    public boolean helper(Node root, double low, double high) {
     
        if(root.data<=low || root.data>=high)
            return false;
     
        if(root.left!=null && !helper(root.left, low, root.data)){
            return false;
        }
     
        if(root.right!=null && !helper(root.right, root.data, high)){
            return false;
        }
     
        return true;    
    }
    
    //Solution 4: iterative
    public boolean isValidBST1(Node root) {
        if(root == null)
            return true;
 
        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        while(!queue.isEmpty()){
            BNode b = queue.poll();
            if(b.n.data <= b.left || b.n.data >=b.right){
                return false;
            }
            if(b.n.left!=null){
                queue.offer(new BNode(b.n.left, b.left, b.n.data));
            }
            if(b.n.right!=null){
                queue.offer(new BNode(b.n.right, b.n.data, b.right));
            }
        }
        return true;
    }

    class BNode{
        Node n;
        double left;
        double right;
        public BNode(Node n, double left, double right){
            this.n = n;
            this.left = left;
            this.right = right;
        }
    }
}
