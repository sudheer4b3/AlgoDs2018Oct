package com.mine.backtracking;

/*
 * 2 approaches captured here. Bottom approach is simple to code.
 * */
public class Sudoku {
	int N = 9;
	class RowCol {
		int row=0;
		int col=0;
	}
	RowCol rowcol = new RowCol();
	
	boolean solveSudoku(int grid[][]) {
		//rowcol.row = 0;
		//rowcol.col=0;
		if (!FindUnassignedLocation(grid, rowcol))
		       return true; // success!
		
		int row = rowcol.row;
		int col = rowcol.col;
		// consider digits 1 to 9
	    for (int num = 1; num <= 9; num++)
	    {
	        // if looks promising
	        if (isSafe(grid, row, col, num))
	        {
	            // make tentative assignment
	            grid[row][col] = num;
	 
	            // return, if success, yay!
	            if (solveSudoku(grid))
	                return true;
	 
	            // failure, unmake & try again
	            grid[row][col] = 0;
	        }
	    }
		return false;
	}
	
	boolean FindUnassignedLocation(int grid[][], RowCol rowcol)
	{
	    for (rowcol.row = 0; rowcol.row < N; rowcol.row++)
	        for (rowcol.col = 0; rowcol.col < N; rowcol.col++)
	            if (grid[rowcol.row][rowcol.col] == 0)
	                return true;
	    return false;
	}
	
	/* Returns a boolean which indicates whether any assigned entry
	   in the specified row matches the given number. */
	boolean UsedInRow(int grid[][], Integer row, Integer num)
	{
	    for (int col = 0; col < N; col++)
	        if (grid[row][col] == num)
	            return true;
	    return false;
	}
	 
	/* Returns a boolean which indicates whether any assigned entry
	   in the specified column matches the given number. */
	boolean UsedInCol(int grid[][], Integer col, Integer num)
	{
	    for (int row = 0; row < N; row++)
	        if (grid[row][col] == num)
	            return true;
	    return false;
	}
	 
	/* Returns a boolean which indicates whether any assigned entry
	   within the specified 3x3 box matches the given number. */
	boolean UsedInBox(int grid[][], Integer boxStartRow, Integer boxStartCol, int num)
	{
	    for (int row = 0; row < 3; row++)
	        for (int col = 0; col < 3; col++)
	            if (grid[row+boxStartRow][col+boxStartCol] == num)
	                return true;
	    return false;
	}
	
	boolean isSafe(int grid[][], int row, int col, int num)
	{
	    /* Check if 'num' is not already placed in current row,
	       current column and current 3x3 box */
	    return !UsedInRow(grid, row, num) &&
	           !UsedInCol(grid, col, num) &&
	           !UsedInBox(grid, row - row%3 , col - col%3, num);
	}
	
	void printGrid(int grid[][]) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.print(grid[i][j]+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int grid[][] = /*{{1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}};*/
				{{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		Sudoku s = new Sudoku();
		
		if(s.solveSudoku(grid))
			s.printGrid(grid);
		else
			System.out.println("no solution: "+s.rowcol.row+" "+s.rowcol.col);
		
		int[][] board = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		System.out.println("before");
		s.printGrid(board);
		System.out.println();
		System.out.println("**********************************");
		System.out.println("calling solveSudoku2");
		if(s.solveSudoku2(board))
			s.printGrid(board);
	}
	
	public boolean solveSudoku2(int[][] board) {
		return solve(board);
	}
	
	public boolean solve(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]==0) {
					for(int k=1;k<=9;k++) {
						if(isValid(board,i,j,k)) {
							board[i][j]=k;
							if(solve(board)) {
								return true;
							} else {
								board[i][j]=0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isValid(int[][] board, int row, int col, int num) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != 0 && board[i][col] == num) return false; //check row
            if(board[row][i] != 0 && board[row][i] == num) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != 0 && 
            		board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) 
            	return false; //check 3*3 block
        }
        return true;
    }

}
