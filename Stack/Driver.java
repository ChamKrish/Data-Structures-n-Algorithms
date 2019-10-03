import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
//		postfix p = new postfix();
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine();
//		sc.close();
//		String str = p.infixtopost(s);
//		System.out.println(str);
//		System.out.println(p.postfixeval(str));
		
		Stack s = new Stack();
		System.out.println(s.isEmpty());
		s.pop();
		s.print();
		s.push(4);
		s.push(1);
		s.push(5);
		s.push(29);
		
		
		System.out.println(s.peek());
		s.print();
		
	}
}
