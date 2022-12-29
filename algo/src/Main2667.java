import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main2667 {
	public static class Node{
		int x;
		int y;
		int val;
		Node(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0 ; i < N ;i++) {
			String array = br.readLine();
			char[] arrayToc = array.toCharArray();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = arrayToc[j]-'0';
			}
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		List<Integer> list = new ArrayList<>();
		boolean[][] check = new boolean[N][N];
		Queue<Node> q = new LinkedList<>();
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(check[i][j] || map[i][j]!=1) {
					continue;
				}
				q.offer(new Node(i,j,map[i][j]));
				check[i][j] = true;
				int cnt = 0;
				while(!q.isEmpty()) {
					Node node = q.poll();
					cnt++;
					for(int k = 0 ; k < 4; k++) {
						if(node.x+dx[k]<0 || node.x+dx[k] >=N || node.y+dy[k]<0 || node.y+dy[k]>=N) {
							continue;
						}
						if(!check[node.x+dx[k]][node.y+dy[k]] && map[node.x+dx[k]][node.y+dy[k]]==1) {
							q.offer(new Node(node.x+dx[k],node.y+dy[k],map[node.x+dx[k]][node.y+dy[k]]));
							check[node.x+dx[k]][node.y+dy[k]] = true;
						}
					}
				}
				list.add(cnt);
			}
		}
		Collections.sort(list);
		StringBuilder res = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++) {
			res.append(list.get(i)+"\n");
		}
		String result = res.substring(0,res.length()-1);
		System.out.println(list.size());
		System.out.println(result);
	}
}
