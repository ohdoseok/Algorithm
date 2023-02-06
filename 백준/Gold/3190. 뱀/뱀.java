import java.io.*;
import java.util.*;
public class Main {
	static class SnakeNode{
		int x;
		int y;
		SnakeNode(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class TimeCount{
		int time;
		char dirct;
		TimeCount(int time, char dirct){
			this.time = time;
			this.dirct = dirct;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] map = new boolean[N+1][N+1];
		int K = sc.nextInt();
		for(int i = 0 ; i < K ; i++) {
			map[sc.nextInt()][sc.nextInt()] = true;
		}
		int L = sc.nextInt();
		Queue<TimeCount> q = new LinkedList<>();
		for(int i = 0 ; i < L ; i++) {
			q.offer(new TimeCount(sc.nextInt(), sc.next().charAt(0)));
		}
		List<SnakeNode> list = new ArrayList<>();
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		list.add(new SnakeNode(1,1));
		int dir = 0;
		int time = q.peek().time;
		int cnt = 1;
		exit:
		while(true) {
			//head
			SnakeNode snakenode = list.get(list.size()-1);
			//next X, Y
			//혹시나 맵에서 벗어나는지, 뱀과 부딪치는지 확인필요
			int X = snakenode.x+dx[dir];
			int Y = snakenode.y+dy[dir];
			if(X<=0 || X > N || Y<=0 || Y>N) {
				break;
			}
			for(SnakeNode snode: list) {
				if(snode.x == X && snode.y == Y) {
					break exit;
				}
			}
			list.add(new SnakeNode(snakenode.x+dx[dir],snakenode.y+dy[dir]));
			if(!map[X][Y]) {
				list.remove(0);
			}else {
				map[X][Y] = false;
			}
			if(cnt == time) {
				TimeCount timeCount = q.poll();
				switch(timeCount.dirct) {
					case 'L':
						dir = (dir-1+4)%4;
						break;
					case 'D':
						dir = (dir+1)%4;
						break;
				}
				if(!q.isEmpty()) {
					time = q.peek().time;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	
}
