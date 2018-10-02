package com.mine.btree;

import java.util.BitSet;

/*
 * Approach:
Distance(X, Y) = Distance(root, X) +Distance(root, Y) — 2*(Distance(root to LCA(X,Y)
where LCA(X,Y) = Low­est Com­mon Ances­tor of X,Y
In the above exam­ple if Distance(20,45) = 3
Distance(root, 20) = 2
Distance(root, 45) = 3
LCA(20, 45) = 10
Distance(root, 10) = 1
Distance(20,45) = 2+3 — 2*1 = 3
*/

public class PrintDistance {
	public int findDistance(Node root, int n1, int n2) {
		int x = Pathlength(root, n1) - 1;
		int y = Pathlength(root, n2) - 1;
		int lcaData = findLCA(root, n1, n2).data;
		int lcaDistance = Pathlength(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}

	public int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				// System.out.println(root.data);
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	public Node findLCA(Node root, int n1, int n2) {
		if (root != null) {
			if (root.data == n1 || root.data == n2) {
				return root;
			}
			Node left = findLCA(root.left, n1, n2);
			Node right = findLCA(root.right, n1, n2);

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		PrintDistance i = new PrintDistance();
		System.out.println("Distance between 45 and 20 is : "
				+ i.findDistance(root, 35, 20));
	}
}