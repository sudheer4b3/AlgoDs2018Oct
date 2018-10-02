package com.mine.others;

public class CrossWord {
	static int R = 3, C = 14;
	int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	
	boolean search2D(char grid[][], int row, int col, String word) {
		// If first character of word doesn't match with
	    // given starting point in grid.
		if (grid[row][col] != word.charAt(0))
		      return false;
		
		int len = word.length();
		
		// Search word in all 8 directions starting from (row,col)
	    for (int dir = 0; dir < 8; dir++)
	    {
	        // Initialize starting point for current direction
	        int k, rd = row + x[dir], cd = col + y[dir];
	 
	        // First character is already checked, match remaining
	        // characters
	        for (k = 1; k < len; k++)
	        {
	            // If out of bound break
	            if (rd >= R || rd < 0 || cd >= C || cd < 0)
	                break;
	 
	            // If not matched,  break
	            if (grid[rd][cd] != word.charAt(k))
	                break;
	 
	            //  Moving in particular direction
	            rd += x[dir]; cd += y[dir];
	        }
	 
	        // If all character matched, then value of must
	        // be equal to length of word
	        if (k == len)
	            return true;
	    }
		
		return false;
	}
	
	void patternSearch(char grid[][], String word)
	{
	    // Consider every point as starting point and search
	    // given word
		R = grid.length;
		C = grid[0].length;
	    for (int row = 0; row < R; row++)
	       for (int col = 0; col < C; col++)
	          if (search2D(grid, row, col, word))
	        	  System.out.println("pattern found at "+row+" "+col);
	}
	
	public static void main(String[] args) {
		char grid[][] = {{'G','E','E','K','S','F','O','R','G','E','E','K','S'},
				{'G','E','E','K','S','Q','U','I','Z','G','E','E','K'},
				{'I','D','E','Q','A','P','R','A','C','T','I','C','E'},
               };
		
		CrossWord ins = new CrossWord();
		ins.patternSearch(grid, "GEEKS");
		System.out.println();
		ins.patternSearch(grid, "EEE");
	}

}

/*
 * Given a 2D grid of characters and a word, find all occurrences of given word in grid. 
 * A word can be matched in all 8 directions at any point. 
 * Word is said be found in a direction if all characters match in this direction (not in zig-zag form).

The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up and 4 Diagonal directions.

Example:

Input:  grid[][] = {"GEEKSFORGEEKS",
                    "GEEKSQUIZGEEK",
                    "IDEQAPRACTICE"};
        word = "GEEKS"

Output: pattern found at 0, 0
        pattern found at 0, 8
        pattern found at 1, 0

Input:  grid[][] = {"GEEKSFORGEEKS",
                    "GEEKSQUIZGEEK",
                    "IDEQAPRACTICE"};
        word = "EEE"

Output: pattern found at 0, 2
        pattern found at 0, 10
        pattern found at 2, 2
        pattern found at 2, 12
 * */
