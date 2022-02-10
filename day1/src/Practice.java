import java.util.Arrays;
import java.util.Scanner;

//급하게 코드 테스트나 간단하게 구현해보고 지우는 class
public class Practice {//현재 조합 연습
	static int N;
	static int M;
	static int[] arrN, arrM;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arrN = new int[N];
		M = sc.nextInt();
		arrM = new int[M];
		for (int i = 0; i < N; i++) {
			arrN[i] = sc.nextInt();
		}
		go(0,0);
	}
	
	static void go(int cnt, int start) {
		if (cnt == M) {
			System.out.println(Arrays.toString(arrM));
			return;
		}
		
		for (int i = start; i < N; i++) {
			arrM[cnt] = arrN[i];
			go(cnt+1,i+1);
		}
	}
}
