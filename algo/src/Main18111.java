import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class Main18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				
				int val = Integer.parseInt(st.nextToken());
				if(val > max) {
					max = val;
				}
				if(val < min) {
					min = val;
				}
				map[i][j] = val;
			}
			
		}
		int minres = Integer.MAX_VALUE;
		int index = -1;
		for(int i = min ; i <= max ; i++) {
			int Bcopy = B;
			int res = 0;
			Loop1:
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < M ; k++) {
					if(map[j][k] == i) {
						continue;
					}
					if(minres < res) {
						Bcopy = -1;
						break Loop1;
					}
					if(map[j][k]>i) {
						Bcopy+=(map[j][k]-i);
						res+=2*(map[j][k]-i);
					}else{
						Bcopy-=(i-map[j][k]);
						res+=(i-map[j][k]);
					}
				}
			}
			if(Bcopy>=0 && minres >= res) {
				minres = res;
				index = i;
			}
		}
		System.out.println(minres+" "+index);
	}
}