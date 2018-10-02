package com.mine.others;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionParanthesisCheck {
	static Scanner in = new Scanner(System.in);

	public static boolean check(String newExp) {
		//String[] exp = new String[newExp];
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < newExp.length(); i++) {
			//char ch = exp.charAt(i);
			char ch = newExp.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{')
				stack.push(ch);
			else{
				switch(ch) {
					case '}':
						if(stack.pop()!='{')
							return false;
						break;
					case ']':
						if(stack.pop()!='[')
							return false;
						break;
					case ')':
						if(stack.pop()!='(')
							return false;
						break;
					default:
						break;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter your expression.");
		String newExp = in.next();
		if(check(newExp))
			System.out.println("valid");
		else
			System.out.println("not valid");
	}

}
