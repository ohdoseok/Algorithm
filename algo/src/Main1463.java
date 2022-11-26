import java.util.*;

public class Main1463 {
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dfs(N,0);
		System.out.println(min);
	}
	
	public static void dfs(int num, int cnt) {
		if(num<1 || cnt > min) {
			return;
		}
		if(num == 1) {
			if(min > cnt) {
				min = cnt;
			}
			return;
		}
		if(num%3==0) {
			dfs(num/3,cnt+1);
		}
		if(num%2==0) {
			dfs(num/2,cnt+1);
		}
		dfs(num-1,cnt+1);
	}
}
