package com.mine.others;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Points{
	char xo;
	boolean horizontal;
	boolean vertical;
	boolean leftdiagonal;
	boolean rightdiagonal;
}
class Result {
	int x;
	int o;
}

public class TicTacToeVariation {
	boolean checkBoxValidity(Points pointMat[][], char mat[][], 
			char currentChar, int i, int j, int N, String direction) {
		//pointMat[i][j].xo = currentChar;
		if(i>=0 && j>=0 && i<N && j < N 
				&& ( (direction.equals("H") && pointMat[i][j].horizontal==false)
				|| (direction.equals("V") && pointMat[i][j].vertical==false)
				|| (direction.equals("LD") && pointMat[i][j].leftdiagonal==false)
				|| (direction.equals("RD") && pointMat[i][j].rightdiagonal==false)) ) {
			if(currentChar == 'x' || currentChar == 'X')
			{
				if(mat[i][j] == 'x' || mat[i][j] == 'X')
					return true;
			} else if(currentChar == 'o' || currentChar == 'O')
			{
				if(mat[i][j] == 'o' || mat[i][j] == 'O')
					return true;
			}
		}
		return false;
	}
	
	void assessPoints(char mat[][], int N, List<Result> results) {
		int xPoints = 0, oPoints = 0;
		int it = 0, jt = 0, count = 0;
		Points pointMat[][] = new Points[N][N];
		for (int a = 0; a < N; a++)
			for(int b = 0; b < N; b++) {
				pointMat[a][b] = new Points();
			}
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++) {
				it = i; jt = j;
				//check horizontal
				count = 1;
				while(checkBoxValidity(pointMat, mat, mat[i][j], it, ++jt, N,"H")) {
					++count;
					if(mat[i][j] == 'x' || mat[i][j] == 'X') {
						pointMat[it][jt].xo = 'x';
						pointMat[it][jt].horizontal = true;
					} else {
						pointMat[it][jt].xo = 'o';
						pointMat[it][jt].horizontal = true;
					}
					if(count>=3) {
						if(mat[i][j] == 'x' || mat[i][j] == 'X') {
							xPoints++;
						} else {
							oPoints++;
						}
					}
				}
				it = i; jt = j; count = 1;
				//check vertical
				while(checkBoxValidity(pointMat, mat, mat[i][j], ++it, jt, N,"V")) {
					++count;
					if(mat[i][j] == 'x' || mat[i][j] == 'X') {
						pointMat[it][jt].xo = 'x';
						pointMat[it][jt].vertical = true;
					} else {
						pointMat[it][jt].xo = 'o';
						pointMat[it][jt].vertical = true;
					}
					if(count>=3) {
						if(mat[i][j] == 'x' || mat[i][j] == 'X') {
							xPoints++;
						} else {
							oPoints++;
						}
					}
				}
				it = i; jt = j; count = 1;
				//check left diagonal down
				while(checkBoxValidity(pointMat, mat, mat[i][j], ++it, --jt, N,"LD")) {
					++count;
					if(mat[i][j] == 'x' || mat[i][j] == 'X') {
						pointMat[it][jt].xo = 'x';
						pointMat[it][jt].leftdiagonal = true;
					} else {
						pointMat[it][jt].xo = 'o';
						pointMat[it][jt].leftdiagonal = true;
					}
					if(count>=3) {
						if(mat[i][j] == 'x' || mat[i][j] == 'X') {
							xPoints++;
						} else {
							oPoints++;
						}
					}
				}
				it = i; jt = j; count = 1;
				//check right diagonal down
				while(checkBoxValidity(pointMat, mat, mat[i][j], ++it, ++jt, N, "RD")) {
					++count;
					if(mat[i][j] == 'x' || mat[i][j] == 'X') {
						pointMat[it][jt].xo = 'x';
						pointMat[it][jt].rightdiagonal = true;
					} else {
						pointMat[it][jt].xo = 'o';
						pointMat[it][jt].rightdiagonal = true;
					}
					if(count>=3) {
						if(mat[i][j] == 'x' || mat[i][j] == 'X') {
							xPoints++;
						} else {
							oPoints++;
						}
					}
				}
			}
		}
		Result result = new Result();
		result.x = xPoints;
		result.o = oPoints;
		results.add(result);
		//System.out.print(xPoints+" ");
		//System.out.print(oPoints+" ");
	}
	
	public static void main(String[] args) {
		TicTacToeVariation ttt = new TicTacToeVariation();
		List<Result> results = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
	        //System.out.println("Enter the number of expressions you want to input:");
		int i = 0, iNow = 0, thisTest = 0;
        int tcNum = 0;
        int N = 0;
        //List<Integer> result = new LinkedList<>();
        boolean flag = false;
        char mat[][] = null;
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
        		iNow = 0;
        		String rowCol[] = line.split(" ");
        		
        		N = Integer.parseInt(rowCol[0]);
        		flag = true;
        		mat = new char[N][N];
        	} else {
        		iNow++;
        		if(iNow<=N) {
        			try {
        				String[] matRow = line.split(" ");
        				for(int j=0;j<matRow.length;j++) {
        					mat[iNow-1][j] = matRow[j].charAt(0);
        				}
						
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Wrong input, exceeds column limit");
					}
        			
        		}
        		if(iNow >= N) {
        			flag = false;
        			ttt.assessPoints(mat, N, results);
        			if(thisTest>=tcNum) {
        				for (int r = 0; r <results.size(); r++) {
        					System.out.println(results.get(r).x+" "+results.get(r).o);
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
