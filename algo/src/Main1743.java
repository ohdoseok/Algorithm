import java.util.*;
public class Main1743 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		int[][] map = new int[N][M];
		for(int i = 0 ; i < T ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x-1][y-1] = 1;
		}
		int[] mx = {-1,0,1,0};
		int[] my = {0,1,0,-1};
		Queue<int[]> q = new LinkedList<>();
		boolean[][] check = new boolean[N][M];
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j]==1) {
					int cnt = 0;
					q.offer(new int[] {i,j});
					check[i][j] = true;
					while(!q.isEmpty()) {
						int[] A = q.poll();
						cnt++;
						int Ax = A[0];
						int Ay = A[1];
						for(int k = 0 ; k < 4 ; k++) {
							if(Ax+mx[k]<0 || Ax+mx[k] >=N || Ay+my[k] <0 || Ay+my[k]>=M || check[Ax+mx[k]][ Ay+my[k]]) {
								continue;
							}
							if(map[Ax+mx[k]][ Ay+my[k]]==1) {
								q.offer( new int[] {Ax+mx[k],Ay+my[k]});
								check[Ax+mx[k]][ Ay+my[k]] = true;
							}
						}
					}
					if(max < cnt) {
						max = cnt;
					}
				}
			}
		}
		System.out.println(max);
	}
}
