import java.util.Scanner;

public class BOJ2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int mok = N/5;
		go(N,mok);
		
	}
	static void go(int N, int mok) {
		int nam = (N-(mok*5))%3;
		if (nam==0) {
			System.out.println(mok+((N-(mok*5))/3));
			return;
		}
		if (mok==0) {
			System.out.println(-1);
			return;
		}
		go(N,mok-1);
	}
}
