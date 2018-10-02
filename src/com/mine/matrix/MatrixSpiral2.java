package com.mine.matrix;

public class MatrixSpiral2 {
static int R,C;
	
	void spiralPrint(int m, int n, int a[][], int ks) {
		int i, k = 0, l = 0;
		 int count = 0;
	    /*  k - starting row index
	        m - ending row index
	        l - starting column index
	        n - ending column index
	        i - iterator
	    */
	 
	    while (k < m && l < n)
	    {
	        /* Print the first row from the remaining rows */
	        for (i = l; i < n; ++i)
	        {
	        	System.out.print(a[k][i]+" ");
	            //printf("%d ", a[k][i]);
	        	count++;
	        	if(count==ks) {
		        	System.out.println("this is the element");
		        	break;
	        	}
	        }
	        k++;
	 
	        /* Print the last column from the remaining columns */
	        for (i = k; i < m; ++i)
	        {
	        	System.out.print(a[i][n-1]+" ");
	            //printf("%d ", a[i][n-1]);
	        	count++;
	        	if(count==ks) {
		        	System.out.println("this is the element");
		        	break;
	        	}
	        }
	        n--;
	 
	        /* Print the last row from the remaining rows */
	        if ( k < m)
	        {
	            for (i = n-1; i >= l; --i)
	            {
	            	System.out.print(a[m-1][i]+" ");
	                //printf("%d ", a[m-1][i]);
	            	count++;
	            	if(count==ks) {
	    	        	System.out.println("this is the element");
	    	        	break;
	            	}
	            }
	            m--;
	        }
	 
	        /* Print the first column from the remaining columns */
	        if (l < n)
	        {
	            for (i = m-1; i >= k; --i)
	            {
	            	System.out.print(a[i][l]+" ");
	                //printf("%d ", a[i][l]);
	            	count++;
	            	if(count==ks) {
	    	        	System.out.println("this is the element");
	    	        	break;
	            	}
	            }
	            l++;    
	        }        
	    }
	}
	
	public static void main(String[] args) {
		MatrixSpiral2 ins = new MatrixSpiral2();
		int a[][] = { {1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		    };
		R = a.length;
		C=a[0].length;
		ins.spiralPrint(R, C, a, 10);
		
	}

}
