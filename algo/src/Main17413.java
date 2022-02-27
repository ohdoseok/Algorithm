import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		char[] arr = br.readLine().toCharArray();
		boolean check = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]=='<') {
				check = true;
			}
			if (arr[i]=='>') {
				check=false;
			}
			if (check) {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(arr[i]);
			}else {
				if (arr[i]=='>') {
					System.out.print(arr[i]);
				}else {
					if (arr[i]==' ') {
						while(!stack.isEmpty()) {
							System.out.print(stack.pop());
						}
						System.out.print(' ');
					}else {
						stack.push(arr[i]);
					}
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
