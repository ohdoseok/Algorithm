import java.util.*;

public class Main2178 {
	public static void main(String[] args) {
		//bfs level로 최단거리탐색 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			char[] A = sc.next().toCharArray();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = A[j]-'0';
			}
		}
		int[] x = {-1,0,1,0};
		int[] y = {0,1,0,-1};
		int res = 0;
		boolean[][] check = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		check[0][0] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			res++;
			for(int k = 0 ; k < size ; k++) {
				int[] matrix = q.poll();
				int mX = matrix[0];
				int mY = matrix[1];
				if(mX==N-1 && mY==M-1) {
					q.clear();
					break;
				}
				for(int i = 0 ; i < 4 ; i++) {
					if(mX+x[i]<0 || mX+x[i] >= N || mY+y[i]<0 || mY+y[i]>=M || check[mX+x[i]][mY+y[i]]) {
						continue;
					}
					if(map[mX+x[i]][mY+y[i]]==1) {
						q.offer(new int[] {mX+x[i],mY+y[i]});
						check[mX+x[i]][mY+y[i]] = true;
					}
					
				}
			}
			
		}
		System.out.println(res);
	}
}
