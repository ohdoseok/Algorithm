import java.util.Scanner;

public class Solution2806 {
	static int N;
	static int[] arr;
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase < T+1; testcase++) {
			N = sc.nextInt();
			res = 0;
			arr = new int[N+1];
			go(1);//1행
			System.out.printf("#%d %d%n",testcase,res);
		}
	}
	static void go(int start) {
		if (start>N) {//체크를 다하면서 끝까지 왔기때문에 최종값에 추가가능
			res++;
			return;
		}
		for (int i = 1; i < N+1; i++) {
			arr[start] = i;//start행에1~N까지 N개 체크
			if (check(start)) {//다음에 넘어가는 친구를 확인해보고 넘어갈수있으면
				go(start+1);
			}
		}
	}
	static boolean check(int start) {//다음넘어가는 행이 
		for (int i = 1; i < start; i++) {
			if (arr[i]==arr[start]) {
				return false;
			}
			if (start-i==Math.abs(arr[start]-arr[i])) {
				return false;
			}
		}
		return true;
	}
}
