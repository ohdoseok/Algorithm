import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] arr = new boolean[N+1];
		int T = sc.nextInt();
		int countidx = 1;
		int exmax = 0;
		int exmaxidx = 0;
		int realmax = 0;
		int realmaxidx = 0;
		for (int i = 0; i < T; i++) {
			int cnt = 0;
			int from = sc.nextInt();
			int to = sc.nextInt();
			if (to-from>exmax) {
				exmax = to-from;
				exmaxidx = countidx;
			}
			for (int j = from; j < to+1; j++) {
				if (!arr[j]) {
					cnt++;
					arr[j] = true;
				}
			}
			if (cnt>realmax) {
				realmax = cnt;
				realmaxidx = countidx;
			}
			countidx++;
		}
		System.out.println(exmaxidx);
		System.out.println(realmaxidx);
	}
}
