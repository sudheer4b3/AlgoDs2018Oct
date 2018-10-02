package com.mine.backtracking;

import java.util.Arrays;
import java.util.List;

public class MatrixAllPathsWithAverage2 {
	//pi = path Index. 
	void printAllPathsUtil(int mat[][], int i, int j, int m, int n, int path[], int pi)
	{
	    // Reached the bottom of the matrix so we are left with
	    // only option to move right
	    if (i == m - 1)
	    {
	        while(j<n)
	            path[pi++] = ((mat[i][j++]));
	        //path[pi + k - j] = ((mat[i+n][k]));
	        
	        int sum=0,l;
	        for (l = 0; l < pi; l++) {
	        	System.out.print(path[l]+ " ");
	        	sum+=path[l];
	        }
	        System.out.print(" = "+sum/l);
	        System.out.println();
	        return;
	    }
	 
	    // Reached the right corner of the matrix we are left with
	    // only the downward movement.
	    if (j == n - 1)
	    {
	        while(i<m)
	            path[pi++] = (mat[i++][j]);
	        //path[pi + k - i] = (mat[k+n][j]);
	        int sum=0,l;
	        for (l = 0; l < pi; l++) {
	        	System.out.print(path[l]+ " ");
	        	sum+=path[l];
	        }
	        System.out.print(" = "+sum/l);
	        System.out.println();
	        return;
	    }
	 
	    // Add the current cell to the path being generated
	    path[pi] = (mat[i][j]);
	    //path[pi] = (mat[i*n][j]);
	 
	    // Print all the paths that are possible after moving down
	    printAllPathsUtil(mat, i, j+1, m, n, path, pi + 1);
	 
	    // Print all the paths that are possible after moving right
	    printAllPathsUtil(mat, i+1, j, m, n, path, pi + 1);
	 
	    // Print all the paths that are possible after moving diagonal
	    //printAllPathsUtil(mat, i+1, j+1, m, n, path, pi + 1);
	}
	 
	// The main function that prints all paths from top left to bottom right
	// in a matrix 'mat' of size mXn
	void printAllPaths(int mat[][], int m, int n)
	{
	    int path[] = new int[m+n];
	    printAllPathsUtil(mat, 0, 0, m, n, path, 0);
	}
	
	public static void main(String[] args) {
		MatrixAllPathsWithAverage2 instance = new MatrixAllPathsWithAverage2();
		int mat[][] = { {1, 2, 3}, 
						{4, 5, 6}, 
						{7, 8, 9} };
		instance.printAllPaths(mat, 3, 3);
	}

}
