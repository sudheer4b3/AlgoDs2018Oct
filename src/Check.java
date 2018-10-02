import java.util.Scanner;
import java.util.Stack;

public class Check {
	private int c;
	
	static public void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		Stack<Character> stack = new Stack<>();
		System.out.println(input);
		
		int len = input.length();
		
		for(int i =0 ; i< len; i++) {
			switch(input.charAt(i)) {
				case '{':
					stack.push(input.charAt(i));
					break;
				case '[':
					stack.push(input.charAt(i));
					break;
				case '&':
					if(stack.peek() == '&')
						stack.pop();
					else
						stack.push(input.charAt(i));
					break;
				case '!':
					if(stack.peek() == '!')
						stack.pop();
					else
						stack.push(input.charAt(i));
					break;
				case '}':
					if(stack.peek()=='{')
						stack.pop();
					break;
				case ']':
					if(stack.peek()=='{')
						stack.pop();
					break;
			}
		}
		
		if(stack.isEmpty())
			System.out.println();
		
	}
}
