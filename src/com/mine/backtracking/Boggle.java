package com.mine.backtracking;

/*
 * Given a dictionary, a method to do lookup in dictionary and a M x N 
 * board where every cell has one character.
 * Find all possible words that can be formed by a sequence of 
 * adjacent characters. Note that we can move 
 * to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
 * 
 * SOLUTION:
 * The idea is to consider every character as a starting character and find all words starting with it. 
 * All words starting from a character can be found using Depth First Traversal. 
 * We do depth first traversal starting from every cell. 
 * We keep track of visited cells to make sure that a cell is considered only once in a word.
 */
public class Boggle {
	int M = 3;
	int N = 3;
	String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
	int n = dictionary.length;
	
	boolean isWord(String str) {
		for (int i=0; i<n; i++)
	        if (str.equals(dictionary[i]))
	          return true;
	    return false;
	}
	
	void findWordsUtil(char boggle[][], boolean visited[][], int i, int j, String str) {
		visited[i][j] = true;
		str = str+boggle[i][j];
		//System.out.println("str++"+str);
		if(isWord(str)) {
			System.out.println("WORD: "+str);
		}
		
		for(int row = i-1; row<=i+1&&row<M; row++)
			for(int col = j-1; col<=j+1&&col<N; col++)
				if(row>=0&&col>=0 && !visited[row][col])
					findWordsUtil(boggle, visited, row, col, str);
		
		visited[i][j] = false;
		str = str.substring(0, str.length()-1);
		//System.out.println("str--"+str);
	}
	
	void findWords(char boggle[][]) {
		boolean visited[][] = new boolean[M][N];
		String str = "";
		
		for(int i =0; i<M;i++)
			for(int j =0;j<N;j++)
				findWordsUtil(boggle, visited, i , j, str);
	}
	
	public static void main(String[] args) {
		char boggle[][] = {{'G','I','Z'},{'U','E','K'},{'Q','S','E'}};
		Boggle b = new Boggle();
		b.findWords(boggle);
	}

}
