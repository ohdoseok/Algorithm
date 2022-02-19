import java.util.Scanner;

public class BOJ1592 {
	static int[] arr;
	static int N;
	static int M;
	static int L;
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//사람수
		arr = new int[N];
		M = sc.nextInt();
		L = sc.nextInt();
		throwball(0);
		System.out.println(res);
	}
	static void throwball(int start) {
		arr[start]++;
		if (arr[start]==M) {
			return;
		}
		if (arr[start]%2==0) {//반시계
			if (start-L<0) {
				res++;
				throwball(N+start-L);
			}else {
				res++;
				throwball(start-L);
			}
		}else {//시계
			res++;
			throwball((start+L)%N);
		}
	}
}
