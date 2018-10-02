package com.mine.myString;

import java.util.Scanner;

public class ReverseString {

	public static String reverse(String str) {
	    if ((null == str) || (str.length() <= 1)) {
	        return str;
	    }
	    return reverse(str.substring(1)) + str.charAt(0);
	}
	
	public static void main(String[] args) {
		String original,reverse="";
		Scanner in = new Scanner(System.in);
		 
	      System.out.println("Enter a string to reverse");
	      original = in.nextLine();
	 
	      int length = original.length();
	 
	      for ( int i = length - 1 ; i >= 0 ; i-- )
	         reverse = reverse + original.charAt(i);
	 
	      System.out.println("Reverse of entered string is:\n"+reverse);
	      
		System.out.println("Reverse of entered string by recusion is:\n"+reverse(original));
		
		System.out.println("Reverse of entered string by step by step recusion is:\n"+reverse2(original));
	}
	
	private static int i = 0;
	public static String reverse2(String str) {
        int localI = i++;
        if ((null == str) || (str.length()  <= 1)) {
            return str;
        }
        System.out.println("Step " + localI + ": " + str.substring(1) + " / " + str.charAt(0));
        String reversed = reverse2(str.substring(1)) + str.charAt(0);

        System.out.println("Step " + localI + " returns: " + reversed);
        return reversed;
    }
}
