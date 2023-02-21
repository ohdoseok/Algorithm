import java.util.*;
import java.io.*;


public class Main
{
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int zeroCnt = 0;
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 1) {
        			zeroCnt++;
        		}
        	}
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int cnt = 0;
        int res = zeroCnt;
        if(zeroCnt != 0) {
        	while(true) {
            	int tmpRes = 0;
            	Queue<Node> q = new LinkedList<>();
                q.offer(new Node(0,0));
                boolean[][] check = new boolean[N][M];
                check[0][0] = true;
                int[][] tmpMap = new int[N][M];
                
            	for(int j = 0 ; j < N ; j++) {
            		for(int k = 0 ; k < M ; k++) {
            			tmpMap[j][k] = map[j][k];
            		}
            	}
                while(!q.isEmpty()) {
                	
                	Node node = q.poll();
                	int x = node.x;
                	int y = node.y;
                	
                	if(map[x][y] == 0) {
                		for(int i = 0 ; i < 4 ; i++) {
                			if(x+dx[i]<0 || x+dx[i]>=N || y+dy[i]<0 || y+dy[i]>=M) {
                				continue;
                			}
                			if(!check[x+dx[i]][y+dy[i]] && map[x+dx[i]][y+dy[i]]==0) {
                				q.offer(new Node(x+dx[i] , y+dy[i]));
                				check[x+dx[i]][y+dy[i]] = true;
                			}else if(!check[x+dx[i]][y+dy[i]] && map[x+dx[i]][y+dy[i]]==1) {
                				tmpMap[x+dx[i]][y+dy[i]] = 0;
                			}
                		}
                	}
                }
                cnt++;
                for(int i = 0 ; i < N ; i++) {
                	for(int j = 0 ; j < M ; j++) {
                		if(tmpMap[i][j] == 1) {
                			tmpRes++;
                		}
                		map[i][j] = tmpMap[i][j];
                	}
                }
                if(tmpRes == 0) {
                	break;
                }else {
                	res = tmpRes;
                }
            }
        }
        
        System.out.println(cnt);
        System.out.println(res);
        
        
    }
    
	   
   
}