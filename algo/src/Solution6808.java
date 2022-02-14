import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6808 {
	static int[] arrA;
	static int[] arrB;//인영이
	static int sumW;
	static int sumL;
	static int cntwin;
	static int cntlose;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] result = new int[T+1][2];
		for (int i = 1; i < T+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arrA = new int[9];
			arrB = new int[9];
			check = new boolean[9];
			int start = 0;
			cntwin = 0;
			cntlose = 0;
			sumW = 0;
			sumL = 0;
			boolean[] arr = new boolean[19];
			for (int j = 0; j < 9; j++) {
				arrA[j] = Integer.parseInt(st.nextToken());
				arr[arrA[j]]=true;
			}
			for (int j = 1; j < arr.length; j++) {
				if (!arr[j]) {
					arrB[start]=j;
					start++;
				}
			}
			go(0,0);
			result[i][0] = cntwin;
			result[i][1] = cntlose;
		}
		for (int i = 1; i < result.length; i++) {
			System.out.printf("#%d %d %d%n",i,result[i][0],result[i][1]);
		}
	}
	static void go(int cnt, int current) {
		if (cnt==9) {
			if (sumW>85) {
				cntwin++;
			}else if(sumL>85) {
				cntlose++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (check[i]) {
				continue;
			}
			if(arrA[current]<arrB[i]) {//규영이가 지는경우
				check[i]=true;
				sumL += (arrA[current]+arrB[i]);//점수는 인영이가 모두 가져간다.
				go(cnt+1,current+1);
				sumL -= (arrA[current]+arrB[i]);
				check[i]=false;
			}else {//규영이가 이기는경우
				check[i]=true;
				sumW += (arrA[current]+arrB[i]);//점수는 규영이가 모두 가져간다.
				go(cnt+1,current+1);
				sumW -= (arrA[current]+arrB[i]);
				check[i]=false;
			}
		}
	}
}
