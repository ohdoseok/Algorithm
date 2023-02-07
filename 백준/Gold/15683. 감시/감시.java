import java.io.*;
import java.util.*;
public class Main {
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static List<Node> list = new ArrayList<>();
	//상,우,하,좌
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0 && map[i][j]!=6) {
					list.add(new Node(i,j));
				}
			}
		}
		dfs(map,0);
		System.out.println(min);
	}
	public static void dfs(int[][] map,int cnt) {

		if(cnt == list.size()) {
			int tmpRes = 0;
			for(int i = 0 ; i < map.length ; i++) {
				for(int j = 0 ; j < map[i].length ; j++) {
					if(map[i][j]==0) {
						tmpRes++;
					}
				}
			}
			if(min > tmpRes) {
				min = tmpRes;
			}
			return;
		}

		//dfs로 보낼 map생
		int[][] tmpMap = new int[map.length][map[0].length];
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}
		int i = cnt;

		Node node = list.get(i);
		int x = node.x;
		int y = node.y;
		int val = map[x][y];
		switch(val) {
		case 1:
			for(int j = 0 ; j < 4 ; j++) {
				int tmpX = x;
				int tmpY = y;
				while(true) {
					tmpX+=dx[j];
					tmpY+=dy[j];
					if(tmpX <0 || tmpX >= map.length || tmpY <0 || tmpY >= map[0].length) {
						break;
					}
					if(tmpMap[tmpX][tmpY] > 0) {
						if(tmpMap[tmpX][tmpY]==6) {
							break;
						}else {
							continue;
						}
					}else {
						tmpMap[tmpX][tmpY] = -1;
					}
				}
				dfs(tmpMap,cnt+1);
				for(int i1 = 0 ; i1 < map.length ; i1++) {
					for(int j1 = 0 ; j1 < map[i1].length ; j1++) {
						tmpMap[i1][j1] = map[i1][j1];
					}
				}
			}
			break;
		case 2:
			for(int k = 0 ; k <2 ; k++) {
				for(int j = k ; j < 4 ; j+=2) {
					int tmpX = x;
					int tmpY = y;
					while(true) {
						tmpX+=dx[j];
						tmpY+=dy[j];
						if(tmpX <0 || tmpX >= map.length || tmpY <0 || tmpY >= map[0].length) {
							break;
						}
						if(tmpMap[tmpX][tmpY] > 0) {
							if(tmpMap[tmpX][tmpY]==6) {
								break;
							}else {
								continue;
							}
						}else {
							tmpMap[tmpX][tmpY] = -1;
						}
					}
				}
				dfs(tmpMap,cnt+1);
				for(int i1 = 0 ; i1 < map.length ; i1++) {
					for(int j1 = 0 ; j1 < map[i1].length ; j1++) {
						tmpMap[i1][j1] = map[i1][j1];
					}
				}
			}
			break;
		case 3:
			for(int k = 0 ; k <4 ; k++) {
				for(int j = k ; j < k+2 ; j++){
					int tmpX = x;
					int tmpY = y;
					while(true) {
						tmpX+=dx[j%4];
						tmpY+=dy[j%4];
						if(tmpX <0 || tmpX >= map.length || tmpY <0 || tmpY >= map[0].length) {
							break;
						}
						if(tmpMap[tmpX][tmpY] > 0) {
							if(tmpMap[tmpX][tmpY]==6) {
								break;
							}else {
								continue;
							}
						}else {
							tmpMap[tmpX][tmpY] = -1;
						}
					}
				}
				dfs(tmpMap,cnt+1);
				for(int i1 = 0 ; i1 < map.length ; i1++) {
					for(int j1 = 0 ; j1 < map[i1].length ; j1++) {
						tmpMap[i1][j1] = map[i1][j1];
					}
				}
			}
			break;
		case 4:
			for(int k = 0 ; k <4 ; k++) {
				for(int j = k ; j < k+3 ; j++){
					int tmpX = x;
					int tmpY = y;
					while(true){
						tmpX+=dx[j%4];
						tmpY+=dy[j%4];
						if(tmpX <0 || tmpX >= map.length || tmpY <0 || tmpY >= map[0].length) {
							break;
						}
						if(tmpMap[tmpX][tmpY] > 0) {
							if(tmpMap[tmpX][tmpY]==6) {
								break;
							}else {
								continue;
							}
						}else {
							tmpMap[tmpX][tmpY] = -1;
						}
					}
				}
				dfs(tmpMap,cnt+1);
				for(int i1 = 0 ; i1 < map.length ; i1++) {
					for(int j1 = 0 ; j1 < map[i1].length ; j1++) {
						tmpMap[i1][j1] = map[i1][j1];
					}
				}
			}
			break;
		case 5:
			for(int j = 0 ; j < 4 ; j++) {
				int tmpX = x;
				int tmpY = y;
				while(true) {
					tmpX+=dx[j];
					tmpY+=dy[j];
					if(tmpX <0 || tmpX >= map.length || tmpY <0 || tmpY >= map[0].length) {
						break;
					}
					if(tmpMap[tmpX][tmpY] > 0) {
						if(tmpMap[tmpX][tmpY]==6) {
							break;
						}else {
							continue;
						}
					}else {
						tmpMap[tmpX][tmpY] = -1;
					}
				}
			}
			dfs(tmpMap,cnt+1);
			for(int i1 = 0 ; i1 < map.length ; i1++) {
				for(int j1 = 0 ; j1 < map[i1].length ; j1++) {
					tmpMap[i1][j1] = map[i1][j1];
				}
			}
			break;
		}

	}

}
