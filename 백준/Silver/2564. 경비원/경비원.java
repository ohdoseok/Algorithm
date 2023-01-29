import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int wide = Integer.parseInt(st.nextToken());
		int high = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[high+1][wide+1];
		int goalX = 0;
		int goalY = 0;
		for(int i = 0 ; i < N+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int sec = Integer.parseInt(st.nextToken());
			int x=0;
			int y=0;
			switch (first) {
			case 1:
				x = 0;
				y = sec;
				break;
			case 2:
				x = high;
				y = sec;
				break;
			case 3:
				x = sec;
				y = 0;
				break;
			default:
				x = sec;
				y = wide;
				break;
			}
			if(i == N) {
				goalX = x;
				goalY = y;
			}else {
				map[x][y] = Integer.MAX_VALUE;

			}
		}
		int cnt = 0;
		//시계방향회전
		while(cnt != wide*2+high*2) {
			if(goalX == 0) {
				if(goalY == wide) {
					goalX++;
				}else {
					goalY++;
				}
			}else if(goalY == wide ) {
				if(goalX == high) {
					goalY--;
				}else {
					goalX++;	
				}
			}else if(goalX == high) {
				if(goalY == 0) {
					goalX--;
				}else {
					goalY--;
				}
			}else if(goalY == 0) {
				if(goalX == 0) {
					goalY++;
				}else {
					goalX--;
				}
			}
			cnt++;
			if(map[goalX][goalY] > cnt) {
				map[goalX][goalY] = cnt;
			}
		}
		cnt = 0;
		//반시계방향회전
		while(cnt != wide*2+high*2) {
			if(goalX == 0) {
				if(goalY == 0) {
					goalX++;
				}else {
					goalY--;
				}
			}else if(goalY == wide ) {
				if(goalX == 0) {
					goalY--;
				}else {
					goalX--;	
				}
			}else if(goalX == high) {
				if(goalY == wide) {
					goalX--;
				}else {
					goalY++;
				}
			}else if(goalY == 0) {
				if(goalX == high) {
					goalY++;
				}else {
					goalX++;
				}
			}
			cnt++;
			if(map[goalX][goalY] > cnt) {
				map[goalX][goalY] = cnt;
			}
		}
		int result = 0;
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				result+=map[i][j];
			}
		}
		System.out.println(result);

	}
}
