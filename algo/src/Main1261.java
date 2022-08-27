import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1261 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visit;
	static int rst = 0;
	static PriorityQueue<Test> pq;
	static int[] mvx  = {-1,0,1,0};
	static int[] mvy  = {0,1,0,-1};
	static class Test implements Comparable<Test>{
		private int x;
		private int y;
		private int cnt;
		public Test(int x, int y, int cnt)  {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Test o) {
			// TODO Auto-generated method stub
			return this.cnt-o.cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			char[] carr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = carr[j]-'0';
			}
		}
		pq.offer(new Test(0, 0, 0));
		visit[0][0]=true;
		bfs(pq);
		System.out.println(rst);
		
	}
	
	static void bfs(PriorityQueue<Test> pq) {
		while(!pq.isEmpty()) {
			Test test = pq.poll();
			int x = test.x;
			int y = test.y;
			int cnt = test.cnt;
			if (x==N-1&&y==M-1) {
				rst = cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				
				if (x+mvx[i]<0||x+mvx[i]>=N||y+mvy[i]<0||y+mvy[i]>=M) {
					continue;
				}
				if (visit[x+mvx[i]][y+mvy[i]]) {
					continue;
				}
				if (map[x+mvx[i]][y+mvy[i]]==0) {
					pq.offer(new Test(x+mvx[i], y+mvy[i], cnt));
					visit[x+mvx[i]][y+mvy[i]] = true;
				}else {
					pq.offer(new Test(x+mvx[i], y+mvy[i], cnt+1));
					visit[x+mvx[i]][y+mvy[i]] = true;
				}
			}
		}
		
		
		
		
	}
	
}
