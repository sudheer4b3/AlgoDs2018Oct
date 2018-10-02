package com.mine.others;

import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpression {
	
	public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        int len = tokens.length;
 
        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] == ' ')
                continue;
 
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                i--;
                values.push(Integer.parseInt(sbuf.toString()));
            }
 
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
 
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/')
            {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
                ops.push(tokens[i]);
            }
        }
 
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
        return values.pop();
    }
 
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
 
    public static void main(String[] args)
    {
        //System.out.println(EvaluateExpression.evaluate("10 + 2 * 6"));
        //System.out.println(EvaluateExpression.evaluate("100 * ( 2 + 12 ) / 14"));
        //System.out.println(EvaluateExpression.evaluate("1 + 11 - (12 - 15 * 10)"));
        //System.out.println(EvaluateExpression.evaluate("1 / 13 / 13 - 7 + 11 + 10 / (9 + 6 * 7 * 14 - (7) + (14 - (3 + 18 / 9 / 4)))"));
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the number of expressions you want to input:");
        int i = 0;
        int tcNum = 0;
        String expr[] = new String[0];
        while(sc.hasNextLine()) {
        	i++;
        	String line = sc.nextLine();
        	if(i==1) {
        		try {
        			tcNum = Integer.parseInt(line);
        			expr = new String[tcNum];
				} catch (NumberFormatException e) {
					System.out.println("provided input is not a number");
					return;
				}
        		
        	}
        	if(i>1)
        		expr[i-2] = line;
        	if(i != tcNum+1) {
        		continue;
        	} else
        		break;
        	//System.out.println(sc.nextLine());
        }
        if(i != tcNum+1) {
        	System.out.println("input not provided correctly");
        	return;
        } else {
        	for(int j = 0; j<expr.length; j++){
        		System.out.println(EvaluateExpression.evaluate(expr[j]));
        	}
        }
        
    }

}
