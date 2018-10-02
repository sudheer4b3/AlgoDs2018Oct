package com.mine.btree;

/*
 * Input : 
in[]   = {2, 1, 3}
post[] = {2, 3, 1}

Output : Root of below tree
      1
    /   \
   2     3 


Input : 
in[]   = {4, 8, 2, 5, 1, 6, 3, 7}
post[] = {8, 4, 5, 2, 6, 7, 3, 1} 

Output : Root of below tree
          1
       /     \
     2        3
   /    \   /   \
  4     5   6    7
    \
      8
*/

public class BTreeFromInAndPost {
	
	/* Recursive function to construct binary of size n
	   from  Inorder traversal in[] and Preorder traversal
	   post[].  Initial values of inStrt and inEnd should
	   be 0 and n -1.  The function doesn't do any error
	   checking for cases where inorder and postorder
	   do not form a tree */
	int pIndex;
	Node buildUtil(int in[], int post[], int inStrt,
	                int inEnd)
	{
	    // Base case
	    if (inStrt > inEnd)
	        return null;
	 
	    /* Pick current node from Preorder traversal using
	       postIndex and decrement postIndex */
	    Node node = new Node(post[pIndex--]);
	    //newNode(post[pIndex]);
	    //(pIndex)--;
	 
	    /* If this node has no children then return */
	    if (inStrt == inEnd)
	        return node;
	 
	    /* Else find the index of this node in Inorder
	       traversal */
	    int iIndex = search(in, inStrt, inEnd, node.data);
	 
	    /* Using index in Inorder traversal, construct left and
	       right subtress */
	    node.right= buildUtil(in, post, iIndex+1, inEnd);
	    node.left = buildUtil(in, post, inStrt, iIndex-1);
	 
	    return node;
	}
	 
	// This function mainly initializes index of root
	// and calls buildUtil()
	Node buildTree(int in[], int post[], int n)
	{
		pIndex = n-1;
	    return buildUtil(in, post, 0, n - 1);
	}
	 
	/* Function to find index of value in arr[start...end]
	   The function assumes that value is postsent in in[] */
	int search(int arr[], int strt, int end, int value)
	{
	    int i;
	    for (i = strt; i <= end; i++)
	    {
	        if (arr[i] == value) {
	            return i;
	        }
	    }
	    return i;
	}
	
	/* This funtcion is here just to test  */
	void preOrder(Node node)
	{
	    if (node == null) return;
	    System.out.print(node.data + " ");
	    preOrder(node.left);
	    preOrder(node.right);
	}
	 
	// Driver code
	public static void main(String[] args) {
		int in[]   = {4, 8, 2, 5, 1, 6, 3, 7};
	    int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
	    //int n = sizeof(in)/sizeof(in[0]);
	    int n = in.length;
	    
	    BTreeFromInAndPost instance = new BTreeFromInAndPost();
	 
	    Node root = instance.buildTree(in, post, n);
	 
	    System.out.println("Preorder of the constructed tree : ");
	    instance.preOrder(root);
	}

}
