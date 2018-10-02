package com.mine.others;


class Solution
{

    public static void main(String args[])
    {
        int arr[] = {2, 4};
        int m = arr.length;
        int n = 6;
        System.out.println(count(arr, m, n));
    }
    
    static int count (int num[], int m, int sum) {
        if(sum==0)
             return 1;
        
        if(sum<0)
            return 0;
            
        if(m<=0)
            return 0;
            
        int count = count(num, m-1,sum) +
        		count(num,m, sum-num[m-1]);
        
        return count;
    }
}