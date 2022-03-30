package studyalgo;

import java.util.Scanner;

public class Permutation {
	static int N;
	static int M;
	static int[] input;
	static int[] result;
	static boolean[] visit;
	public static void main(String[] args) {
		//n개의 숫자를 받고 n개중에서 m개를 뽑는데 순열로
		Scanner sc = new  Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		result = new int[M];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		per(0);
	}
	static void per(int cnt) {
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			for (int i : result) {
				sb.append(i+" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i]) {
				continue;
			}
			result[cnt] = input[i];
			visit[i] = true;
			per(cnt+1);
			visit[i] = false;
		}
	}
}
