import java.util.Scanner;

public class Main15649 {
	static int M;
	static int N;
	static int[] input, numbers;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		numbers = new int[M];
		for (int i = 1; i < N+1; i++) {
			input[i-1]=i;
		}
		visit = new boolean[N];
		go(0);
		
	}
	
	static void go(int cnt) {
		if (cnt==M) {
			StringBuilder sb = new StringBuilder();
			for (int i: numbers) {
				sb.append(i+" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i]) {
				continue;
			}
			numbers[cnt] = input[i];
			visit[i] = true;
			go(cnt+1);
			visit[i] = false;
			
		}
		
	}
}
