import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4963 {
	static int[][] map;
	static int w;
	static int h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w==0&&h==0) {
				break;
			}
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j]==1) {
						search(i,j);//탐색끝나면 한덩어리 만들어짐 (모두 0처리)
						res++;
					}
				}
			}
			System.out.println(res);
		}
	}
	static void search(int x, int y) {//8방위 탐색
		map[x][y] = 0;
		if (x-1>=0&&y-1>=0) {
			if (map[x-1][y-1]==1) {
				search(x-1,y-1);
			}
		}
		if (x-1>=0) {
			if (map[x-1][y]==1) {
				search(x-1,y);
			}
		}
		if(x-1>=0&&y+1<w) {
			if (map[x-1][y+1]==1) {
				search(x-1,y+1);
			}
		}
		if (y+1<w) {//우
			if (map[x][y+1]==1) {
				search(x,y+1);
			}
		}
		if (x+1<h&&y+1<w) {
			if (map[x+1][y+1]==1) {
				search(x+1,y+1);
			}
		}
		if (x+1<h) {
			if (map[x+1][y]==1) {
				search(x+1,y);
			}
		}
		if(x+1<h&&y-1>=0) {
			if (map[x+1][y-1]==1) {
				search(x+1,y-1);
			}
		}
		if (y-1>=0) {
			if (map[x][y-1]==1) {
				search(x,y-1);
			}
		}
	}
}
