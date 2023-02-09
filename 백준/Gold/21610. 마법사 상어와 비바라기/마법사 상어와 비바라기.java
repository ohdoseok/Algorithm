import java.io.*;
import java.util.*;
public class Main {
	//전략 : 구름정보를 Queue에 넣고 이동후에 정보를 Queue에 다시 넣고 물 증가 처리 후에 방문체크로 2상의구름 다시 만들어서 Queue에 넣
	//우,상,좌,하 
	static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
	static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
	static class Cloud{
		int x;
		int y;
		Cloud(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static class Node{
		int dir;
		int val;
		Node(int dir, int val){
			this.dir = dir;
			this.val = val;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//구름의 정보를 담을 큐 
		Queue<Cloud> q = new LinkedList<>();
		q.offer(new Cloud(N-1,0));
		q.offer(new Cloud(N-1,1));
		q.offer(new Cloud(N-2,0));
		q.offer(new Cloud(N-2,1));
		//구름 이동 방향과 이동 거리
		List<Node> list = new ArrayList<>();
		for(int i = 0 ; i < M ;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		for(int i = 0 ; i < list.size(); i++) {
			Node node = list.get(i);
			int dir = node.dir;
			int val = node.val;
			int size = q.size();
			boolean[][] check = new boolean[N][N];
			for(int j = 0 ; j < size ; j++) {
				Cloud cloud = q.poll();
				int x = cloud.x;
				int y = cloud.y;
				for(int k = 0 ; k < val ; k++) {
					x+=dx[dir];
					y+=dy[dir];
					if(x<0||x>=N || y < 0 || y >= N) {
						x = (x+N)%N;
						y = (y+N)%N;
					}
				}
				q.offer(new Cloud(x,y));
				map[x][y]+=1;
			}
			while(!q.isEmpty()) {
				Cloud cloud = q.poll();
				int x = cloud.x;
				int y = cloud.y;
				for(int j = 2 ; j < 9 ; j+=2) {
					if(x+dx[j]<0 || x+dx[j]>=N || y+dy[j]<0 || y+dy[j]>=N) {
						continue;
					}
					if(map[x+dx[j]][y+dy[j]]>0) {
						map[x][y]++;
					}
				}
				check[x][y]=true;
			}
			
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < N ; k++) {
					if(!check[j][k] && map[j][k]>1) {
						q.offer(new Cloud(j,k));
						map[j][k]-=2;
					}
				}
			}
		}
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ;j++) {
				res+=map[i][j];
			}
		}
		System.out.println(res);
	}
}
