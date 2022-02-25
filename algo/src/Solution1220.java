import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1220 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testcase = 1; testcase < 11; testcase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int [N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			boolean[] check = new boolean[2];
			//1은 아래로 2는 위로
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[j][i]==1) {
						check[0]=true;
					}else if(map[j][i]==2) {
						if (check[0]) {
							check[1]=true;
						}
					}
					if (check[0]&&check[1]) {
						res++;
						check[0]=false;
						check[1]=false;
					}
				}
				check[0]=false;
				check[1]=false;
			}
			System.out.printf("#%d %d%n",testcase,res);
			
		}
	}
}
