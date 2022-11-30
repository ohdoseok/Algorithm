import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589 {
	public static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static char[][] map;
	//거리를 측정한 node를 표시하기위한 map
	//public static boolean[][] checkNode;
	//bfs할때 중복제거를 위한 map
	public static boolean[][] checkMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//세로
		int N = Integer.parseInt(st.nextToken());
		//가로
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		//checkNode = new boolean[N][M];
		for(int i = 0 ; i < N ;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j]=='L') {
					checkMap = new boolean[N][M];
					Queue<Node> q = new LinkedList<>();
					q.offer(new Node(i,j));
					//checkNode[i][j] = true;
					checkMap[i][j] = true;
					int cnt = -1;
					while(!q.isEmpty()) {
						int size = q.size();
						for(int z = 0 ; z < size ; z++) {
							Node node = q.poll();
							for(int k = 0 ; k < 4 ; k++) {
								if(node.x + dx[k] < 0 || node.x + dx[k] >= N || node.y + dy[k] <0 || node.y + dy[k]>=M) {
									continue;
								}
								if(/*!checkNode[node.x+dx[k]][node.y+dy[k]] &&*/ !checkMap[node.x+dx[k]][node.y+dy[k]] && map[node.x+dx[k]][node.y+dy[k]] == 'L') {
									q.offer(new Node(node.x+dx[k],node.y+dy[k]));
									checkMap[node.x+dx[k]][node.y+dy[k]] = true;
								}
							}
						}
						cnt++;
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
