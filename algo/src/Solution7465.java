import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution7465 {
	static int[] arr;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			check = new boolean[N+1];
			arr = new int[N+1];
			List<Integer> res = new ArrayList<Integer>();
			for (int i = 1; i < N+1; i++) {
				arr[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (findSet(a)!=findSet(b)) {
					unionSet(a,b);
				}
			}
			for (int i = 1; i < N+1; i++) {
				if (res.indexOf(arr[i])==-1) {
					res.add(arr[i]);
				}
			}
			System.out.printf("#%d %d%n",testcase,res.size());
		}
	}
	
	static boolean unionSet(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) {
            return false;
        }
        int x = arr[bRoot];
        arr[bRoot] = aRoot;
        for (int i = 1; i < arr.length; i++) {
			if(arr[i]==x) {
				arr[i] = arr[bRoot];
			}
		}
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
