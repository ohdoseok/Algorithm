import java.util.Scanner;

public class Main16953 {
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		//하나의경우만으로도 되는지 확인해야하기때문에 완탐
		Scanner sc = new Scanner(System.in);
		long from = sc.nextInt();
		long to = sc.nextInt();
		dfs(from,to,1);
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
		
	}
	public static void dfs(long from , long to, int cnt) {
		if(to < from) {
			return;
		}else if(from == to) {
			if(min > cnt) {
				min = cnt;
				return;
			}
		}
		for(int i = 0 ; i < 2 ; i++) {
			if(i==0) {
				dfs(from*2,to,cnt+1);
			}else {
				dfs(from*10+1,to,cnt+1);
			}
		}
	}
}
