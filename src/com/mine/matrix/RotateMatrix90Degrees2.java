package com.mine.matrix;

public class RotateMatrix90Degrees2 {
	
	static int[][] reverseColumns(int arr[][])
	{
	    for (int i=0; i<arr[0].length; i++)
	        for (int j=0,  k=arr[i].length-1; j<k; j++,k--)
	        {
	        	arr[j][i] = arr[j][i] + arr[k][i];
	        	arr[k][i] = arr[j][i] - arr[k][i];
	        	arr[j][i] = arr[j][i] - arr[k][i];
	        }
	    
	    return arr;
	}
	
	static int[][] transpose(int arr[][])
	{
	    for (int i=0; i<arr.length; i++)
	        for (int j=i; j<arr[i].length; j++)
	        {
	        	if(i!=j){
	        		arr[i][j] = arr[i][j]+arr[j][i];
	        		arr[j][i] = arr[i][j]-arr[j][i];
	        		arr[i][j] = arr[i][j]-arr[j][i];
	        	}
	        }
	    
	    return arr;
	}
	
	static void displayMatrix(int mat[][])
	{
	    for (int i = 0; i < mat.length; i++)
	    {
	        for (int j = 0; j < mat[i].length; j++)
	            System.out.print(mat[i][j]+" ");
	 
	        System.out.println();
	    }
	    System.out.println();
	}
	
	static int[][] rotate90(int arr[][])
	{
	    arr= transpose(arr);
	    arr=reverseColumns(arr);
	    return arr;
	}
	
	public static void main(String[] args) {
		int mat[][] = {
				{1, 2, 3, 4},
		        {5, 6, 7, 8},
		        {9, 10, 11, 12},
		        {13, 14, 15, 16}
		};
		mat = rotate90(mat);
		displayMatrix(mat);
	}
	
	static void swap(int[] array, int i, int j) {
		  int temp = array[i];
		  array[i] = array[j];
		  array[j] = temp;
		}
}
