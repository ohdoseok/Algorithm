import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1158 {
	public static void main(String[] args) {
		int res;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int M = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < N+1; i++) {
			q.offer(i);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M-1; j++) {
				int add = q.poll();
				q.offer(add);
			}
			res = q.poll();
			sb.append(Integer.toString(res));
			sb.append(", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
}
