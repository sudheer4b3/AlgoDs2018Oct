package com.mine.btree;

public class BTreeAreMirror {
	
	/* Given two trees, return true if they are
	   mirror of each other */
	boolean areMirror(Node a, Node b)
	{
	    /* Base case : Both empty */
	    if (a==null && b==null)
	        return true;
	 
	    // If only one is empty
	    if (a==null || b == null)
	        return false;
	 
	    /* Both non-empty, compare them recursively
	     Note that in recursive calls, we pass left
	     of one tree and right of other tree */
	    return  a.data == b.data &&
	            areMirror(a.left, b.right) &&
	            areMirror(a.right, b.left);
	            //areMirror(b.left, a.right);
	}
	
	public static void main(String[] args) {
		BTreeAreMirror instance = new BTreeAreMirror();
		Node a = new Node(1);
	    Node b = new Node(1);
	    a.left = new Node(2);
	    a.right = new Node(3);
	    a.left.left  = new Node(4);
	    a.left.right = new Node(5);
	    //a.right.left = new Node(6);
	    //a.right.right = new Node(7);
	 
	    b.left = new Node(3);
	    b.right = new Node(2);
	    b.right.left = new Node(5);
	    b.right.right = new Node(4);
	    //b.left.left = new Node(7);
	    //b.left.right = new Node(6);
	    
	    System.out.println(instance.areMirror(a, b)? "Yes" : "No");
	}

}
