package MST;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
 * 
 * 
 */


public class MST_PrimeTest_Copy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][]map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		boolean[] visit = new boolean[N];
		int[] minarr = new int[N];
		Arrays.fill(minarr, Integer.MAX_VALUE);
		minarr[0] = 0;
		
		int res = 0;
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int cur = 0;
			for (int j = 0; j < N; j++) {
				if (visit[j]) {
					continue;
				}
				if (min>minarr[j]) {
					min=minarr[j];
					cur = j;
				}
			}
			visit[cur] = true;
			res += min;
			
			for (int j = 0; j < N; j++) {
				if (visit[j]) {
					continue;
				}
				if (map[cur][j]==0) {
					continue;
				}
				if (minarr[j]>map[cur][j]) {
					minarr[j]=map[cur][j];
				}
			}
			
			
		}
		System.out.println(res);
	}

}
