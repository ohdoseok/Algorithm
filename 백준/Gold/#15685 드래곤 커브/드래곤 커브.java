import java.util.*;
import java.io.*;


public class Main
{
	//기존의  방향 
	//char[] ori = {'R','U','L','D'};

	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	//변경후 방향 -> +1%4방향임을 확인가능 
	//char[] turn = {'U','L','D','R'};
	static class Node{
		int dir;
		Node(int dir){
			this.dir = dir;
		}
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[101][101];
		for(int time = 0 ; time < N ; time++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Node> list = new ArrayList<>();
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());
			list.add(new Node(dir));
			map[x][y] = true;
			if(x+dx[dir]>= 0 && y+dy[dir]>=0) {
				map[x+dx[dir]][y+dy[dir]] = true;
			}
			dfs(map,0,gen,list,x+dx[dir],y+dy[dir]);
		}
		int res = 0;
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(map[i][j] && map[i+1][j] && map[i+1][j+1] && map[i][j+1]) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
	public static void dfs(boolean[][]map, int cnt, int gen, List<Node> list, int nowX, int nowY) {

		if(gen == cnt) {
			return;
		}
		for(int i = list.size()-1 ; i >= 0 ; i--) {
			Node node = list.get(i);
			int dir = node.dir;
			int changeDir = (dir+1)%4;
			nowX = nowX+dx[changeDir];
			nowY = nowY+dy[changeDir];
			if(nowX>=0 && nowY>=0) {
				map[nowX][nowY] = true;
			}
			list.add(new Node(changeDir));
			
		}
		dfs(map,cnt+1,gen,list,nowX,nowY);

	}
}