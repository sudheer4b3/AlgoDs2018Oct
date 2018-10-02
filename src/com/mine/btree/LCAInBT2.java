package com.mine.btree;

public class LCAInBT2 {
	
	Node root;
	 
    Node findLCA(int n1, int n2)
    {
    	Node found = findLCA(root, n1, n2);
    	if(count==2) {
        	return found;
        }
        return null;
    }
 
    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    
    static int count = 0;
    Node findLCA(Node node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        /*if (node.data == n1 || node.data == n2) {
        	count++;
            return node;
        }*/
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);
        
        if (node.data == n1 || node.data == n2) {
        	count++;
            return node;
        }
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
    	LCAInBT2 tree = new LCAInBT2();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        tree.root.left.left.left = new Node(8);
        
        Node found = tree.findLCA(8, 5);
        if(found!=null) {
        	System.out.println("LCA = " +found.data);
        } else 
        	System.out.println("null");
        
        found = null;
        
        count=0;
        found = tree.lowestCommonAncestor(tree.root, tree.root.left, new Node(9));
        if(found!=null) {
        	System.out.println("LCA now = " +found.data);
        } else 
        	System.out.println("null");
        //System.out.println("LCA(4, 5) = " +tree.findLCA(4, 3).data);
        /*System.out.println("LCA(4, 6) = " +
                            tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                            tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                            tree.findLCA(2, 4).data);*/
    }
    
    
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null)
            return null;
     
        if(root==p || root==q)
            return root;
     
        Node l = lowestCommonAncestor(root.left, p, q);
        Node r = lowestCommonAncestor(root.right, p, q);
     
        if(l!=null&&r!=null){
            return root;
        }else if(l==null&&r==null){
            return null;
        }else{
            return l==null?r:l;
        }
    }

}
