package com.mine.btree;

class Sum {
    int sum = 0;
}

public class BTreeGreaterKeySum {
	static Node root;
    Sum summ = new Sum();
 
    int sum=0;
    void findSum(Node node) {
        if(node==null) {
            return;
        }

        findSum(node.right);
        sum = sum + node.data;
        node.data = sum;

        findSum(node.left);
    }
    // A recursive function that traverses the given BST in reverse inorder and
    // for every key, adds all greater keys to it
    void addGreaterUtil(Node node, Sum sum_ptr) {
        // Base Case
        if (node == null) {
            return;
        }
 
        // Recur for right subtree first so that sum of all greater
        // nodes is stored at sum_ptr
        addGreaterUtil(node.right, sum_ptr);
 
        // Update the value at sum_ptr
        sum_ptr.sum = sum_ptr.sum + node.data;
 
        // Update key of this node
        //node.data = sum_ptr.sum - node.data;
        node.data = sum_ptr.sum; //this to add all higher keys
 
        // Recur for left subtree so that the updated sum is added
        // to smaller nodes
        addGreaterUtil(node.left, sum_ptr);
    }
 
    // A wrapper over addGreaterUtil().  It initializes sum and calls
    // addGreaterUtil() to recursivel upodate and use value of sum
    void addGreater(Node node) {
        addGreaterUtil(node, summ);
        return;// node;
    }
 
    // A utility function to print inorder traversal of Binary Tree
    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
 
    // Driver program to test the above functions
    public static void main(String[] args) {
    	BTreeGreaterKeySum tree = new BTreeGreaterKeySum();
        tree.root = new Node(11);
        tree.root.left = new Node(2);
        tree.root.right = new Node(29);
        
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(40);
        
        tree.root.right.right.left = new Node(35);
 
        System.out.println("Inorder traversal of given tree ");
        tree.printInorder(root);
        tree.addGreater(root);
        //tree.findSum(root);
        System.out.println("");
        System.out.println("Inorder traversal of modified tree ");
        tree.printInorder(root);
    }

}
