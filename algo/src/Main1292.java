import java.util.Scanner;

public class Main1292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		System.out.println(go(start,end,1,0,1,1));
	}
	public static int go(int start, int end, int cnt, int sum, int c, int cN) {
		if(cnt>=start) {
			sum+=c;
			if(cnt == end) {
				return sum;
			}
		}
		
		if(c==cN) {
			return go(start,end,cnt+1,sum,c+1,1);
		}else {
			return go(start,end,cnt+1,sum,c,cN+1);
		}
		
		
		
		
	}
}
