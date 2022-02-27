import java.util.Scanner;

public class Solution1493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase < T+1; testcase++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int[] arr = new int[2];
			int i = 1;
			int sum = 0;
			boolean ca = true;
			boolean cb = true;
			while(true) {
				sum+=i;
				if (a<=sum&&ca) {
					int front = sum-i;
					int order = a-front;
					int ten = 1+(order-1);
					int one = i-(order-1);
					arr[0]+=ten;
					arr[1]+=one;
					ca = false;
				}
				if (b<=sum&&cb) {
					int front = sum-i;
					int order = b-front;
					int ten = 1+(order-1);
					int one = i-(order-1);
					arr[0]+=ten;
					arr[1]+=one;
					cb = false;
				}
				if (!ca&&!cb) {
					break;
				}
				i++;
				
			}
			int total = arr[0]+arr[1];
			int realtotal = 0;
			int check = total-1;
			int cnt = 1;
			for (int j = 1; j < total-1; j++) {
				realtotal+=j;
			}
			while(!(check == arr[1])) {
				check--;
				cnt++;
			}
			System.out.printf("#%d %d%n",testcase,realtotal+cnt);
		}
	}
}
