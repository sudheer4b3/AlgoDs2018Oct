package com.mine.myString;

public class StringWordsReverse {
	public static void main(String[] args) {
		System.out.println(StringWordsReverse.reverseWords("this is  an interview."));
	}
	
	public static String reverseWords(String sentence) {
	    if (sentence == null) {
	        return null;
	    }
	    String[] str = sentence.split(" ");
	    StringBuffer buffer = new StringBuffer();
	    String last = str[str.length-1];
	    boolean periodExists = false;
	    if (last.charAt(last.length()-1) == '.') {
	        periodExists = true;
	        str[str.length-1] = str[str.length-1].substring(0, last.length()-1);
	    }
	    for(int i = str.length-1; i>=0; i--) {
	        buffer.append(str[i]);
	        if (i != 0)
	        	buffer.append(" ");
	    }
	    if (periodExists) {
	        buffer.append(".");
	    }
	    return buffer.toString();
	}

}

/*
 * write a function which takes as input a string and returns a string which has its
words reversed. 
For example:
input: "this is  an interview."
output:"interview an  is this."
"



"interview. an is this "
""
 * */