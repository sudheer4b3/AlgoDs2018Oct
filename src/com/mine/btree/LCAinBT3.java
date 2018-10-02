package com.mine.btree;

public class LCAinBT3 {
	Node root;
    static boolean v1 = false;
    static boolean v2 = false;
     
    // This function returns pointer to LCA of two given
    // values n1 and n2.
    // v1 is set as true by this function if n1 is found
    // v2 is set as true by this function if n2 is found
    Node findLCAUtil(Node root, int n1, int n2)
    {
        // Base case
        if (root == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (root.data == n1)
        {
            v1 = true;
            return root;
        }
        if (root.data == n2)
        {
            v2 = true;
            return root;
        }
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCAUtil(root.left, n1, n2);
        Node right_lca = findLCAUtil(root.right, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return root;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
     
// Returns true if key k is present in tree rooted with root
boolean find(Node root, int k)
{
    // Base Case
    if (root == null)
        return false;
  
    // If key is present at root, or in left subtree or right subtree,
    // return true;
    if (root.data == k || find(root.left, k) ||  find(root.right, k))
        return true;
  
    // Else return false
    return false;
}
 
    // Finds lca of n1 and n2 under the subtree rooted with 'node'
    Node findLCA(int n1, int n2)
    {
 
        // Find lca of n1 and n2 using the technique discussed above
        Node lca = findLCAUtil(root, n1, n2);
 
        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1))
            return lca;
 
        // Else return NULL
        return null;
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
    	LCAinBT3 tree = new LCAinBT3();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
 
        Node lca = tree.findLCA(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");
         
        v1 = false; v2 = false;
 
        lca = tree.findLCA(4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.data);
        else
            System.out.println("Keys are not present");
        
        v1 = false; v2 = false;
        
        lca = tree.findLCA(4, 2);
        if (lca != null)
            System.out.println("LCA(4, 2) = " + lca.data);
        else
            System.out.println("Keys are not present");
        
        v1 = false; v2 = false;
        
        lca = tree.findLCA(7, 2);
        if (lca != null)
            System.out.println("LCA(7, 2) = " + lca.data);
        else
            System.out.println("Keys are not present");
    }

}
