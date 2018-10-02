package com.array;
//Given an array make the max number from it.
public class MaximizeArray {
	
	static void maximizeArray(int arr[], int len, int swaps)
	{
		int max_index = -1;
		for(int j = 0; (j < len ) && (swaps > 0) ; ++j)
		{
		    max_index = findMaxIndex(arr,j,j+swaps);
	        if(j != max_index)
	        {
	        	int temp = arr[max_index];//arr[j];
	        	for(int t = max_index; t>j; t--) {
	        		arr[t] = arr[t - 1];
	        		//tMaxIndex--;
		            //arr[j] = arr[max_index];
		            //arr[max_index] = temp;
	        	}
	        	arr[j] = temp;
	        }
	        swaps = swaps - (Math.abs(max_index - j));
		}
	}
	static int findMaxIndex(int arr[],int start, int end)
	{
	    int max_index = start;
	    for(int curr = start+1; curr <= end&&curr<arr.length; curr++)  
	    { 
	        if(arr[curr] > arr[max_index])
	        {
	            max_index = curr;
	        }
	        
	    }
	    return max_index;
	}
	
	public static void main(String[] args) {
		int arr[]={1,5,2,9,3,7,2,8,9,3};
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);
		
		System.out.println();
		maximizeArray(arr, arr.length, 15);
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);
	}

}
