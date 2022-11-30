import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2116 {
	public static int[][] map;
	public static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][6];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<6 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int j = 1 ; j <= 6 ; j++) {
			dfs(0,j,0);
		}
		System.out.println(max);
	}
	public static void dfs(int nowIdx, int idx ,int res) {
		if(nowIdx == map.length) {
			if(max < res) {
				max = res;
			}
			return;
		}
		int[] check = {5,3,4};
		for(int i = 0 ; i < 3 ; i++) {
			int index1 = map[nowIdx][i];
			int index2 = map[nowIdx][check[i]];
			if(idx == index1) {
				for(int j = 6 ; j >0 ; j--) {
					if(index1==j || index2==j) {
						continue;
					}else {
						dfs(nowIdx+1,index2,res+j);
						break;
					}
				}
			}else if(idx == index2) {
				for(int j = 6 ; j >0 ; j--) {
					if(index1==j || index2==j) {
						continue;
					}else {
						dfs(nowIdx+1,index1,res+j);
						break;
					}
				}
			}
		}
	}
}
