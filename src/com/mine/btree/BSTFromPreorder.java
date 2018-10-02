package com.mine.btree;

class Index {	 
    int index = 0;
}

public class BSTFromPreorder {
	Index index = new Index();
	
    // A recursive function to construct BST from pre[]. preIndex is used
    // to keep track of index in pre[].
    Node constructTreeUtil(int pre[], Index preIndex, int key,
            int min, int max, int size) {
 
        // Base case
        if (preIndex.index >= size) {
            return null;
        }
 
        Node root = null;
 
        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) {
 
            // Allocate memory for root of this subtree and increment *preIndex
            root = new Node(key);
            preIndex.index = preIndex.index + 1;
 
            if (preIndex.index < size) {
 
                // Contruct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                // subtree, and first such node will be root of left subtree.
                root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index],
                        min, key, size);
 
                // All nodes which are in range {key..max} will go in right
                // subtree, and first such node will be root of right subtree.
                root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index],
                        key, max, size);
            }
        }
 
        return root;
    }
 
    // The main function to construct BST from given preorder traversal.
    // This function mainly uses constructTreeUtil()
    Node constructTree(int pre[], int size) {
        //int preIndex = 0;
        return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE,
                Integer.MAX_VALUE, size);
    }
 
    // A utility function to print inorder traversal of a Binary Tree
    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
 
    // Driver program to test above functions
    public static void main(String[] args) {
    	BSTFromPreorder tree = new BSTFromPreorder();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
        
        Node node = constructTreeUtil(pre, tree.pIndex, pre[0], Integer.MIN_VALUE,
                Integer.MAX_VALUE, size);
        System.out.println("\nInorder traversal of the constructed tree is ");
        tree.printInorder(node);
    }
    
    int pIndex = 0;
 // A recursive function to construct BST from pre[]. preIndex is used
    // to keep track of index in pre[].
    static Node constructTreeUtil(int pre[], int pIndex, int key,
            int min, int max, int size) {
 
        // Base case
        if (pIndex >= size) {
            return null;
        }
 
        Node root = null;
 
        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) {
 
            // Allocate memory for root of this subtree and increment *preIndex
            root = new Node(key);
            pIndex = pIndex + 1;
 
            if (pIndex < size) {
 
                // Contruct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                // subtree, and first such node will be root of left subtree.
                root.left = constructTreeUtil(pre, pIndex, pre[pIndex],
                        min, key, size);
 
                // All nodes which are in range {key..max} will go in right
                // subtree, and first such node will be root of right subtree.
                root.right = constructTreeUtil(pre, pIndex, pre[pIndex],
                        key, max, size);
            }
        }
 
        return root;
    }

}
