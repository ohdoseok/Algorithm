import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
//다시
public class Main2567 {
	static int res = 0;
	static int[] dx = {-1,1,0,0,-1,-1,1,1};//상,하,좌,우 순서
	static int[] dy = {0,0,-1,1,-1,1,1,-1};
	static int[][] map = new int[102][102];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			go(y,x);
		}
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				search(i,j);
			}
		}
		System.out.println(res);
		
	}
	static void go(int x, int y) {
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				map[x+i][y+j] = 1; 
			}
		}
	}
	static void search(int x, int y) {
		if (map[x][y]!=1) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (x+dx[i]<0||x+dx[i]>=102||y+dy[i]<0||y+dy[i]>=102) {
				continue;
			}
			if (map[x+dx[i]][y+dy[i]]==0) {
				res++;
			}
		}
	}
}
