package com.mine.others;

import java.util.Arrays;

public class Add1ToDigitArray {
	/*following creates new array everytime*/
	public static final int[] addOne(int[] digits) {
	    int carry = 1;
	    int[] result = new int[digits.length];
	    for (int i = digits.length - 1; i >= 0; i--) {
	        int val = digits[i] + carry;
	        result[i] = val % 10;
	        carry = val / 10;
	    }
	    if (carry == 1) {
	        result = new int[digits.length + 1];
	        result[0] = 1;
	    }
	    return result;
	}
	
	/*following does not create new array everytime*/
	public static int[] plusOne(int[] digits) {
	    if (digits == null) return null;
	    if (digits.length == 0) return new int[] {1};
	    for (int i = digits.length - 1; i >= 0; i--) {
	        if (digits[i] != 9) {
	            digits[i]++;
	            return digits;
	        } else digits[i] = 0;
	    }
	    int[] retVal = new int[digits.length + 1];
	    retVal[0] = 1;
	    for (int i = 1; i < retVal.length; i++) 
	    	retVal[i] = 0;
	    return retVal;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(addOne(new int[]{9,9,9})));
		System.out.println(Arrays.toString(addOne(new int[]{9,9,9,9})));
		System.out.println(Arrays.toString(addOne(new int[]{1,9,9,9})));
		System.out.println(Arrays.toString(addOne(new int[]{9,9,9,8})));
		System.out.println(Arrays.toString(addOne(new int[]{0,9,9,8})));
		
		System.out.println(Arrays.toString(plusOne(new int[]{9,9})));
	}

}
