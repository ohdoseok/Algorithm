package studyalgo;

import java.util.Scanner;

public class Combination {
	static int N;
	static int M;
	static int[] input;
	static int[] rst;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		rst = new int[M];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		com(0,0);
	}
	
	static void com(int cnt, int start) {
		if (cnt==M) {
			StringBuilder sb = new StringBuilder();
			for(int i : rst) {
				sb.append(i+" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb);
			return;
		}
		for (int i = start; i < N; i++) {
			if (visit[i]) {
				continue;
			}
			rst[cnt] = input[i];
			visit[i] = true;
			com(cnt+1,i+1);
			visit[i] = false;
		}
	}
	
}
