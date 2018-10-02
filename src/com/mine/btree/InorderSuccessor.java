package com.mine.btree;

/*
 * 1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
Go to right subtree and return the node with minimum key value in right subtree.
2) If right subtree of node is NULL, then start from root and use search like technique. 
Do following.
Travel down the tree, if a node’s data is greater than root’s data then go right side, 
otherwise go to left side.
 * */
public class InorderSuccessor {
	static Node head;
	/* Given a non-empty binary search tree, return the minimum data  
    value found in that tree. Note that the entire tree does not need
    to be searched. */
   Node minValue(Node node) {
       Node current = node;

       /* loop down to find the leftmost leaf */
       while (current.left != null) {
           current = current.left;
       }
       return current;
   }
   
   Node inOrderSuccessor( Node root, Node n)
   {
       // step 1 of the above algorithm
       if( n.right != null)
           return minValue(n.right);
    
       Node succ = null;
    
       // Start from root and search for successor down the tree
       while (root != null)
       {
           if (n.data < root.data)
           {
               succ = root;
               root = root.left;
           }
           else if (n.data > root.data)
               root = root.right;
           else
              break;
       }
    
       return succ;
   }

   // Driver program to test above functions
   public static void main(String[] args) {
	   InorderSuccessor tree = new InorderSuccessor();
       Node root = null, temp = null, suc = null, min = null;
       
       tree.head = new Node(20);
       tree.head.left = new Node(8);
       tree.head.right = new Node(22);
       tree.head.left.left = new Node(4);
       tree.head.left.right = new Node(12);
       tree.head.left.right.left = new Node(10);
       tree.head.left.right.right = new Node(14);
       tree.head.right.left = new Node(21);
       
       temp = head.right;
       //temp = head.right;
       suc = tree.inOrderSuccessor(head, temp);
       if (suc != null) {
           System.out.println("Inorder successor of " + temp.data + 
                                                     " is " + suc.data);
       } else {
           System.out.println("Inorder successor does not exist");
       }
   }

}
