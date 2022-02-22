import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution3289 {
	static int[] arr;
	static int P;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			for (int i = 1; i < N+1; i++) {
				arr[i] = i;
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int check = Integer.parseInt(st2.nextToken());
				int to = Integer.parseInt(st2.nextToken());
				int from = Integer.parseInt(st2.nextToken());
				if (check==0) {
					unionSet(to,from);
				}else if(check == 1) {
					if(findSet(from)==findSet(to)) {
						sb.append(1);
					}
//					if (arr[to]==arr[P]) {
//						sb.append(1);
//					}else {
//						sb.append(0);
//					}
					else {
						sb.append(0);
					}
				}
			}
			System.out.printf("#%d %s%n",testcase,sb);
		}
	}
//	static void findP(int i) {
//		if (arr[i]==i) {
//			P=i;
//			return;
//		}
//		findP(arr[i]);
//		arr[i] = P;
//	}
	static boolean unionSet(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) {
            return false;
        }
        arr[bRoot] = aRoot; 
        return true;
    }
    static int findSet(int a) {
        if(a == arr[a]) {
            return a;
        }
        arr[a] = findSet(arr[a]);
        return arr[a];
    }
}
