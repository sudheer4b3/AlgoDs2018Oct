package com.array;

/*
 * Iterative way:
1) Initialize start and end indexes. 
start = 0, end = n-1
2) In a loop, swap arr[start] with arr[end] and change start and end as follows.
start = start +1; end = end – 1
 * */

public class ReverseArray {
	
	/* Function to reverse arr[] from start to end*/
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start+1, end-1);
    }
 
    /* Utility that prints out an array on a line */
    static void printArray(int arr[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
 
    /*Driver function to check for above functions*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        printArray(arr, arr.length);
        rvereseArray(arr, 0, arr.length-1);
        System.out.println("Reversed array is ");
        printArray(arr, arr.length);
    }

}
