package com.mine.others;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class AlienDictionary2 {
	
	private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List
 
    //Constructor
    AlienDictionary2(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w) { adj[v].add(w); }
 
    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, Boolean visited[],Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
 
        // Push current vertex to stack which stores result
        stack.push(v);
    }
 
    // The function to do Topological Sort. It uses recursive
    // topologicalSortUtil()
    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();
 
        // Mark all the vertices as not visited
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // Call the recursive helper function to store Topological
        // Sort starting from all vertices one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
 
        // Print contents of stack
        while (stack.empty()==false) {
        	int a = (int) stack.pop();
        	char c = (char) (a+'a');
            System.out.print(c + " ");
        }
    }
 
 // This function finds and prints order of character from a sorted
 // array of words. n is size of words[].  alpha is set of possible
 // alphabets.
 // For simplicity, this function is written in a way that only
 // first 'alpha' characters can be there in words array.  For
 // example if alpha is 7, then words[] should have only 'a', 'b',
 // 'c' 'd', 'e', 'f', 'g'
    static void printOrder(String words[], int n, int alpha)
    {
        // Create a graph with 'alpha' edges
    	AlienDictionary2 g = new AlienDictionary2(alpha);
     
        // Process all adjacent pairs of words and create a graph
        for (int i = 0; i < n-1; i++)
        {
            // Take the current two words and find the first mismatching
            // character
            String word1 = words[i], word2 = words[i+1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++)
            {
                // If we find a mismatching character, then add an edge
                // from character of word1 to that of word2
                if (word1.charAt(j) != word2.charAt(j))
                {
                	System.out.println("adding edge : "+ word1.charAt(j)+word2.charAt(j));
                    g.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
                    break;
                }
            }
        }
     
        // Print topological sort of the above created graph
        g.topologicalSort();
    }
    // Driver method
    public static void main(String[] args) {
    	//String words[] = {"caa", "aaa", "aab"};
    	//String words[] = {"aab", "bcc", "ccc"};
    	String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        printOrder(words, 5, 4);
	}

}
