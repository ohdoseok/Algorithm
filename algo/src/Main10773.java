import java.util.Scanner;
import java.util.Stack;

public class Main10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < N; i++) {
			int V = sc.nextInt();
			if (V==0) {
				result-=s.pop();
			}else {
				s.add(V);
				result+=V;
			}
		}
		System.out.println(result);
	}
}
