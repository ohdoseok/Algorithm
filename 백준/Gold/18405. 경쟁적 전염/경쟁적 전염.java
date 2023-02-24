import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Virus  implements Comparable<Virus>{
    	int val;
    	int x;
    	int y;
    	Virus(int val, int x, int y){
    		this.val = val;
    		this.x = x;
    		this.y = y;
    	}
    	@Override
    	public int compareTo(Virus v1) {
    		return this.val - v1.val;
    	}
    }
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int[][] map = new int[N][N];
    	PriorityQueue<Virus> pq = new PriorityQueue<>();
    	for(int i = 0 ; i < N ; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0 ; j < N ; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j]!=0) {
    				pq.offer(new Virus(map[i][j],i,j));
    			}
    		}
    	}
    	st = new StringTokenizer(br.readLine());
    	int S = Integer.parseInt(st.nextToken());
    	int X = Integer.parseInt(st.nextToken())-1;
    	int Y = Integer.parseInt(st.nextToken())-1;
    	int res = 0;
    	for(int time = 0 ; time <= S ; time++) {
    		if(map[X][Y]!=0) {
    			res = map[X][Y];
    			break;
    		}
    		int[][] tmpMap = new int[N][N];
    		for(int i = 0 ; i < N ; i++) {
    			for(int j = 0 ; j < N ; j++) {
    				tmpMap[i][j] = map[i][j];
    			}
    		}
    		
    		while(!pq.isEmpty()) {
    			Virus virus = pq.poll();
    			int val = virus.val;
    			int x = virus.x;
    			int y = virus.y;
    			for(int k = 0 ; k < 4 ; k++) {
    				if(x+dx[k]<0 || x+dx[k]>=N || y+dy[k]<0 || y+dy[k]>=N || tmpMap[x+dx[k]][y+dy[k]]!=0) {
    					continue;
    				}
    				tmpMap[x+dx[k]][y+dy[k]] = val;
    			}
    		}
    		
    		
    		for(int i = 0 ; i < N ; i++) {
    			for(int j = 0 ; j < N ; j++) {
    				map[i][j] = tmpMap[i][j];
    				if(map[i][j] != 0 ) {
    					pq.offer(new Virus(map[i][j], i , j));
    				}
    			}
    		}
    	}
    	System.out.println(res);
    }
}