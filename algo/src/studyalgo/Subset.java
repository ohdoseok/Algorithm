package studyalgo;

import java.util.Scanner;

public class Subset {
	static int N;
	static int[] input;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		sub(0);
	}
	static void sub(int cnt) {
		if (cnt==N) {
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					System.out.print(input[i]+" ");
				}else {
					System.out.print('x'+" ");
				}
			}
			System.out.println();
			return;
		}
		//true
		visit[cnt] = true;
		sub(cnt+1);
		
		//false
		visit[cnt] = false;
		sub(cnt+1);
		
		
	}
}
