import java.util.Scanner;

public class Main2810 {
	static int N;
	static int SUM;
	static int res = 0;
	static int[] arr;
	static int[] check = new int[3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		SUM = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		com(0,0);
		System.out.println(res);
	}
	
	static void com(int cnt, int start) {
		if (cnt==3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum+=check[i];
			}
			if (sum>res&&sum<=SUM) {
				res = sum;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			check[cnt] =  arr[i];
			com(cnt+1,i+1);
		}
	}
}
