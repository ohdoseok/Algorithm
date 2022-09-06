import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1749 {
	public static int[][] matrix;
	public static int[][] maxmatrix;
	public static int[][] diffmatrix;
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
		maxmatrix = new int[row][col];
		diffmatrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (res < matrix[i][j]) {
					res = matrix[i][j];
				}
				if (j==0) {
					maxmatrix[i][j] = matrix[i][j];
					diffmatrix[i][j] = matrix[i][j];
				}else {
					maxmatrix[i][j] = maxmatrix[i][j-1] + matrix[i][j];
					diffmatrix[i][j] = maxmatrix[i][j-1] + matrix[i][j];
					if (res < maxmatrix[i][j]) {
						res = maxmatrix[i][j];
					}
				}
			}
		}

		int sum = 0;

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				maxmatrix[i][j] = maxmatrix[i][j]+maxmatrix[i-1][j];//누적합 배열완성 

			}
		}





		System.out.println(res);

	}

}
