import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class Main16234 {
	public static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		Queue<Node> q = new LinkedList<>();
		int res = 0;
		while(true) {
			boolean noMore = false;
			boolean[][] check = new boolean[N][N];
			for(int i = 0; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(check[i][j]) {
						continue;
					}
					q.offer(new Node(i,j));
					int sum = 0;
					int cnt = 0;
					Queue<Node> countNode = new LinkedList<>();
					while(!q.isEmpty()) {
						Node node = q.poll();
						cnt++;
						sum+=map[node.x][node.y];
						countNode.offer(new Node(node.x,node.y));
						check[node.x][node.y] = true;
						for(int k = 0 ; k<4 ; k++) {
							if(node.x+dx[k]<0 || node.x+dx[k]>=N || node.y+dy[k]<0 || node.y+dy[k]>= N) {
								continue;
							}
							if(!check[node.x+dx[k]][node.y+dy[k]] && Math.abs(map[node.x][node.y]-map[node.x+dx[k]][node.y+dy[k]])>=L && Math.abs(map[node.x][node.y]-map[node.x+dx[k]][node.y+dy[k]])<=R) {
								q.offer(new Node(node.x+dx[k],node.y+dy[k]));
								noMore = true;
								check[node.x+dx[k]][node.y+dy[k]] = true;
							}
									
						}
						
					}
					int avg = sum/cnt;
					while(!countNode.isEmpty()) {
						Node node = countNode.poll();
						map[node.x][node.y] = avg;
					}
				}
			}
			if(!noMore) {
				break;
			}
			res++;
		}
		System.out.println(res);
		
	}
}
