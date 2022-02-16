import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4012 {
	static int N;
	static int R;
	static int[][]map;
	static int res;
	static boolean[] arrN;
	static int orig;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i < T+1; i++) {
			N = Integer.parseInt(br.readLine());
			arrN = new boolean[N];
			R = N/2;
			orig = 0;
			res = 0;
			map = new int[N][N];
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			go(0,0);
			System.out.printf("#%d %d%n",i,res);
		}

	}

	static void go(int cnt, int start) {
		if(cnt==R) {
			check();//조합으로 N개중에 N/2개를 고른다
			return;
		}
		for(int i = start; i < N; i++) {
			arrN[i] = true;
			go(cnt+1,i+1);
			arrN[i] = false;
		}
	}

	static void check() {//고른 각각의 N/2개중에서 2개를 뽑는 모든경우를 다 합해준다.
		int sumA=0,sumB=0;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (arrN[i]&&arrN[j]) {
					sumA += map[i][j] + map[j][i];//True중에서 2개를 뽑아서 합에 더해줌
				}else if(!arrN[i]&&!arrN[j]) {
					sumB += map[i][j] + map[j][i];//false중에서 2개를 뽑아서 합에 더해줌
				}
			}
		}
		int diff = Math.abs(sumA-sumB);
		if (orig==0) {//처음에는 결과값에 기준이 되기위한 초기값
			res = diff;
			orig++;
		}else {
			res = Math.min(res, diff);//비교하면서 차이가 적은 값을 리턴
		}

	}
}
