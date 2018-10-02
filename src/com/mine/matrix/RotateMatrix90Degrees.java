package com.mine.matrix;

public class RotateMatrix90Degrees {
	int N = 4;
	
	void rotateMatrix(int mat[][]) {
		for (int x = 0; x < N / 2; x++)
	    {
	        // Consider elements in group of 4 in 
	        // current square
	        for (int y = x; y < N-x-1; y++)
	        {
	            // store current cell in temp variable
	            int temp = mat[x][y];
	 
	            // move values from right to top
	            mat[x][y] = mat[y][N-1-x];
	 
	            // move values from bottom to right
	            mat[y][N-1-x] = mat[N-1-x][N-1-y];
	 
	            // move values from left to bottom
	            mat[N-1-x][N-1-y] = mat[N-1-y][x];
	 
	            // assign temp to left
	            mat[N-1-y][x] = temp;
	        }
	    }
	}
	
	void displayMatrix(int mat[][])
	{
	    for (int i = 0; i < N; i++)
	    {
	        for (int j = 0; j < N; j++)
	            System.out.print(mat[i][j]+" ");
	 
	        System.out.println();
	    }
	    System.out.println();
	}
	
	void rotateCustom(int mat[][]) {
		for(int x = 0; x<N/2;x++)
		{
			for(int y = 0; y<N;y++) {
				int temp = mat[x][y];
				mat[x][y] = mat[N-x-1][N-y-1];
				mat[N-x-1][N-y-1] = temp;
			}
		}
	}
	
	void rotateCustom2(int mat[][]) {
		for(int x = 0; x<N/2;x++)
		{
			for(int y = 0; y<N;y++) {
				int temp = mat[x][y];
				mat[x][y] = mat[N-x-1][N-y-1];
				mat[N-x-1][N-y-1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int mat[][] = {
				{1, 2, 3, 4},
		        {5, 6, 7, 8},
		        {9, 10, 11, 12},
		        {13, 14, 15, 16}
		};
		RotateMatrix90Degrees ins = new RotateMatrix90Degrees();
		ins.displayMatrix(mat);
		
		ins.rotateMatrix(mat);
		ins.displayMatrix(mat);
		
		ins.rotateMatrix(mat);
		ins.displayMatrix(mat);
		
		int mat2[][] = {
				{1, 2, 3, 4},
		        {5, 6, 7, 8},
		        {9, 10, 11, 12},
		        {13, 14, 15, 16}
		};
		ins.displayMatrix(mat2);
		
		ins.rotateCustom(mat2);
		ins.displayMatrix(mat2);
	}

}
