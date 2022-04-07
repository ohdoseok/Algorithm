import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1953{
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	static int[][] map;
	static boolean[][] visit;
	static class link{
		private int R;
		private int C;
		private int V;

		link(int R, int C, int V){
			this.R = R;
			this.C = C;
			this.V = V;
		}
	}
	static int[] oneX = {-1,1,0,0};
	static int[] oneY = {0,0,1,-1};
	static Queue<link> q;
	static int res;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			res = 0;
			cnt = 0;
			StringTokenizer st = null;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			q = new LinkedList<link>();
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			q.offer(new link(R,C,map[R][C]));
			bfs();
			System.out.printf("#%d %d",testcase,res);
			System.out.println();
		}
	}


	static void bfs() {
		if (cnt==L) {
			return;
		}
		cnt++;
		int size = q.size();
		res += size;
		int rollcnt = 0;
		while(true) {
			if (rollcnt == size) {
				break;
			}
			link linknode = q.poll();
			int Row = linknode.R;
			int Col = linknode.C;
			switch (linknode.V) {
			case 1:
				for (int i = 0; i < 4; i++) {
					if (Row+oneX[i]<0||Row+oneX[i]>=N||Col+oneY[i]<0||Col+oneY[i]>=M) {
						continue;
					}
					if (i==0) {
						if (map[Row+oneX[i]][Col+oneY[i]]==3||map[Row+oneX[i]][Col+oneY[i]]==4||map[Row+oneX[i]][Col+oneY[i]]==7) {
							continue;
						}
						
					}
					if (i==1) {
						if (map[Row+oneX[i]][Col+oneY[i]]==3||map[Row+oneX[i]][Col+oneY[i]]==5||map[Row+oneX[i]][Col+oneY[i]]==6) {
							continue;
						}
					}
					if (i==2) {
						if (map[Row+oneX[i]][Col+oneY[i]]==2||map[Row+oneX[i]][Col+oneY[i]]==4||map[Row+oneX[i]][Col+oneY[i]]==5) {
							continue;
						}
					}
					if (i==3) {
						if (map[Row+oneX[i]][Col+oneY[i]]==2||map[Row+oneX[i]][Col+oneY[i]]==6||map[Row+oneX[i]][Col+oneY[i]]==7) {
							continue;
						}
					}
					if (map[Row+oneX[i]][Col+oneY[i]]!=0&&visit[Row+oneX[i]][Col+oneY[i]]==false) {
						q.offer(new link(Row+oneX[i],Col+oneY[i],map[Row+oneX[i]][Col+oneY[i]]));
						visit[Row+oneX[i]][Col+oneY[i]] = true;
					}
					
				}
				visit[Row][Col] = true;
				break;
			case 2:
				for (int i = 0; i < 2; i++) {
					if (Row+oneX[i]<0||Row+oneX[i]>=N) {
						continue;
					}
					if (i==0) {
						if (map[Row+oneX[i]][Col+oneY[i]]==3||map[Row+oneX[i]][Col+oneY[i]]==4||map[Row+oneX[i]][Col+oneY[i]]==7) {
							continue;
						}
						
					}
					if (i==1) {
						if (map[Row+oneX[i]][Col+oneY[i]]==3||map[Row+oneX[i]][Col+oneY[i]]==5||map[Row+oneX[i]][Col+oneY[i]]==6) {
							continue;
						}
					}
					if (map[Row+oneX[i]][Col]!=0&&visit[Row+oneX[i]][Col+oneY[i]]==false) {
						
						q.offer(new link(Row+oneX[i],Col,map[Row+oneX[i]][Col]));
						visit[Row+oneX[i]][Col+oneY[i]] = true;
					}

				}
				break;
			case 3:
				for (int i = 2; i < 4; i++) {
					if (Col+oneY[i]<0||Col+oneY[i]>=M) {
						continue;
					}
					if (i==2) {
						if (map[Row+oneX[i]][Col+oneY[i]]==2||map[Row+oneX[i]][Col+oneY[i]]==4||map[Row+oneX[i]][Col+oneY[i]]==5) {
							continue;
						}
					}
					if (i==3) {
						if (map[Row+oneX[i]][Col+oneY[i]]==2||map[Row+oneX[i]][Col+oneY[i]]==6||map[Row+oneX[i]][Col+oneY[i]]==7) {
							continue;
						}
					}
					if (map[Row][Col+oneY[i]]!=0&&visit[Row+oneX[i]][Col+oneY[i]]==false) {
						q.offer(new link(Row,Col+oneY[i],map[Row][Col+oneY[i]]));
						visit[Row+oneX[i]][Col+oneY[i]] = true;
					}

				}
				break;
			case 4:
				for (int i = 0; i < 3; i+=2) {
					if (Row+oneX[i]<0||Row+oneX[i]>=N||Col+oneY[i]<0||Col+oneY[i]>=M) {
						continue;
					}
					if (i==0) {
						if (map[Row+oneX[i]][Col+oneY[i]]==3||map[Row+oneX[i]][Col+oneY[i]]==4||map[Row+oneX[i]][Col+oneY[i]]==7) {
							continue;
						}
						
					}
					if (i==2) {
						if (map[Row+oneX[i]][Col+oneY[i]]==2||map[Row+oneX[i]][Col+oneY[i]]==4||map[Row+oneX[i]][Col+oneY[i]]==5) {
							continue;
						}
					}
					if (map[Row+oneX[i]][Col+oneY[i]]!=0&&visit[Row+oneX[i]][Col+oneY[i]]==false) {
						q.offer(new link(Row+oneX[i],Col+oneY[i],map[Row+oneX[i]][Col+oneY[i]]));
						visit[Row+oneX[i]][Col+oneY[i]] = true;
					}

				}
				break;
			case 5:
				for (int i = 1; i < 3; i++) {
					if (Row+oneX[i]<0||Row+oneX[i]>=N||Col+oneY[i]<0||Col+oneY[i]>=M) {
						continue;
					}
					if (i==1) {
						if (map[Row+oneX[i]][Col+oneY[i]]==3||map[Row+oneX[i]][Col+oneY[i]]==5||map[Row+oneX[i]][Col+oneY[i]]==6) {
							continue;
						}
					}
					if (i==2) {
						if (map[Row+oneX[i]][Col+oneY[i]]==2||map[Row+oneX[i]][Col+oneY[i]]==4||map[Row+oneX[i]][Col+oneY[i]]==5) {
							continue;
						}
					}
					if (map[Row+oneX[i]][Col+oneY[i]]!=0&&visit[Row+oneX[i]][Col+oneY[i]]==false) {
						q.offer(new link(Row+oneX[i],Col+oneY[i],map[Row+oneX[i]][Col+oneY[i]]));
						visit[Row+oneX[i]][Col+oneY[i]] = true;
					}

				}
				break;
			case 6:
				for (int i = 1; i < 4; i+=2) {
					if (Row+oneX[i]<0||Row+oneX[i]>=N||Col+oneY[i]<0||Col+oneY[i]>=M) {
						continue;
					}
					if (i==1) {
						if (map[Row+oneX[i]][Col+oneY[i]]==3||map[Row+oneX[i]][Col+oneY[i]]==5||map[Row+oneX[i]][Col+oneY[i]]==6) {
							continue;
						}
					}
					if (i==3) {
						if (map[Row+oneX[i]][Col+oneY[i]]==2||map[Row+oneX[i]][Col+oneY[i]]==6||map[Row+oneX[i]][Col+oneY[i]]==7) {
							continue;
						}
					}
					if (map[Row+oneX[i]][Col+oneY[i]]!=0&&visit[Row+oneX[i]][Col+oneY[i]]==false) {
						q.offer(new link(Row+oneX[i],Col+oneY[i],map[Row+oneX[i]][Col+oneY[i]]));
						visit[Row+oneX[i]][Col+oneY[i]] = true;
					}

				}
				break;
			case 7:
				for (int i = 0; i < 4; i+=3) {
					if (Row+oneX[i]<0||Row+oneX[i]>=N||Col+oneY[i]<0||Col+oneY[i]>=M) {
						continue;
					}
					if (i==0) {
						if (map[Row+oneX[i]][Col+oneY[i]]==3||map[Row+oneX[i]][Col+oneY[i]]==4||map[Row+oneX[i]][Col+oneY[i]]==7) {
							continue;
						}
						
					}
					if (i==3) {
						if (map[Row+oneX[i]][Col+oneY[i]]==2||map[Row+oneX[i]][Col+oneY[i]]==6||map[Row+oneX[i]][Col+oneY[i]]==7) {
							continue;
						}
					}
					if (map[Row+oneX[i]][Col+oneY[i]]!=0&&visit[Row+oneX[i]][Col+oneY[i]]==false) {
						q.offer(new link(Row+oneX[i],Col+oneY[i],map[Row+oneX[i]][Col+oneY[i]]));
						visit[Row+oneX[i]][Col+oneY[i]] = true;
					}

				}
				break;

			default:
				break;
			}

			rollcnt++;
			visit[Row][Col] = true;
		}

		bfs();
	}
}
