import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7964 {
	static int[] arr;
	static int num;
	static int dis;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			arr = new int[num+2];
			arr[0] = 1;
			arr[num+1] = 1;
			dis = Integer.parseInt(st.nextToken());
			res = 0;
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 1; i < num+1; i++) {
				arr[i] = st2.nextToken().charAt(0)-'0';
			}
			int cnt = 0;
			for (int i = 0; i < num+1; i++) {
				if (arr[i]==1) {
					cnt = 0;
				}else {
					cnt++;
					if (cnt>=dis) {
						arr[i] = 1;
						cnt=0;
						res++;
					}
				}
			}
			
			System.out.printf("#%d %d%n",testcase,res);
		}
	}
}
