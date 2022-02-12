package PerComSubset;
//순열은 n개중에서 r개를 선택한다. r개중 첫번째도 n개중에서 선택 r개중 2번째도 n개중에서 선택 하지만 첫번째 선택한 n을 제외하고 선택해야한다.
//다음 예제는 순서를 제대로 지정해서 배열에 넣어주지 않아서 1 2 다음 1 3 다음 2 1이 나와야 하지만 순서의 오류로 1 2로 출력된다 다음과 같은 코드를 수정하기 위해서는 반복문중에 먼저 나온 값을 r의 배열에 입력해 줘야한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PerComSubset1 {//순열
	static int N;
	static int M;
	static int[] arrN;
	static int[] arrM;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//N개중에
		M = sc.nextInt();//M개
		arrN = new int [N];
		arrM = new int [M];
		check = new boolean[N];
		for (int i = 0; i < N; i++) {
			arrN[i] = sc.nextInt();
		}
		
//		go(0);
		go2(0);
		
		
	}
	static void go(int cnt) {//중복조합
		if (cnt==M) {
			System.out.println(Arrays.toString(arrM));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check[i]) {
				continue;
			}
			arrM[cnt] = arrN[i];
			check[i] = true;
			go(cnt+1);
			check[i] = false;
			
		}
		
	}
	static void go2(int cnt) {//중복순열
		if (cnt==M) {
			System.out.println(Arrays.toString(arrM));
			return;
		}
		for (int i = 0; i < N; i++) {
			arrM[cnt] = arrN[i];
			go(cnt+1);
		}
		
	}
}
