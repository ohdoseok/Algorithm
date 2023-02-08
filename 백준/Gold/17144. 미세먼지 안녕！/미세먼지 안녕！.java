import java.io.*;
import java.util.*;
public class Main {
	//우,상,좌,하 
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int leftX = 0;
		int leftY = 0;
		int rightX = 0;
		int rightY = 0;
		int minusCnt = 0;
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					if(minusCnt==0) {
						leftX = i;
						leftY = j;
						minusCnt++;
					}else {
						rightX = i;
						rightY = j;
					}
				}
			}
		}
		for(int i = 0 ; i < T ; i++) {
			fourDir(map);
			turnLeft(map,leftX,leftY);
			turnRight(map,rightX,rightY);
		}
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j]>0) {
					res+=map[i][j];
				}
			}
		}
		System.out.println(res);
	}
	public static void fourDir(int[][] map) {
		int[][] tmpMap = new int[map.length][map[0].length];
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				if(map[i][j] == -1) {
					tmpMap[i][j] = -1;
				}
				if(map[i][j]!=0 && map[i][j] != -1) {
					int oriVal = map[i][j];
					int val = map[i][j]/5;
					for(int k = 0 ; k < 4 ; k++) {
						if(i+dx[k]<0 || i+dx[k]>=map.length || j+dy[k]<0 || j+dy[k]>=map[0].length) {
							continue;
						}
						if(map[i+dx[k]][j+dy[k]]==-1) {
							continue;
						}
						tmpMap[i+dx[k]][j+dy[k]] += val;
						oriVal-=val;
					}
					tmpMap[i][j] += oriVal;
				}
			}
		}
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				map[i][j] = tmpMap[i][j];
			}
		}
	}
	public static void turnLeft(int[][] map, int X, int Y) {
		int tmpX = X;
		int tmpY = Y;
		int tmpVal = 0;
		int tmpVal2 = 0;
		for(int i = 0 ; i < 4 ; i++) {
			while(true) {
				if(tmpX+dx[i] < 0 || tmpX+dx[i]>X || tmpY+dy[i]<0 || tmpY+dy[i]>=map[0].length) {
					break;
				}
				if(tmpX+dx[i]== X && tmpY+dy[i] == Y) {
					break;
				}
				tmpVal2 = tmpVal;
				tmpVal = map[tmpX+dx[i]][tmpY+dy[i]];
				
				if(tmpX == X && tmpY == Y) {
					map[tmpX+dx[i]][tmpY+dy[i]] = 0;
				}else {
					map[tmpX+dx[i]][tmpY+dy[i]] = tmpVal2;
				}
				tmpX +=dx[i];
				tmpY +=dy[i];
			}
		}
	}
	public static void turnRight(int[][] map, int X, int Y) {
		int tmpX = X;
		int tmpY = Y;
		int tmpVal = 0;
		int tmpVal2 = 0;
		for(int j = 0 ; j > -4 ; j--) {
			int i = (4+j)%4;
			while(true) {
				if(tmpX+dx[i] < X || tmpX+dx[i]>=map.length || tmpY+dy[i]<0 || tmpY+dy[i]>=map[0].length) {
					break;
				}
				if(tmpX+dx[i]== X && tmpY+dy[i] == Y) {
					break;
				}
				tmpVal2 = tmpVal;
				tmpVal = map[tmpX+dx[i]][tmpY+dy[i]];

				if(tmpX == X && tmpY == Y) {
					map[tmpX+dx[i]][tmpY+dy[i]] = 0;
				}else {
					map[tmpX+dx[i]][tmpY+dy[i]] = tmpVal2;
				}
				tmpX +=dx[i];
				tmpY +=dy[i];
			}
		}
	}
}
