import java.util.*;
public class Main2504 {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		int tmp = 1;
		int result = 0;
		char prv = ' ';
		boolean check = false;

		for(int i = 0; i < N.length(); i++) {
			if(N.charAt(i) == '(' || N.charAt(i) == '[' ) {
				stack.push(N.charAt(i));
			}else {
				if(N.charAt(i)==')') {
					if(stack.isEmpty() || stack.pop()!='(') {
						check = true;
						break;
					}
					
				}else {
					if(stack.isEmpty() ||stack.pop()!='[') {
						check = true;
						break;
					}
				}
			}
			
		}
		if(check||!stack.isEmpty()) {
			System.out.println(0);
		}else {
			for(int i = 0 ; i < N.length(); i++) {
				char c = N.charAt(i);
				switch (c) {
				case '(':
					tmp*=2;
					break;
				case '[':
					tmp*=3;
					break;
				case ')':
					if(prv=='(') {
						result+=tmp;
					}
					tmp/=2;
					break;
				case ']':
					if(prv=='[') {
						result+=tmp;
					}
					tmp/=3;
					break;
				default:
					break;
				}
				prv = c;
			}
			System.out.println(result);
		}
		
		
		
	}
}
