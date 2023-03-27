import java.util.*;
import java.io.*;



public class Main
{
	//꺾이는 빛
	//0으로 접근하면 1방향을 얻는다.
	//좌->우 , 하->상 , 우->좌 , 상->하 
	static int[] light = {1,0,3,2};
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static class Node{
		int x;
		int y;
		int dir;
		Node(int x, int y , int dir){
			this.x = x;
			this.dir = dir;
			this.y = y;
		}
	}
	static class Res{
		int x;
		int y;
		Res(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		List<Node>list = new ArrayList<>();
		//접근방향 
		for(int i = 0 ; i < n ; i++) {
			list.add(new Node(i,0,0));
		}
		for(int j = 0 ; j < m ; j++) {
			list.add(new Node(n-1,j,1));
		}
		for(int i = n-1 ; i >= 0 ; i--) {
			list.add(new Node(i,m-1,2));
		}
		for(int j = m-1 ; j >= 0 ; j--) {
			list.add(new Node(0,j,3));
		}
//		StringBuilder sb = new StringBuilder();
		List<Node> res = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		for(int i = 0 ; i < list.size() ; i++) {
			q.clear();
			q.offer(list.get(i));
			while(!q.isEmpty()) {
				Node node = q.poll();
				int nowX = node.x;
				int nowY = node.y;
				int nowDir = node.dir;
				if(map[nowX][nowY]==1) {
					nowDir = light[nowDir];
				}
				int nextX = nowX+dx[nowDir];
				int nextY = nowY+dy[nowDir];
				if(nextX<0 || nextX>=n || nextY<0 || nextY>=m) {
//					if(nextX<0 || nextX>= n) {
//						sb.append(nextY);
//					}else {
//						sb.append(nextX);
//					}
//					sb.append(" ");
					res.add(new Node(nowX,nowY,(nowDir+2)%4));
					break;
				}
				q.offer(new Node(nextX,nextY,nowDir));
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean[] check = new boolean[list.size()];
		for(int i = 0 ; i < res.size() ; i++) {
			Node change = res.get(i);
			for(int j = 0 ; j < list.size() ; j++) {
				if(check[j]) {
					continue;
				}
				Node ori = list.get(j);
				if(change.x == ori.x && change.y == ori.y && change.dir == ori.dir) {
					check[j] = true;
					sb.append(j+1);
					sb.append(" ");
				}
			}
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
		
}