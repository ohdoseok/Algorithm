import java.util.Iterator;
import java.util.Scanner;

public class Main18429 {
	public static int[] kit;
	public static boolean[] check;
	public static int res;
	public static int count;
	public static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		kit = new int[N];
		check = new boolean[N];
		res = 500;
		count = 0;
		for (int i = 0; i < N; i++) {
			kit[i] = sc.nextInt();
		}
		dfs(0);
		System.out.println(count);
		
		
	}
	public static void dfs(int num) {
		if (num==kit.length) {
			count++;
			return;
		}
		
		
		for (int i = 0; i < check.length; i++) {
			if (check[i]) {
				continue;
			}
			res = res-K+kit[i];
			
			if (res<500) {
				res = res+K-kit[i];
				continue;
			}else {
				check[i] = true;
				dfs(num+1);
				check[i] = false;
				res = res+K-kit[i];
			}
		}
	}
}
