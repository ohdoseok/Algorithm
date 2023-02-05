import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		int[] dice = {0,map[x][y],0,0,0,0};
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < K ; i++) {
			int val = Integer.parseInt(st.nextToken());
			boolean OK = true;
			switch(val) {
				case 1:
					if(y+1<M) {
						y+=1;
						if(map[x][y]==0) {
							map[x][y] = dice[5];
						}else {
							OK = false;
						}
						int[] tmpDice = {dice[3],map[x][y],dice[2],dice[1],dice[4],dice[0]};
						if(!OK) {
							map[x][y] = 0;
						}
						dice = tmpDice.clone();
						sb.append(dice[0]);
						sb.append('\n');
					}
					break;
				case 2:
					if(y-1>=0) {
						y-=1;
						if(map[x][y]==0) {
							map[x][y] = dice[3];
						}else {
							OK = false;
						}
						int[] tmpDice = {dice[5],map[x][y],dice[2],dice[0],dice[4],dice[1]};
						if(!OK) {
							map[x][y] = 0;
						}
						dice = tmpDice.clone();
						sb.append(dice[0]);
						sb.append('\n');
					}
					break;
				case 3:
					if(x-1>=0) {
						x-=1;
						if(map[x][y]==0) {
							map[x][y] = dice[4];
						}else {
							OK = false;
						}
						int[] tmpDice = {dice[2],map[x][y],dice[1],dice[3],dice[0],dice[5]};
						if(!OK) {
							map[x][y] = 0;
						}
						dice = tmpDice.clone();
						sb.append(dice[0]);
						sb.append('\n');
					}
					break;
				case 4:
					if(x+1<N) {
						x+=1;
						if(map[x][y]==0) {
							map[x][y] = dice[2];
						}else {
							OK = false;
						}
						int[] tmpDice = {dice[4],map[x][y],dice[0],dice[3],dice[1],dice[5]};
						if(!OK) {
							map[x][y] = 0;
						}
						dice = tmpDice.clone();
						sb.append(dice[0]);
						sb.append('\n');
					}
					break;
			}
			
			
		}
		String res = sb.substring(0,sb.length()-1);
		System.out.println(res);
	}

}
