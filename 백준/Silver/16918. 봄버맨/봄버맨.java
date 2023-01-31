import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C= Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for(int i = 0 ; i < R ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		if(N>2 && N%2!=0) {
			while(N!=3 && N !=5) {
				N-=4;
			}
		}
		int[] dx = {0,-1,0,1,0};
		int[] dy = {0,0,1,0,-1};
		char[][] newMap = new char[R][C];
		char[][] newMap2 = new char[R][C];
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				newMap[i][j] = 'O';
				newMap2[i][j] = 'O';
			}
		}
		if(N%2!=0) {
			switch (N) {
			case 1:
				for(int i = 0 ; i < R ; i++) {
					for(int j = 0 ; j < C ; j++) {
						newMap[i][j] = map[i][j];
					}
				}
				break;
			case 5:
				for(int i = 0 ; i < R ; i++) {
					for(int j = 0 ; j < C ; j++) {
						if(map[i][j] == 'O') {
							for(int k = 0 ; k < 5 ; k++) {
								if(i+dx[k]<0 || i+dx[k]>=R || j+dy[k]<0 || j+dy[k]>=C) {
									continue;
								}
								newMap2[i+dx[k]][j+dy[k]] = '.';
							}
						}
					}
				}
				
				for(int i = 0 ; i < R ; i++) {
					for(int j = 0 ; j < C ; j++) {
						if(newMap2[i][j] == 'O') {
							for(int k = 0 ; k < 5 ; k++) {
								if(i+dx[k]<0 || i+dx[k]>=R || j+dy[k]<0 || j+dy[k]>=C) {
									continue;
								}
								newMap[i+dx[k]][j+dy[k]] = '.';
							}
						}
					}
				}
				break;
				
			case 3:
				for(int i = 0 ; i < R ; i++) {
					for(int j = 0 ; j < C ; j++) {
						if(map[i][j] == 'O') {
							for(int k = 0 ; k < 5 ; k++) {
								if(i+dx[k]<0 || i+dx[k]>=R || j+dy[k]<0 || j+dy[k]>=C) {
									continue;
								}
								newMap[i+dx[k]][j+dy[k]] = '.';
							}
						}
					}
				}
				break;

			default:
				break;
			}
		}
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++){
				sb.append(newMap[i][j]);
			}
			sb.append('\n');
		}
		String res = sb.substring(0,sb.length()-1);
		System.out.println(res);
	}
}
