import java.util.*;

public class Main1303 {
	public static void main(String[] args) {
		//bfs이용 완전탐색
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] x = {-1,0,1,0};
		int[] y = {0,1,0,-1};
		char[][] map = new char[M][N];
		boolean[][] check;
		for(int i = 0 ; i < M ; i++) {
			map[i] = sc.next().toCharArray();
		}
		int wres = 0;
		int bres = 0;
		check = new boolean[M][N];
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++) {
				int wcnt = 0;
				int bcnt = 0;
				if(check[i][j]) {
					continue;
				}
				q.offer(new int[]{i,j});
				check[i][j] = true;
				while(!q.isEmpty()) {
					int[] array = q.poll();
					int Ax = array[0];
					int Ay = array[1];
					if(map[Ax][Ay]=='W') {
						wcnt++;
					}else {
						bcnt++;
					}
					for(int k = 0 ; k < x.length ; k++) {
						if(Ax+x[k]<0 || Ax+x[k]>=M || Ay+y[k]<0 || Ay+y[k]>=N || check[Ax+x[k]][Ay+y[k]]) {
							continue;
						}
						if(map[Ax+x[k]][Ay+y[k]]==map[Ax][Ay]) {
							q.offer(new int[] {Ax+x[k] , Ay+y[k]});
							check[Ax+x[k]][Ay+y[k]] = true;
						}
					}
				}
				if(wcnt!=0) {
					wres+=wcnt*wcnt;
				}else if(bcnt!=0) {
					bres+=bcnt*bcnt;
				}
			}
		}
		System.out.println(wres+" "+bres);
	}
}
