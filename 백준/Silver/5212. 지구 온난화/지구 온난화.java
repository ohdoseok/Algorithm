import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		char[][] map = new char[x][y];
		for(int i = 0 ; i < x ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		char[][] cpyMap = new char[x][y];
		for(int i = 0 ; i < cpyMap.length ; i++) {
			for(int j = 0 ; j < cpyMap[i].length ; j++) {
				cpyMap[i][j] = map[i][j];
			}
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		for(int i = 0 ; i < x ; i++) {
			for(int j = 0 ; j < y ; j++) {
				if(map[i][j]=='X') {
					int cnt = 0;
					for(int k = 0 ; k < 4 ; k++) {
						if(i+dx[k]<0 || i+dx[k]>=x || j+dy[k]<0 || j+dy[k]>=y) {
							cnt++;
							continue;
						}
						if(map[i+dx[k]][j+dy[k]]=='.') {
							cnt++;
						}
					}
					if(cnt>=3) {
						cpyMap[i][j] = '.';
					}
				}
			}
		}
		//왼쪽 위 좌표 구하기
		int leftX= 0;
		int leftY= 0;
		exit:
		for(int i = 0 ; i < cpyMap.length; i++) {
			for(int j = 0 ; j < cpyMap[0].length; j++) {
				if(cpyMap[i][j]=='X') {
					leftX = i;
					break exit;
				}
			}
		}
		exit1:
		for(int j = 0 ; j < cpyMap[0].length ; j++) {
			for(int i = 0 ; i < cpyMap.length ; i++) {
				if(cpyMap[i][j]=='X') {
					leftY = j;
					break exit1;
				}
			}
		}
		//오른쪽 아래 좌표 구하
		int rightX = 0;
		int rightY= 0;
		exit2:
			for(int i = cpyMap.length-1 ; i >=0 ; i--) {
				for(int j = 0 ; j < cpyMap[i].length; j++) {
					if(cpyMap[i][j]=='X') {
						rightX = i;
						break exit2;
					}
				}
			}
		exit3:
		for(int j = cpyMap[0].length-1 ; j >=0  ; j--) {
			for(int i = 0 ; i < cpyMap.length ; i++) {
				if(cpyMap[i][j]=='X') {
					rightY = j;
					break exit3;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = leftX ; i < rightX+1 ; i++) {
			for(int j = leftY ; j < rightY+1 ;j++) {
				sb.append(cpyMap[i][j]);
			}
			sb.append('\n');
		}
		String result = sb.substring(0,sb.length()-1);
		System.out.println(result);
		
	}
}
