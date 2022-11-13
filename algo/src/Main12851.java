import java.util.Arrays;
import java.util.*;

public class Main12851 {
	public static int min = Integer.MAX_VALUE;
	public static int res = 0;
	public static int[] check = new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int goal = sc.nextInt();
		if(start >= goal) {
			System.out.println(start-goal);
			System.out.println(1);
			return;
		}
		bfs(start,goal);
		System.out.println(min);
		System.out.println(res);
		
	}
	public static void bfs(int sum, int goal) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(sum);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(min < check[now]) {
				continue;
			}
			for(int i = 0 ; i < 3 ; i++) {
				
				int next;
				switch (i) {
				case 0:
					next = now+1;
					break;
				case 1:
					next = now-1;
					break;
				default:
					next = 2*now;
					break;
				}
				if(next < 0 || next > 100000) {
					continue;
				}
				
				
				if(next == goal) {
					if(check[now]+1 < min) {
						min = check[now]+1;
						res = 1;
					}else if(check[now]+1 == min) {
						res++;
					}
				}
				if(check[next]==0||check[next] == check[now]+1) {
					q.offer(next);
					check[next] = check[now]+1;
				}
				
				
			}
		}
		
	}
}
