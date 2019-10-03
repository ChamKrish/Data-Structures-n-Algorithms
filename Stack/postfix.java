import java.util.Stack;
public class postfix {
	String infixtopost(String st) {
		Stack<Character> s = new Stack<Character>();
		StringBuilder result = new StringBuilder();
//		result.append("\"");
		for(int i=0;i<st.length();i++) {
			char c = st.charAt(i);
			switch(c) {
//	if we encounter a operator in peek of stack with equal or greater precedence than operator in case - append by poping and push
//			else push
			case '+':
				if(s.size() == 0 || (s.peek() == '(' && s.empty() == false)) s.push(c);
				else if(s.peek() == '*' || s.peek() == '/' || s.peek() == '+') {
					result.append(s.pop());
					s.push(c);
				}
				else {
					s.push(c);
				}
				break;
			case '-':
				if(s.size() == 0 || (s.peek() == '(' && s.empty() == false)) s.push(c);
				else {
					result.append(s.pop());
					s.push(c);
				}
				break;
			case '*':
				if(s.size() == 0 || (s.peek() == '(' && s.empty() == false)) s.push(c);
				else if(s.peek() == '/') {
					result.append(s.pop());
					s.push(c);
				}
				else s.push(c);
				break;
			case '/':
				s.push(c);
				break;
			case '(':
				s.push(c);
				break;
			case ')':
				while(s.peek() != '(') {
					result.append(s.pop());
				}
				s.pop();
				break;
			default:
				if(c != ' ' && c != '"') result.append(c);
				break;
			}
		}
		while(s.size() != 0) {
			result.append(s.pop());
		}
//		result.append("\"");
		String S = result.toString();
		return S;
	}
	
	
	int postfixeval(String s) {
		Stack<Integer>stack = new Stack<Integer>();
		for(int i=0;i<s.length();i++) {
			int t1,t2;
			switch(s.charAt(i)) {
			case '+':
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1 + t2);
				break;
			case '-':
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1 - t2);
				break;
			case '*':
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1 * t2);
				break;
			case '/':
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1/t2);
				break;
			default:
				int x = Character.getNumericValue(s.charAt(i));
				stack.push(x);
			}
		}
		int k = stack.pop();
		return k;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}