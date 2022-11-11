import java.util.*;

public class BOJ1260 {
	public static StringBuilder sbdfs = new  StringBuilder();
	public static StringBuilder sbbfs = new  StringBuilder();
	public static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();
		check = new boolean[N+1];
		int[][] map = new int[N+1][N+1];
		for(int i = 0 ; i < M ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y]++;
			map[y][x]++;
		}
		dfs(start,map);
		System.out.println(sbdfs.substring(0,sbdfs.length()-1));
		check = new boolean[N+1];
		q.offer(start);
		while(!q.isEmpty()) {
			int top = q.poll();
			if(check[top]) {
				continue;
			}
			
			sbbfs.append(top+" ");
			check[top] = true;
			for(int i = 1 ; i < N+1 ; i++) {
				if(check[i]) {
					continue;
				}
				if(map[top][i]!=0) {
					q.offer(i);
				}
			}
		}
		System.out.println(sbbfs.substring(0,sbbfs.length()-1));
		
	}
	public static void dfs(int num,int[][] map) {
		check[num] = true;
		sbdfs.append(num+" ");
		for(int i = 1 ; i < map.length ; i++) {
			if(check[i]) {
				continue;
			}
			if(map[num][i]!=0) {
				dfs(i,map);
			}
		}
	}
}
