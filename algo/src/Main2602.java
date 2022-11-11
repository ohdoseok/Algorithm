import java.util.*;

public class Main2602 {
	public static void main(String[] args) {
		//연관관계를 2차원배열로 만들자 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int[][] map = new int[N+1][N+1];
		for(int i = 0 ; i < T ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		Queue<Integer> q = new LinkedList<>();
		boolean[] check = new boolean[N+1];
		q.offer(1);
		check[1]= true;
		while(!q.isEmpty()) {
			int com = q.poll();
			check[com] = true;
			for(int i = 1 ; i < N+1 ; i++) {
				if(check[i]) {
					continue;
				}
				if(map[com][i]==1) {
					q.offer(i);
					check[i] = true;
				}
			}
		}
		int cnt = 0;
		for(int i = 2 ; i < N+1 ; i++) {
			if(check[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
