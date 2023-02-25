import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Node{
    	int x;
    	int y;
    	int high;
    	Node(int x , int y , int high){
    		this.x = x;
    		this.y = y;
    		this.high = high;
    	}
    }
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[][] map = new int[N][M];
    	Queue<Node> q = new LinkedList<>();
    	for(int i = 0 ; i < N ;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0 ; j < M ; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] != 0 ) {
    				q.offer(new Node(i,j,map[i][j]));
    			}
    		}
    	}
    	int cnt = 0;
    	while(true) {
    		int size = q.size();
    		int[][] tmpMap = new int[N][M];
    		boolean[][] check = new boolean[N][M];
    		int group = 0;
    		for(int i = 0 ; i < N ; i++) {
    			for(int j = 0 ; j < M ; j++) {
    				tmpMap[i][j] = map[i][j];
    				if(!check[i][j] && map[i][j]!=0) {
    					
    					Queue<Node> tmq = new LinkedList<>();
    			    	tmq.offer(new Node(i,j,map[i][j]));
    			    	check[i][j] = true;
    			    	while(!tmq.isEmpty()) {
    			    		Node node = tmq.poll();
    			    		int x = node.x;
    			    		int y = node.y;
    			    		for(int k = 0 ; k < 4 ; k++) {
    			    			if(x+dx[k]<0 || x+dx[k]>=N || y+dy[k]<0 || y+dy[k]>=M || check[x+dx[k]][y+dy[k]]) {
    			    				continue;
    			    			}
    			    			if(map[x+dx[k]][y+dy[k]]!=0) {
    			    				tmq.offer(new Node(x+dx[k], y+dy[k], map[x+dx[k]][y+dy[k]]));
    			    				check[x+dx[k]][y+dy[k]] = true;
    			    			}
    			    		}
    			    	}
    					
    					
    					
    					
    					group++;
    				}
    			}
    		}
    		if(group == 0) {
    			cnt = 0;
    			break;
    		}
    		if(group >= 2) {
    			break;
    		}
    		for(int i = 0 ; i < size ; i++) {
    			Node node = q.poll();
        		int x = node.x;
        		int y = node.y;
        		for(int k = 0 ; k < 4 ; k++) {
        			if(x+dx[k]<0 || x+dx[k]>=N || y+dy[k]<0 || y+dy[k]>=M || tmpMap[x][y] <=0 ) {
        				continue;
        			}
        			if(map[x+dx[k]][y+dy[k]]==0) {
        				tmpMap[x][y]--;
        			}
        		}
        		if(tmpMap[x][y]>0) {
        			q.offer(new Node(x,y,tmpMap[x][y]));
        		}
        		
    		}
    		for(int i = 0 ; i < N ; i++) {
    			for(int j = 0 ; j < M ; j++) {
    				map[i][j] = tmpMap[i][j];
    			}
    		}
    		cnt++;
    	}
    	System.out.println(cnt);
    	
    }
    public static void findGroup(int x, int y, int[][] map, boolean[][] check) {
    	
    }
}