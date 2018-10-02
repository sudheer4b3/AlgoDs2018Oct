import java.util.Scanner;
import java.util.Stack;
class EvaluateExpression {
	public static int evaluate(String expression){
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        int len = tokens.length;
        for (int i = 0; i < len; i++){
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9'){
                StringBuffer sbuf = new StringBuffer();
                while (i < len && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                i--;
                values.push(Integer.parseInt(sbuf.toString()));
            }
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
            else if (tokens[i] == ')'){
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/'){
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
        }
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2){
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    public static int applyOp(char op, int b, int a){
        switch (op){
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i = 0, tcNum = 0;;
        String expr[] = new String[0];
        while(sc.hasNextLine()){
        	i++;
        	String line = sc.nextLine();
        	if(i==1) {
    			tcNum = Integer.parseInt(line);
    			expr = new String[tcNum];
        	}
        	if(i>1)
        		expr[i-2] = line;
        	if(i != tcNum+1)
        		continue;
        	else
        		break;
        }
        if(i != tcNum+1) {
        	System.out.println("input not correct");
        	return;
        } else {
        	for(int j = 0; j<expr.length; j++){
        		System.out.println(EvaluateExpression.evaluate(expr[j]));
        	}
        }
    }
}
