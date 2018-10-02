package com.mine.others;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Islands
{
    //No of rows and columns
    static int ROW = 0, COL = 0;

    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {
        return (row >= 0) && (row < ROW) &&
               (col >= 0) && (col < COL) &&
               (M[row][col]==1 && !visited[row][col]);
    }

    void DFS(int M[][], int row, int col, boolean visited[][])
    {
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) )
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    int countIslands(int M[][])
    {
        boolean visited[][] = new boolean[ROW][COL];

        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
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
    		
    	};
    	int M[][] = new int[][] {{1, 0, 0, 0, 0, 0},
    		{0, 0, 1, 1, 1, 0},
    		{0, 0, 0, 1, 0, 0},
    		{0, 0, 0, 1, 0, 0},
    		{0, 0, 0, 1, 0, 0},
    		{1, 0, 0, 0, 1, 0},
    		{0, 0, 0, 0, 0, 0}
    		
    	};*/
        Islands I = new Islands();
        Scanner sc = new Scanner(System.in);
        int i = 0, iNow = 0, thisTest = 0;
        int tcNum = 0;
        int rows = 0, cols = 0;
        List<Integer> result = new LinkedList<>();
        boolean flag = false;
        int mat[][] = null;
        //String expr[] = new String[0];
        while(sc.hasNextLine()) {
        	i++;
        	String line = sc.nextLine();
        	if(i==1) {
        		try {
        			tcNum = Integer.parseInt(line);
				} catch (NumberFormatException e) {
					System.out.println("provided input is not a number");
					return;
				}
        		
        	} else if(flag == false) {
        		thisTest++;
        		if(thisTest>tcNum) {
        			//print result
        			return;
        		}
        		rows = cols = iNow = 0;
        		String rowCol[] = line.split(" ");
        		if(rowCol.length > 2) {
        			System.out.println("wrong input, expected only 2 parameters");
        		}
        		ROW = rows = Integer.parseInt(rowCol[0]);
        		COL = cols = Integer.parseInt(rowCol[1]);
        		flag = true;
        		mat = new int[rows][cols];
        	} else {
        		iNow++;
        		if(iNow<=rows) {
        			try {
        				String[] matRow = line.split(" ");
        				for(int j=0;j<matRow.length;j++) {
        					mat[iNow-1][j] = Integer.parseInt(matRow[j]);
        				}
						
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Wrong input, exceeds column limit");
					}
        			
        		}
        		if(iNow >= rows) {
        			flag = false;
        			result.add(I.countIslands(mat));
        			if(thisTest>=tcNum) {
        				for (int r = 0; r <result.size(); r++) {
        					System.out.println(result.get(r));
        				}
        				return;
        			}
        		}
        	}
        	/*if(i != tcNum+1) {
        		continue;
        	} else
        		break;*/
        	//System.out.println(sc.nextLine());
        }
    
    }
}