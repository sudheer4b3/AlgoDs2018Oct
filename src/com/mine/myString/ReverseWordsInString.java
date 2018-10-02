package com.mine.myString;

//This can be done using stack.
//split by ' ', store in stack, pop and save in new string with a space.
public class ReverseWordsInString {
	
	static String reverseWordByWord(String str){
        int strLeng = str.length()-1;
        String reverse = "", temp = "";

        for(int i = 0; i <= strLeng; i++){
        	if(str.charAt(i)!=' ')
        		temp += str.charAt(i);
            if((str.charAt(i) == ' ') || (i == strLeng)){
                for(int j = temp.length()-1; j >= 0; j--){
                    reverse += temp.charAt(j);
                    if((j == 0) && (i != strLeng))
                        reverse += " ";
                }
                temp = "";
            }
        }
        return reverse;
    }
	
	public static void main(String[] args) {
		String s = "i like this program";
		String rev = reverseWordByWord(s);
		System.out.println(rev);
		
		int length = rev.length();
		String reverse="";
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + rev.charAt(i);
        System.out.println("Result:" + reverse); 
	}

}
