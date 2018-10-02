package com.mine.btree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

//Tree node
class TreeNode1
{
  int data; //node data
  int vd; //vertical distance diagonally
  TreeNode1 left, right; //left and right child's reference

  // Tree node constructor
  public TreeNode1(int data)
  {
      this.data = data;
      vd = Integer.MAX_VALUE;
      left = right = null;
  }
}

//Tree class
class Tree
{
  TreeNode1 root;//Tree root

  // Tree constructor
  public Tree(TreeNode1 root)  {  this.root = root;  }

  // Diagonal sum method
  public void diagonalSum()
  {
      // Queue which stores tree nodes
      Queue<TreeNode1> queue = new LinkedList<TreeNode1>();

      // Map to store sum of node's data lying diagonally
      Map<Integer, Integer> map = new TreeMap<>();

      // Assign the root's vertical distance as 0.
      root.vd = 0;

      // Add root node to the queue
      queue.add(root);

      // Loop while the queue is not empty
      while (!queue.isEmpty())
      {
          // Remove the front tree node from queue.
          TreeNode1 curr = queue.remove();

          // Get the vertical distance of the dequeued node.
          int vd = curr.vd;

          // Sum over this node's right-child, right-of-right-child
          // and so on
          while (curr != null)
          {
              int prevSum = (map.get(vd) == null)? 0: map.get(vd);
              map.put(vd, prevSum + curr.data);

              // If for any node the left child is not null add
              // it to the queue for future processing.
              if (curr.left != null)
              {
                  curr.left.vd = vd+1;
                  queue.add(curr.left);
              }

              // Move to the current node's right child.
              curr = curr.right;
          }
      }

      // Make an entry set from map.
      Set<Entry<Integer, Integer>> set = map.entrySet();

      // Make an iterator
      Iterator<Entry<Integer, Integer>> iterator = set.iterator();

      // Traverse the map elements using the iterator.
       System.out.print("Diagonal sum in a binary tree is - ");
      while (iterator.hasNext())
      {
          Map.Entry<Integer, Integer> me = iterator.next();

          System.out.print(me.getValue()+" ");
      }
  }
}

//Driver class
public class DiagonalSumBT
{
  public static void main(String[] args)
  {
      TreeNode1 root = new TreeNode1(1);
      root.left = new TreeNode1(2);
      root.right = new TreeNode1(3);
      root.left.left = new TreeNode1(9);
      root.left.right = new TreeNode1(6);
      root.right.left = new TreeNode1(4);
      root.right.right = new TreeNode1(5);
      root.right.left.left = new TreeNode1(12);
      root.right.left.right = new TreeNode1(7);
      root.left.right.left = new TreeNode1(11);
      root.left.left.right = new TreeNode1(10);
      Tree tree = new Tree(root);
      tree.diagonalSum();
  }
}
