import java.util.*;
import java.io.*;


public class Main
{
	static int max = Integer.MIN_VALUE;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] check;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        check = new boolean[N][M];
        for(int i= 0 ; i < N ; i++) {
        	for(int j = 0 ; j < M ; j++) {
        		check[i][j] = true;
        		dfs(1,map[i][j],i,j,N,M,map);
        		check[i][j] = false;
        	}
        }
        
        
        
        System.out.println(max);
    }
    static void dfs (int cnt, int res, int x, int y, int N, int M, int[][] map) {
    	if(cnt == 4) {
    		max = Math.max(max, res);
    		return;
    	}
    	for(int k = 0 ; k < 4 ; k++) {
    		if(x+dx[k]<0 || x+dx[k]>=N || y+dy[k]<0 || y+dy[k]>=M || check[x+dx[k]][y+dy[k]]) {
    			continue;
    		}
    		if(cnt == 2) {
    			check[x+dx[k]][y+dy[k]] = true;
        		dfs(cnt+1,res+map[x+dx[k]][y+dy[k]], x, y, N, M, map);
        		check[x+dx[k]][y+dy[k]] = false;
    		}
    		check[x+dx[k]][y+dy[k]] = true;
    		dfs(cnt+1,res+map[x+dx[k]][y+dy[k]], x+dx[k], y+dy[k], N, M, map);
    		check[x+dx[k]][y+dy[k]] = false;
    	}
    }
   
}