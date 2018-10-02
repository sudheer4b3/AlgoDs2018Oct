package com.mine.myString;

public class StringReverse {
	public static String reverse(String str)
	{
		if ((str==null)||(str. length() <= 1) )
			return str;
		return reverse(str. substring(1)) + str. charAt(0);
	}
	
	public static String reverse1(String str, int len)
	{
		if (len < 0)
	         return "";
	      else
	         return str.charAt(len) + reverse1(str, len-1);
	}
	
	public static void main(String[] args) {
		System.out.println(StringReverse.reverse("manjupatil"));
		System.out.println(StringReverse.reverse1("manjupatil", "manjupatil".length()-1));
	}
}
