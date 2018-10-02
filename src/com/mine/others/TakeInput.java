package com.mine.others;

import java.util.Scanner;

public class TakeInput {
	public static void main(String[] args) {
		char abc[][] = new char[1][2];
		abc[0][0] = 'x';
		abc[0][1] = 'o';
		
		char currChar = 'x';
		
		if(currChar == abc[0][0]) {
			System.out.println("equals");
		} else {
			System.out.println("not equals");
		}
		
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the number of expressions you want to input:");
        int i = 0;
        int tcNum = 0;
        while(sc.hasNextLine()) {
        	i++;
        	String line = sc.nextLine();
        	if(i==1) {
        		tcNum = Integer.parseInt(line);
        	}
        	if(i != tcNum+1) {
        		
        		continue;
        	} else
        		break;
        	//System.out.println(sc.nextLine());
        }
        if(i != tcNum+1) {
        	System.out.println("input not provided correctly");
        	return;
        }
        System.out.println("input is correct");
    }

}
