package com.array;
/*
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. 
 * The functions should put all 0s first, then all 1s and all 2s in last.

Example
Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

 * */
class countzot {
	 
    // Sort the input array, the array is assumed to
    // have values in {0, 1, 2}
    static void sort012(int a[], int arr_size)
    {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0,temp=0;
        while (mid <= hi)
        {
            switch (a[mid])
            {
            case 0:
            {
                temp   =  a[lo];
                a[lo]  = a[mid];
                a[mid] = temp;
                lo++;
                mid++;
                break;
            }
            case 1:
                mid++;
                break;
            case 2:
            {
                temp = a[mid];
                a[mid] = a[hi];
                a[hi] = temp;
                hi--;
                break;
            }
            }
        }
    }
 
    /* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }
 
    /*Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        printArray(arr, arr_size);
    }
}