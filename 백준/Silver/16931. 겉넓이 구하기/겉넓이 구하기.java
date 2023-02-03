import java.io.*;
import java.util.*;
public class Main {
	public static int res = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = N*M*2;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				int val = map[i][j];
				for(int k = 0 ; k < 4 ; k++) {
					if(i+dx[k] < 0 || i+dx[k]>=N || j+dy[k]<0 || j+dy[k]>=M) {
						cnt+=val;
						continue;
					}
					if(map[i+dx[k]][j+dy[k]]<val) {
						cnt+=val-map[i+dx[k]][j+dy[k]];
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
