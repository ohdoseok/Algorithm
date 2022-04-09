import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889 {//시간초과
	static int N;
	static int half;
	static int[][] map;
	static int[] arr;
	static int[] arrtwo;
	static boolean[] visit;
	static boolean[] visittwo;
	static int res;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		half = N/2;
		visittwo = new boolean[half];
		arr = new int[N/2];
		arrtwo = new int[2];
		map = new int[N][N];
		res = Integer.MAX_VALUE;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		per(0);
		System.out.println(res);
	}
	static void per(int cnt) {
		if (cnt == half) {
			int A = 0;
			int B = 0;
			int j = 0;
			int[] Barr = new int[half];
			for (int i = 1; i < N+1; i++) {
				if (!visit[i]) {
					Barr[j] = i;
					j++;
				}
			}
			
			sum = 0;
			pertwo(0,arr);
			A = sum;
			sum = 0;
			pertwo(0,Barr);
			B = sum;
			if (res>Math.abs(A-B)) {
				res = Math.abs(A-B);
			}
			return;
			
		}
		for (int i = 1; i < N+1; i++) {
			if (visit[i]) {
				continue;
			}
			arr[cnt] = i;
			visit[i] = true;
			per(cnt+1);
			visit[i] = false;
		}
		
		
		
	}
	static void pertwo(int cnt,int[] arr) {
		if (cnt==2) {
			sum+=map[arrtwo[0]-1][arrtwo[1]-1];
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (visittwo[i]) {
				continue;
			}
			arrtwo[cnt] = arr[i];
			visittwo[i] = true;
			pertwo(cnt+1,arr);
			visittwo[i] = false;
		}
		
	}
	
	
}
