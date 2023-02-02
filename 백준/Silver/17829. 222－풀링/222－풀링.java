import java.io.*;
import java.util.*;
public class Main {
	public static int res = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0 ; i < N ;i++) {
			String[] array = br.readLine().split(" ");
			for(int j = 0 ; j < array.length ; j++) {
				map[i][j] = Integer.parseInt(array[j]);
			}
		}
		int[] dx = {0,0,1,1};
		int[] dy = {0,1,1,0};
		while(N != 1) {
			int[][] resMap = new int[N/2][N/2];
			
			for(int i = 0 ; i < map.length ; i+=2) {
				for(int j = 0 ; j < map.length ; j+=2) {
					int first = Integer.MIN_VALUE;
					int sec = Integer.MIN_VALUE;
					for(int k = 0 ; k < 4 ; k++) {
						if(first <= map[i+dx[k]][j+dy[k]]) {
							sec = first;
							first = map[i+dx[k]][j+dy[k]];
						}else {
							if(sec <= map[i+dx[k]][j+dy[k]]) {
								sec = map[i+dx[k]][j+dy[k]];
							}
						}
					}
					resMap[i/2][j/2] = sec;
				}
			}
			map = new int[N/2][N/2];
			for(int i = 0 ; i < resMap.length ; i++) {
				for(int j = 0 ; j < resMap.length ; j++) {
					map[i][j] = resMap[i][j];
				}
			}
			N/=2;
		}
		System.out.println(map[0][0]);
	}
}
