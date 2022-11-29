import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main7569 {
	static class Node{
		int H;
		int N;//세로
		int M;//가로
		
		Node(int H, int N, int M){
			this.H = H;
			this.M = M;
			this.N = N;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//가로
		int M = Integer.parseInt(st.nextToken());//세로
		int H = Integer.parseInt(st.nextToken());
		int[][][] map = new int[H][2*M][N];
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int[] dh = {-1,1};
		Queue<Node> q = new LinkedList<>();
		for(int i = 0 ;i < H ; i++) {
			for(int j = 0 ; j < M ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < N ; k++) {
					int val = Integer.parseInt(st.nextToken());
					if(val == 1) {
						q.offer(new Node(i,j,k));
					}
					map[i][j][k] = val;
				}
			}
		}
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			boolean check = false;
			for(int j = 0 ; j < size ; j++) {
				Node node = q.poll();
				
				//4방탐색
				for(int i = 0 ; i < 4 ; i++) {
					if(node.M+dy[i]<0 || node.M+dy[i]>=N || node.N+dx[i]<0 || node.N+dx[i]>=M) {
						continue;
					}
					if(map[node.H][node.N+dx[i]][node.M+dy[i]] == 0) {
						map[node.H][node.N+dx[i]][node.M+dy[i]] = 1;
						q.offer(new Node(node.H,node.N+dx[i], node.M+dy[i]));
						check = true;
					}
					
				}
				//위아래탐색
				for(int i = 0 ; i < 2 ; i++) {
					if(node.H+dh[i]<0 || node.H+dh[i]>=H) {
						continue;
					}
					if(map[node.H+dh[i]][node.N][node.M]==0) {
						map[node.H+dh[i]][node.N][node.M] = 1;
						q.offer(new Node(node.H+dh[i],node.N,node.M));
						check = true;
					}
				}
				
			}
			if(check) {
				cnt++;
			}
		}
		Loop1:
		for(int i = 0 ;i < H ; i++) {
			for(int j = 0 ; j < M ; j++) {
				for(int k = 0 ; k < N ; k++) {
					if(map[i][j][k] == 0) {
						cnt = -1;
						break Loop1;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
