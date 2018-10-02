package com.test.hack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int maxDiff(int arr[])
	{     
	  int maxDiff = arr[1] - arr[0];
	  int arrSize = arr.length;
	  
	  for(int i = 0; i < arrSize-1; i++)
	  {
	    for(int j = i+1; j < arrSize; j++)
	    {        
	      if(arr[j] - arr[i] > maxDiff)   
	    	  maxDiff = arr[j] - arr[i];
	    }    
	  }          
	  return maxDiff;
	}    
	
	static int diff(int a, int b) {
		return 0;
	}
	 
	/* Driver program to test above function */
	public static void main(String[] args) 
	{
		List<String> result = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		String input;
		try {
            while (scanner.hasNextLine() && !(input = scanner.nextLine()).equals("")){

        		String[] a = input.split(" ");
        		int x = Integer.valueOf(a[0]);
        		int y = Integer.valueOf(a[1]);
        		if(x<0 || y<0)
        			result.add("java.lang.Exception: n and p should be non-negative");
        		else
        			result.add(a[0].toString());
        		diff(x , y);
        		Integer z = x;
        		z.toString();
            }
            for(int i = 0; i < result.size(); i++) {
            	System.out.println(result.get(i));
            }

        } finally {
            scanner.close();
        }
		
	}

}
