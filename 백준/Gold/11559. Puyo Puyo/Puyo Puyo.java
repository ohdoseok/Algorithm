import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Node{
		int x;
		int y;
		Node(int x , int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [][] map = new char[12][6];
		for(int i = 0 ; i < 12 ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int cnt = 0;
		while(true) {
			boolean ok = false;
			boolean[][] check = new boolean[12][6];
			for(int i = 0 ; i < 12 ; i++) {
				for(int j = 0 ; j < 6 ; j++) {
					if(map[i][j]!='.') {
						Queue<Node> q = new LinkedList<>();
						char val = map[i][j];
						q.offer(new Node(i,j));
						check[i][j] = true;
						List<Node> list = new ArrayList<>();
						list.add(new Node(i,j));
						while(!q.isEmpty()) {
							Node node = q.poll();
							int x = node.x;
							int y = node.y;
							for(int k = 0 ; k < 4 ; k++) {
								if(x+dx[k]<0 || x+dx[k]>=12 || y+dy[k]<0 || y+dy[k]>=6 || check[x+dx[k]][y+dy[k]]) {
									continue;
								}
								if(map[x+dx[k]][y+dy[k]]==val) {
									q.offer(new Node(x+dx[k],y+dy[k]));
									check[x+dx[k]][y+dy[k]] = true;
									list.add(new Node(x+dx[k], y+dy[k]));
								}
							}
						}
						if(list.size()>=4) {
							for(int z = 0 ; z < list.size() ; z++) {
								ok = true;
								map[list.get(z).x][list.get(z).y] = '.';
							}
						}
					}
				}
			}
			
			
			for(int j = 0 ; j < 6 ; j++) {
				for(int i = 11 ; i >= 0 ; i--) {
					if(map[i][j] == '.') {
						int idx = i;
						while(idx>0) {
							idx--;
							if(map[idx][j]!='.') {
								break;
							}
						}
						for(int k = idx ; k >= 0 ; k--) {
							map[k+(i-idx)][j] = map[k][j];
						}
						for(int k = 0 ; k < i-idx ; k++) {
							map[k][j] = '.';
						}
					}
				}
			}
			//연쇄가 일어난다면
			if(ok) {
				cnt++;
			}else {
				break;
			}
		}
		System.out.println(cnt);
	}
}
