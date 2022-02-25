import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int X;
	static int Y;
	static int[][] map;
	static int res = 0;
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
		q = new LinkedList<Node>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==1) {
					q.offer(new Node(i, j));
				}
			}
		}
		bfs();
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (map[i][j]==0) {
					res = 0;
					break;
				}
			}
		}
		System.out.println(res-1);
	}
	static class Node {
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				int x = node.x;
				int y = node.y;
				for (int j = 0; j < 4; j++) {
					if (x+dx[j]<0||x+dx[j]>=Y||y+dy[j]<0||y+dy[j]>=X) {
						continue;
					}
					if (map[x+dx[j]][y+dy[j]]==0) {
						map[x+dx[j]][y+dy[j]] = 1;
						q.offer(new Node(x+dx[j], y+dy[j]));
					}
				}
			}
			
			res++;
		}
	}
}
