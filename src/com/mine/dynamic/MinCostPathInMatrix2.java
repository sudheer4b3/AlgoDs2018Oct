package com.mine.dynamic;

/*
 * This only moves right or down, no diagonal movement allowed
 * */
public class MinCostPathInMatrix2 {
	
	int minCost(int cost[][], int m, int n)
	{
	     int i, j;
	 
	     // Instead of following line, we can use int tc[m+1][n+1] or 
	     // dynamically allocate memoery to save space. The following line is
	     // used to keep te program simple and make it working on all compilers.
	     int tc[][] = new int[m+1][n+1];  
	 
	     tc[0][0] = cost[0][0];
	 
	     /* Initialize first column of total cost(tc) array */
	     for (i = 1; i <= m; i++)
	        tc[i][0] = tc[i-1][0] + cost[i][0];
	 
	     /* Initialize first row of tc array */
	     for (j = 1; j <= n; j++)
	        tc[0][j] = tc[0][j-1] + cost[0][j];
	 
	     /* Construct rest of the tc array */
	     for (i = 1; i <= m; i++)
	        for (j = 1; j <= n; j++)
	            tc[i][j] = min( tc[i-1][j], tc[i][j-1]) + cost[i][j];
	 
	     return tc[m][n];
	}
	
	int min( int y, int x)
	{
	   if (x < y)
	      return x;
	   return y;
	}
	
	public static void main(String[] args) {
		MinCostPathInMatrix2 instance = new MinCostPathInMatrix2();
		int cost[][] = { 
				{1, 8, 3},
                {9, 0, 2},
                {1, 0, 3} };
		
		System.out.println(instance.minCost(cost, 2, 2));
	}

}
