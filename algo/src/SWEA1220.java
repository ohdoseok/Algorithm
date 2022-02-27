import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1220 {
	public static void main(String[] args) throws NumberFormatException, IOException {//1은아래로 2는 위로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i < 11; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			StringTokenizer st = null;
			boolean check = false;
			int res = 0;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[k][j]==1) {
						check = true;
					}else if(map[k][j]==2) {
						if (check) {
							res++;
							check = false;
						}
					}
				}
				check = false;
			}
			System.out.printf("#%d %d%n",i,res);
			
		}
	}
}
