package PerComSubset;
//조합은 N개중 R개를 뽑는데 순서가 상관이 없기 때문에 1 2 3 이나 1 3 2 나 3 1 2 나 모두 같은 의미다. 그렇기 때문에 R개중 첫번째에서 뽑은 수 를 다음에서는 당연히 뽑을 수 없음과 동시에 앞에서 뽑은수 그 다음수를 뽑는게 조합이다.
//만약 i가 아니라 start를 넘겨주게 되면 고정된 자리수를 넘기기 때문에 중복되는 수가 생긴다. 넘겨주는수가 항상 이전의 수보다 커야 그다음수를 뽑을 수 있기 때문에 i를 넘겨줘야한다

import java.util.Arrays;
import java.util.Scanner;

public class PerComSubset2 {
		static int N;
		static int M;
		static int[] arrN;
		static int[] arrM;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			M = sc.nextInt();
			arrN = new int[N];
			arrM = new int[M];
			for (int i = 0; i < N; i++) {
				arrN[i] = sc.nextInt();
			}
			go(0,0);
			go2(0,0);
		}
		static void go(int cnt, int start) {
			if (cnt==M) {
				System.out.println(Arrays.toString(arrM));
				return;
			}
			for (int i = start; i < N; i++) {
				
				arrM[cnt] = arrN[i];
				go(cnt+1,i+1);
			}
			
		}
		static void go2(int cnt, int start) {//중복조합
			if (cnt == M) {
				System.out.println(Arrays.toString(arrM));
				return;
			}
			for (int i = start; i < N; i++) {
				arrM[cnt] = arrN[i];
				go2(cnt+1,i);
			}
		}
}
