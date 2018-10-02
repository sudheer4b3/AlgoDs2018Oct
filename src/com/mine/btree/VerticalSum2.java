package com.mine.btree;

public class VerticalSum2 {
	// Prints vertical sum of different vertical
    // lines in tree. This method mainly uses
    // verticalSumDLLUtil().
    static void verticalSumDLL(TNode root)
    {
        // Create a doubly linked list node to
        // store sum of lines going through root.
        // Vertical sum is initialized as 0.
        LLNode llnode = new LLNode(0);
 
        // Compute vertical sum of different lines
        verticalSumDLLUtil(root, llnode);
 
        // llnode refers to sum of vertical line
        // going through root. Move llnode to the
        // leftmost line.
        while (llnode.prev != null)
            llnode = llnode.prev;
 
        // Prints vertical sum of all lines starting
        // from leftmost vertical line
        while (llnode != null)
        {
            System.out.print(llnode.data +" ");
            llnode = llnode.next;
        }
    }
 
    // Constructs linked list
    static void verticalSumDLLUtil(TNode tnode,
                                   LLNode llnode)
    {
        // Add current node's data to its vertical line
        llnode.data = llnode.data + tnode.data;
 
        // Recursively process left subtree
        if (tnode.left != null)
        {
            if (llnode.prev == null)
            {
                llnode.prev = new LLNode(0);
                llnode.prev.next = llnode;
            }
            verticalSumDLLUtil(tnode.left, llnode.prev);
        }
 
        // Process right subtree
        if (tnode.right != null)
        {
            if (llnode.next == null)
            {
                llnode.next = new LLNode(0);
                llnode.next.prev = llnode;
            }
            verticalSumDLLUtil(tnode.right, llnode.next);
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
        // Let us construct the tree shown above
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.right.left = new TNode(6);
        root.right.right = new TNode(7);
 
        System.out.println("Vertical Sums are");
        verticalSumDLL(root);
    }
 
    // Doubly Linked List Node
    static class LLNode
    {
        int data;
        LLNode prev, next;
        public LLNode(int d) { data = d; }
    }
 
    // Binary Tree Node
    static class TNode
    {
        int data;
        TNode left, right;
        public TNode(int d) { data = d; }
    }

}

/*
 * Given a Binary Tree, find vertical sum of the nodes that are in same vertical line.
 * Print all sums through different vertical lines.

Examples:

      1
    /   \
  2      3
 / \    / \
4   5  6   7
The tree has 5 vertical lines

Vertical-Line-1 has only one node 4 => vertical sum is 4
Vertical-Line-2: has only one node 2=> vertical sum is 2
Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
Vertical-Line-4: has only one node 3 => vertical sum is 3
Vertical-Line-5: has only one node 7 => vertical sum is 7

So expected output is 4, 2, 12, 3 and 7

We have discussed Hashing Based Solution in Set 1.
Hashing based solution requires a Hash Table to be maintained.
We know that hashing requires more space than the number of entries in it.
In this post, Doubly Linked List based solution is discussed.
The solution discussed here requires only n nodes of linked list 
where n is total number of vertical lines in binary tree. Below is algorithm.

verticalSumDLL(root)
1)  Create a node of doubly linked list node 
    with value 0. Let the node be llnode.
2)  verticalSumDLL(root, llnode)

verticalSumDLL(tnode, llnode)
1) Add current node's data to its vertical line
        llnode.data = llnode.data + tnode.data;
2) Recursively process left subtree
   // If left child is not empty
   if (tnode.left != null)
   {
      if (llnode.prev == null)
      {
          llnode.prev = new LLNode(0);
          llnode.prev.next = llnode;
      }
      verticalSumDLLUtil(tnode.left, llnode.prev);
   }
3)  Recursively process right subtree
   if (tnode.right != null)
   {
      if (llnode.next == null)
      {
          llnode.next = new LLNode(0);
          llnode.next.prev = llnode;
      }
      verticalSumDLLUtil(tnode.right, llnode.next);
   }
Below is Java implementation of above idea.
 * */
