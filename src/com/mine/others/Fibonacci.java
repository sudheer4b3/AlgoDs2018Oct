package com.mine.others;

import java.util.Scanner;

public class Fibonacci {
	
	/* * Java program for Fibonacci number using recursion. 
	 * * This program uses tail recursion to calculate Fibonacci number for a given number * @return Fibonacci number */
	public static int fibonacci(int number){ 
		if(number == 1 || number == 2)
		{ return 1; } 
		return fibonacci(number-1) + fibonacci(number -2); //tail recursion 
		} 
	
	/* * Java program to calculate Fibonacci number using loop or Iteration. * @return Fibonacci number */ 
	public static int fibonacci2(int number){
		if(number == 1 || number == 2)
		{ return 1; } 
		int fibo1=1, fibo2=1, fibonacci=1; 
		for(int i= 3; i<= number; i++)
		{ //Fibonacci number is sum of previous two Fibonacci number 
			fibonacci = fibo1 + fibo2; 
			fibo1 = fibo2; 
			fibo2 = fibonacci; 
		} 
		return fibonacci; //Fibonacci number } 
	}
	
	static int f[] = new int[200];
	static int fib(int n)
	{
	    // Base cases
	    if (n == 0)
	        return 0;
	    if (n == 1 || n == 2)
	        return (f[n] = 1);
	 
	    // If fib(n) is already computed
	    if (f[n]!=0)
	        return f[n];
	 
	    int k = (n & 1)==1? (n+1)/2 : n/2;
	 
	    // Applyting above formula [Note value n&1 is 1
	    // if n is odd, else 0.
	    f[n] = (n & 1)==1? (fib(k)*fib(k) + fib(k-1)*fib(k-1))
	           : (2*fib(k-1) + fib(k))*fib(k);
	 
	    return f[n];
	}
	
	public static void main(String args[]) { //input to print Fibonacci series upto how many numbers 
		System.out.println("Enter number upto which Fibonacci series to print: "); 
		int number = new Scanner(System.in).nextInt(); 
		System.out.println("Fibonacci series upto " + number +" numbers : "); 
		//printing Fibonacci series upto number 
		for(int i=1; i<=number; i++){ 
			System.out.print(fibonacci(i) +" "); 
		}
		System.out.println();
		for(int i=1; i<=number; i++){ 
			System.out.print(fibonacci2(i) +" "); 
		}
		System.out.println("\n"+number+"th fib number is: "+fib(number));
	}

}
