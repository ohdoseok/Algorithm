import java.util.*;
import java.io.*;


public class Main
{
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		//0으로 초기화 하고 마지막에 끝날때 1씩 더해서 출력하자 
		int[][] map = new int[N][N];
		int M = Integer.parseInt(st.nextToken());
		for(int time = 0 ; time < M ; time++) {
			int[][] tmpMap = new int[N][N];
			int[] cnt = new int[3];
			st = new StringTokenizer(br.readLine());
			cnt[0] = Integer.parseInt(st.nextToken());
			cnt[1] = Integer.parseInt(st.nextToken());
			cnt[2] = Integer.parseInt(st.nextToken());
			int idx = 0;
			for(int i = N-1 ; i >= 0 ; i--) {
				while(cnt[idx]==0) {
					idx++;
				}
				tmpMap[i][0] = idx;
				cnt[idx]--;
			}
			for(int j = 1 ; j < N ; j++) {
				while(cnt[idx]==0) {
					idx++;
				}
				tmpMap[0][j] = idx;
				cnt[idx]--;
			}
			tmpMap[1][1] = Math.max(Math.max(tmpMap[0][0], tmpMap[0][1]),tmpMap[1][0]);
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(i==0||j==0) {
						map[i][j]+=tmpMap[i][j];
						continue;
						
					}
					if(i==1&&j==1) {
						map[i][j]+=tmpMap[i][j];
						continue;
					}
					tmpMap[i][j] = Math.max(tmpMap[i-1][j], tmpMap[i][j-1]);
					map[i][j]+=tmpMap[i][j];
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				sb.append((map[i][j]+1)+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append('\n');
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
		
		

	}
}