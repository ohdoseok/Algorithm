package day2;

import java.util.Arrays;
import java.util.Scanner;

//순열을 미트마스킹으로  비트마스킹후에 int값이 나오기 때문에 0이 아니라면 continue
public class BitMaskingTest {
	static int R;
	static int[] arrN;
	static int[] arrR;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		arrN = new int[N];
		arrR = new int[R];
		for (int i = 0; i < N; i++) {
			arrN[i] = sc.nextInt();
		}
		permutation(0, 0);
	}
	static void permutation(int cnt, int flag) {
		if (cnt==R) {
			System.out.println(Arrays.toString(arrR));
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag&1<<i) != 0) {
				continue;
			}
			arrR[cnt] = arrN[i];
			permutation(cnt+1, flag|1<<i);
		}
	}
	
}
