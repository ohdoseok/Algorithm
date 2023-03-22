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
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Node> q = new LinkedList<>();
		int goalX = 0;
		int goalY = 0;
		for(int i = 0 ; i < 2 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(i==1) {
				goalX = Integer.parseInt(st.nextToken());
				goalY = Integer.parseInt(st.nextToken());
			}else {
				q.offer(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		int[] dx2 = {-1,-1,-1,1,1,1,1,-1};
		int[] dy2 = {-1,1,1,1,1,-1,-1,-1};
		int res = 0;
		boolean findK = false;
		exit:
		while(!q.isEmpty()) {
			int size = q.size();
			res++;
			for(int qSize = 0 ; qSize < size ; qSize++) {
				Node node = q.poll();
				
				//상하좌우 
				for(int i = 0 ; i < 4 ; i++) {
					int x = node.x;
					int y = node.y;
					if(x+dx[i]<0 || x+dx[i]>=10 || y+dy[i]<0 || y+dy[i]>=9) {
						continue;
					}
					x += dx[i];
					y += dy[i];
					if(goalX == x && goalY == y) {
						continue;
					}
					//상하좌우 분기점을 기반으로 대각선 이동 
					for(int j = 0 ; j < 2 ; j++) {
						boolean ok = true;
						int tmpX = x;
						int tmpY = y;
						//동일한 방향의 대각선으로 2번이동 
						for(int k = 0 ; k < 2 ; k++) {
							tmpX += dx2[i*2+j];
							tmpY += dy2[i*2+j];
							//벗어나면 사라져야함 
							if(tmpX<0 || tmpX>=10 || tmpY<0 || tmpY>=9 ) {
								ok = false;
								break;
							}
							//가는도중에 다른 기물을 만나면 사라져야함 
							if(k==0 && goalX == tmpX && goalY == tmpY) {
								ok = false;
								break;
							}
							//마지막인데 왕을 만나면 잡고 끝 
							if(k==1 && goalX == tmpX && goalY == tmpY) {
								findK = true;
								break exit;
							}
						}
						//왕을 잡지도 않았고 남아있다면 큐에 저장 
						if(ok) {
							q.offer(new Node(tmpX,tmpY));
						}
					}
					
				}
				
			}
		}
		if(findK) {
			System.out.println(res);
		}else {
			System.out.println(-1);
		}
	}
		
}