import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10026 {
	static int[] dx = {0,0,-1,1}; 
    static int[] dy = {-1,1,0,0};
	static char[][]map;
	static int N;
	static boolean[][]check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		check = new boolean[N][N];
		int res = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j]) {
					continue;
				}
				nonCB(i,j);
				res++;
			}
		}
		System.out.print(res+" ");
		res = 0;
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j]) {
					continue;
				}
				CB(i,j);
				res++;
			}
		}
		System.out.print(res);
		
	}
	static void nonCB(int x, int y) {
		check[x][y] = true;
		for (int i = 0; i <4; i++) {
			int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx<0 || nx >=N || ny < 0 || ny >=N) {
                continue;
            }
            if (check[nx][ny]) {
				continue;
			}
            if (map[nx][ny]!=map[x][y]) {
				continue;
			}
            nonCB(nx,ny);
		}
	}
	static void CB(int x, int y) {
		if (map[x][y]!='R'&&map[x][y]!='G') {
			check[x][y] = true;
			for (int i = 0; i <4; i++) {
				int nx = x + dx[i];
	            int ny = y + dy[i];
	            
	            if(nx<0 || nx >=N || ny < 0 || ny >=N) {
	                continue;
	            }
	            if (check[nx][ny]) {
					continue;
				}
	            if (map[nx][ny]!=map[x][y]) {
					continue;
				}
	            CB(nx,ny);
			}
		}else if(map[x][y]=='R'||map[x][y]=='G'){
			check[x][y] = true;
			for (int i = 0; i <4; i++) {
				int nx = x + dx[i];
	            int ny = y + dy[i];
	            
	            if(nx<0 || nx >=N || ny < 0 || ny >=N) {
	                continue;
	            }
	            if (check[nx][ny]) {
					continue;
				}
	            if (map[nx][ny]=='R'||map[nx][ny]=='G') {
	            	CB(nx,ny);
				}
	            
			}
		}
		
	}
}
