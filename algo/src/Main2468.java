import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468 {
	public static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static int[][] map;
	public static boolean[][] checkMap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				if(val > max) {
					max = val;
				}
				if(min > val) {
					min = val;
				}
			}
		}
		int res = Integer.MIN_VALUE;
		for(int i = min ; i <= max ; i++) {
			checkMap = new boolean[N][N];
			int val = checkGround(i);
			if(val > res) {
				res = val;
			}
		}
		if(res == 0) {
			res = 1;
		}
		System.out.println(res);
		
		
	}
	//물에 잠기지 않는 갯수 return
	public static int checkGround(int n) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int cnt = 0;
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map.length ; j++) {
				if(map[i][j]>n && !checkMap[i][j]) {
					Queue<Node> q = new LinkedList<>();
					q.offer(new Node(i,j));
					checkMap[i][j] = true;
					while(!q.isEmpty()) {
						Node node = q.poll();
						for(int k = 0 ; k < 4 ; k++) {
							if(node.x+dx[k]<0 || node.x+dx[k]>=map.length || node.y+dy[k]<0 || node.y+dy[k]>=map.length) {
								continue;
							}
							if(map[node.x+dx[k]][node.y+dy[k]] > n && !checkMap[node.x+dx[k]][node.y+dy[k]]) {
								q.offer(new Node(node.x+dx[k],node.y+dy[k]));
								checkMap[node.x+dx[k]][node.y+dy[k]] = true;
							}
						}
					}
					cnt++;
				}
			}
		}
		return cnt;
	}
}
