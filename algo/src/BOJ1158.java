import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1158 {
	static int N;
	static int K;
	static StringBuilder sb = null;
	static ArrayList<Integer> list;
	static int cnt = 0;
	public static void main(String[] args) {
		sb = new StringBuilder();
		sb.append("<");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		list = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			list.add(i);
		}
		go(0);
		sb.setLength(sb.length()-1);
		sb.append(">");
		System.out.println(sb);
	}
	static void go(int n) {
		if (cnt==N) {
			return;
		}
		n = (n+K-1)%list.size();
		if (cnt == 0) {
			sb.append(list.get(n)+",");
		}else {
			sb.append(" "+list.get(n)+",");
		}
		list.remove(n);
		cnt++;
		go(n);
	}
}