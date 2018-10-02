 package com.mine.myString;

public class ReverseWords {
	public static  void main(String[] args) {
	    String s = "Neil Peart  rocks YYZ.";
	    String[] str =s.split(" ");
	    StringBuffer buffer = new StringBuffer();
	    System.out.println(str.length);
	    for(int i=str.length-1;i>=0;i--)
	    {
	        buffer.append(str[i]);
	        buffer.append(" ");
	    }
	    System.out.println("\nOriginal string: " + s);
	    System.out.println("Reverse word string: "+buffer.toString());
	}

}
