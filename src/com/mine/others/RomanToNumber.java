package com.mine.others;


public class RomanToNumber {

	// This function returns value of a Roman symbol
    int value(char r)
    {   
        int ret = -1;
        switch(r) {
        case 'I':
        	ret = 1;
        	break;
        case 'V':
        	ret = 5;
        	break;
        case 'X':
        	ret = 10;
        	break;
        case 'L':
        	ret = 50;
        	break;
        case 'C':
        	ret = 100;
        	break;
        case 'D':
        	ret = 500;
        	break;
        case 'M':
        	ret = 1000;
        	break;
        
        }
        return ret;
    }
    
    
 
    // Finds decimal value of a given romal numeral
    int romanToDecimal(String str)
    {
        // Initialize result
        int res = 0;
 
        for (int i=0; i<str.length(); i++)
        {
            // Getting value of symbol s[i]
            int s1 = value(str.charAt(i));
 
            // Getting value of symbol s[i+1]
            if (i+1 <str.length())
            {
                int s2 = value(str.charAt(i+1));
 
                // Comparing both values
                if (s1 >= s2)
                {
                    // Value of current symbol is greater
                    // or equalto the next symbol
                    res = res + s1;
                }
                else
                {
                    res = res + s2 - s1;
                    i++; // Value of current symbol is
                    // less than the next symbol
                }
            }
            else
            {
                res = res + s1;
                i++;
            }
        }
 
        return res;
    }
 
    // Driver method
    public static void main(String args[])
    {
        RomanToNumber ob = new RomanToNumber();
 
        // Considering inputs given are valid
        String str = "MCMIV";
        System.out.println("Integer form of Roman Numeral: " + str+
                           " is " + ob.romanToDecimal(str));
    }
}
