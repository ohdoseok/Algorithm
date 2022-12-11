import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main14503 {
	public static class Node{
		int x;
		int y;
		int dir;
		Node(int x, int y, int dir){
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
		//현재 바라보는 방향이 0이면 0,-1 1이면 -1,0 2이면 0,1 3이면 1,0
		int[] dx = {0,-1,0,1};
		int[] dy = {-1,0,1,0};
		int[] dDir = {3,0,1,2};
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int rX = Integer.parseInt(st.nextToken());
		int rY = Integer.parseInt(st.nextToken());
		int val = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(rX,rY,val));
		int res = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(map[node.x][node.y] == 0) {
				map[node.x][node.y] = 2;
				res++;
			}
			
			if(node.x+dx[node.dir]<0 || node.x+dx[node.dir] >= N || node.y+dy[node.dir] <0 || node.y+dy[node.dir] >= M) {
				
			}else {
				boolean check = false;
				for(int j = 0 ; j < 4 ; j++) {
					if(node.x+dx[j]<0 || node.x+dx[j] >= N || node.y+dy[j] <0 || node.y+dy[j] >= M) {
						continue;
					}
					if(map[node.x+dx[j]][node.y+dy[j]]==0) {
						check = true;
					}
				}
				if(check) {
					if(map[node.x+dx[node.dir]][node.y+dy[node.dir]]==0) {
						q.offer(new Node(node.x+dx[node.dir],node.y+dy[node.dir],dDir[node.dir]));
					}else {
						q.offer(new Node(node.x,node.y,dDir[node.dir]));
					}
				}else {
					int dD;
					if(node.dir==0) {
						dD = 3;
					}else if(node.dir==1) {
						dD = 0;
					}else if(node.dir ==2) {
						dD = 1;
					}else {
						dD = 2;
					}
					if(node.x+dx[dD]<0 || node.x+dx[dD] >= N || node.y+dy[dD] < 0 || node.y+dy[dD] >= M) {
						break;
					}else {
						if(map[node.x+dx[dD]][node.y+dy[dD]]!=1) {
							q.offer(new Node(node.x+dx[dD],node.y+dy[dD],node.dir));
						}
					}
				}
				
			}
			
		}
		System.out.println(res);
	}
}
