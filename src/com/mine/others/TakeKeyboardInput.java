package com.mine.others;

import java.util.Scanner;

public class TakeKeyboardInput {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter a String");
		String str = keyboard.next();
		System.out.println(str);
		System.out.println("enter an integer");
		int myint = keyboard.nextInt();
		System.out.println(myint);
	}

}
