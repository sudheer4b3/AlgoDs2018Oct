package com.mine.backtracking;

import java.util.HashSet;

public class SudokuSolver {
	
	public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) { //trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board)) {
                            	//this.printGrid(board);
                                return true; //If it's the solution return true
                            }
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        this.printGrid(board);
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
            		board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) 
            	return false; //check 3*3 block
        }
        return true;
    }
    
    void printGrid(char grid[][]) {
    	System.out.println("***************");
    	System.out.println();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
				System.out.print(grid[i][j]+" ");
			System.out.println();
		}
	}
    
    public static void main(String[] args) {
		char[][] board = new char[][] {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
				
		};
		
		SudokuSolver ins = new SudokuSolver();
		ins.solveSudoku(board);
		
		System.out.println(isValidSudoku(board));
	}
    
    
    //Just to check validity
    static public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

}
