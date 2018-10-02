package com.mine.others;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Islands2
{
    //No of rows and columns

    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {
        return (row >= 0) && (row < M.length) &&
               (col >= 0) && (col < M[0].length) &&
               M[row][col]==1 && !visited[row][col];
    }

    void DFS(int M[][], int row, int col, boolean visited[][])
    {
        int rowNbr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = {-1,  0,  1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) )
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    int countIslands(int M[][])
    {
    	if(M==null)
    		return 0;
    	int m = M.length;
    	int n = M[0].length;
        boolean visited[][] = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (M[i][j]==1 && !visited[i][j]) 
                {
                    DFS(M, i, j, visited);
                    ++count;
                }
 
        return count;
    }
 
    public static void main (String[] args) throws java.lang.Exception
    {
    	/*int M[][] = new int[][] { {1, 0, 1, 0, 0, 0, 0, 0},
    		{0, 0, 0, 0, 0, 0, 0, 0},
    		{1, 0, 0, 0, 0, 0, 0, 0},
    		{0, 0, 0, 0, 1, 0, 0, 0},
    		{0, 0, 0, 0, 0, 1, 0, 0}
    		
    	};*/
    	int mat[][] = new int[][] { {1, 0, 0, 0, 0, 0},
    								{0, 0, 1, 1, 1, 0},
    								{0, 0, 0, 1, 0, 0},
    								{0, 0, 0, 1, 0, 0},
    								{0, 0, 0, 1, 0, 0},
    								{0, 0, 0, 0, 1, 0},
    								{0, 0, 0, 0, 0, 0}
    		
    						};
    	Islands2 I = new Islands2();
    	System.out.println(I.countIslands(mat));
    }
}