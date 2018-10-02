package com.mine.others;

public class TicTacToe {
	
	static int win[][] = {{0, 1, 2}, // Check first row.
            {3, 4, 5}, // Check second Row
            {6, 7, 8}, // Check third Row
            {0, 3, 6}, // Check first column
            {1, 4, 7}, // Check second Column
            {2, 5, 8}, // Check third Column
            {0, 4, 8}, // Check first Diagonal
            {2, 4, 6}}; // Check second Diagonal
	
	static boolean isWin(char board[], char c)
	{
	    // Check all possible winning combinations
	    for (int i=0; i<8; i++) {
	        if (board[win[i][0]] == c &&
	            board[win[i][1]] == c &&
	            board[win[i][2]] == c ) {
	            return true;
	        }
	    }
	    return false;
	}
	
	static boolean isValid(char board[])
	{
	    // Count number of 'X' and 'O' in the given board
	    int xCount=0, oCount=0;
	    for (int i=0; i<9; i++)
	    {
	       if (board[i]=='X') xCount++;
	       if (board[i]=='O') oCount++;
	    }
	 
	    // Board can be valid only if either xCount and oCount
	    // is same or xount is one more than oCount
	    if (xCount==oCount || xCount==oCount+1)
	    {
	        // Check if 'O' is winner
	        if (isWin(board, 'O'))
	        {
	            // Check if 'X' is also winner, then
	            // return false
	            if (isWin(board, 'X'))
	                 return false;
	 
	            // Else return true xCount and yCount are same
	            return (xCount == oCount);
	        }
	 
	        // If 'X' wins, then count of X must be greater
	        if (isWin(board, 'X') && xCount != oCount + 1)
	        return false;    
	 
	        // If 'O' is not winner, then return true
	        return true;
	    }
	    return false;
	}
	
	static boolean xWon = false, oWon = false;
	
	static void printResult() {
		if(xWon)
			System.out.println("X has won");
		else if(oWon)
			System.out.println("O has won");
	}
	public static void main(String[] args) {
		char[] board = {'O','X','X',
						'X','O','.',
						'X','O','O',};
		if(isValid(board))
			System.out.println("valid");
		else
			System.out.println("Not valid");
		
		char[][] board2 = { {'X','O','X'},
							{'.','O','.'},
							{'X','O','X'}};
		
		if(isValid(board2)) {
			System.out.println("valid");
			printResult();
		}
		else
			System.out.println("Not valid");
	}
	
	static boolean isWin(char board[][], char c)
	{
	    // Check all possible winning combinations
		for(int i=0;i<3;i++) {
			if(board[0][i]==c &&
					board[1][i]==c &&
					board[2][i]==c) {
				return true;
			}
		}
		
		for(int i=0;i<3;i++) {
			if(board[i][0]==c &&
					board[i][1]==c &&
					board[i][2]==c) {
				return true;
			}
		}
		
		if(board[0][0]==c && board[1][1]==c && board[2][2]==c) {
			return true;
		}
		if(board[0][2]==c && board[1][1]==c && board[2][0]==c) {
			return true;
		}
	    return false;
	}
	
	static boolean isValid(char board[][])
	{
	    // Count number of 'X' and 'O' in the given board
	    int xCount=0, oCount=0;
	    for (int i=0; i<3; i++)
	    	for (int j=0; j<3; j++)
		    {
		       if (board[i][j]=='X') xCount++;
		       if (board[i][j]=='O') oCount++;
		    }
	 
	    // Board can be valid only if either xCount and oCount
	    // is same or xCount is one more than oCount
	    if (xCount==oCount || xCount==oCount+1)
	    {
	        // Check if 'O' is winner
	        if (isWin(board, 'O'))
	        {
	            // Check if 'X' is also winner, then
	            // return false
	            if (isWin(board, 'X'))
	                 return false;
	            
	            //oWon = true;
	            // Else return true xCount and yCount are same
	            return (xCount == oCount);
	        }
	        // If 'X' wins, then count of X must be greater
	        if (isWin(board, 'X'))
	        	return (xCount==oCount+1);
	        //To find if X has won, nest above 2 conditions and set xWon accordingly
	 
	        // If 'O' is not winner, then return true
	        return true;
	    }
	    return false;
	}

}
