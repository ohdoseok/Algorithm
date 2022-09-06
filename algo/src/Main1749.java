import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1749 {
	public static int[][] matrix;
	public static int row;
	public static int col;
	public static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		res = Integer.MIN_VALUE;
		matrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < col; i++) {
			anz(i);
		}
		System.out.println(res);
		
	}
	public static void anz(int num) {
		int go = (col-num)*row;
		int sum  = 0;
		for (int i = 1; i < go+1; i++) {
			for (int j = 1; j < go+1; j++) {
				if (i%j == 0) {
					int mok = i/j;
					//j*mok
					if (j+0>row || mok+num>col) {
						continue;
					}
					for (int k = 0; k < j; k++) {
						for (int k2 = 0; k2 < mok; k2++) {
							sum += matrix[0+k][num+k2];
						}
					}
					if (res<sum) {
						res = sum;
					}
					sum = 0;
				}
				
			}
		}
		
	}
}
