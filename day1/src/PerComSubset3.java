//부분집합
import java.util.Scanner;

public class PerComSubset3 {
		static int N;
		static boolean[] bo;
		static int[] arrN;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//N개 받는다
		arrN = new int[N];
		bo = new boolean[N];
		for (int i = 0; i < N; i++) {
			arrN[i] = sc.nextInt();//N개의 숫자를 각각 입력받고 배열에 추가
		}
		go(0);
	}
	static void go(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				if (bo[i]) {
					System.out.printf("%d ",arrN[i]);
				}
			}
			System.out.println();
			return;
		}
		
		bo[cnt]=true;
		go(cnt+1);
		bo[cnt]=false;
		go(cnt+1);
	}
}
