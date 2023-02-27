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
	static class FireBall{
		int x;
		int y;
		int mass;
		int dir;
		int speed;
		
		FireBall(int x, int y, int mass , int dir, int speed ){
			this.x = x;
			this.y = y;
			this.mass = mass;
			this.dir = dir;
			this.speed = speed;
		}
	}
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<FireBall> q = new LinkedList<>();
        for(int i = 0 ; i < M ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken()) -1;
        	int x = Integer.parseInt(st.nextToken()) -1;
        	int m = Integer.parseInt(st.nextToken());
        	int s = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	q.offer(new FireBall(r,x,m,d,s));
        }
        
        for(int z = 0 ; z < K ; z++) {
        	int size = q.size();
        	List<FireBall>[][] map = new ArrayList[N][N];
      
        	for(int i = 0 ; i < N ; i++) {
        		for(int j = 0 ; j < N ; j++) {
        			map[i][j] = new ArrayList<>();
        		}
        	}
        	for(int i = 0 ; i < size ; i++) {
        		FireBall fireball = q.poll();
        		int x = fireball.x;
        		int y = fireball.y;
        		int dir = fireball.dir;
        		int mass = fireball.mass;
        		int speed = fireball.speed;
    			x = (x+(dx[dir]*speed)+N*speed)%N;
        		y = (y+(dy[dir]*speed)+N*speed)%N;
        		map[x][y].add(new FireBall(x,y,mass,dir,speed));
        		
        	}
        	for(int i = 0 ; i < N ; i++) {
        		for(int j = 0 ; j < N ; j++) {
        			if(map[i][j].size()==1) {
        				FireBall fireball = map[i][j].get(0);
        				q.offer(new FireBall(fireball.x, fireball.y, fireball.mass, fireball.dir, fireball.speed));
        			}else if( map[i][j].size() > 1) {
        				int mass = 0;
        				int speed = 0;
        				char check = ' ';
        				int dir = 0;
        				int cnt = map[i][j].size();
        				int[][] dirArray = {{0,2,4,6},{1,3,5,7}};
        				for(int k = 0 ; k < map[i][j].size() ; k++) {
        					FireBall fireball = map[i][j].get(k);
        					mass+= fireball.mass;
        					speed+= fireball.speed;
        					if(check == ' ') {
        						if(fireball.dir%2==0) {
        							check = 'E';
        						}else {
        							check = 'O';
        						}
        					}else if(check == 'E' || check == 'O'){
        						if(fireball.dir%2==0) {
        							if(check != 'E') {
        								dir = 1;
        								check = 'X';
        							}
        						}else {
        							if(check != 'O') {
        								dir = 1;
        								check = 'X';
        							}
        						}
        					}
        				}
        				mass/=5;
        				speed/=cnt;
        				if(mass!=0) {
        					for(int l = 0 ; l < 4 ; l++) {
        						q.offer(new FireBall(i, j, mass, dirArray[dir][l], speed));
        					}
        				}
        			}
        		}
        	}
        }
        int result = 0;
        while(!q.isEmpty()) {
        	FireBall fireball = q.poll();
        	result+=fireball.mass;
        }
        System.out.println(result);
    }
   
}
