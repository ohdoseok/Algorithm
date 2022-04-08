import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main14502 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] mapcp;
	static int[] X = {-1,0,1,0};
	static int[] Y = {0,1,0,-1};
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		res = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		per(0,map);
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		
		System.out.println(res);

	}
	static void per(int cnt, int[][] input) {
		
		if (cnt==3) {
			
			mapcp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					mapcp[i][j] = input[i][j];
				}
			}
			int count = 0;
			mapcnt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mapcp[i][j]==0) {
						count++;
					}
				}
			}
			if (res < count) {
				res = count;
				
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { 
				if (input[i][j]==0) {
					input[i][j] = 1;
					per(cnt+1,input);
					input[i][j] = 0;
				}
				
			}
		}



	}

	static void mapcnt() {

		while(true) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mapcp[i][j]==2) {
						for (int k = 0; k < 4; k++) {
							if(i+X[k]<0||i+X[k]>=N||j+Y[k]<0||j+Y[k]>=M) {
								continue;
							}
							if (mapcp[i+X[k]][j+Y[k]]==0) {
								mapcp[i+X[k]][j+Y[k]] = 2;
								cnt++;
							}

						}
					}
					
				}
			}
			if (cnt==0) {
				break;
			}
		}
		
		
	}


}
