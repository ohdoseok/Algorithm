//부분집합
import java.util.Scanner;

public class PerComSubset3 {
	static int N;
	static int[] arrN;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arrN = new int[N];
		check = new boolean[N];
		for (int i = 0; i < N; i++) {
			arrN[i] = sc.nextInt();
		}
		go(0);
	}
	static void go(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < check.length; i++) {
				if (check[i]) {
					System.out.printf("%d ",arrN[i]);
				}else {
					System.out.printf("X ");
				}
			}
			System.out.println();
			return;
		}
		
		check[cnt] = true;
		go(cnt+1);
		check[cnt] = false;
		go(cnt+1);


	}
}
