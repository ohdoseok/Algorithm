import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	//시간초
	public static Queue<String> q;
	public static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		q= new LinkedList<>();
		int[] ori = new int[N];
		check = new boolean[N];
		int[] ori2 = new int[N];
		int cnt = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			ori[i] = Integer.parseInt(st.nextToken());
			ori2[i] = cnt;
			cnt++;
		}
		int[] array = new int[N];
		String ori11 = "";
		for(int a : ori) {
			ori11+=a+" ";
		}
		ori11 = ori11.substring(0,ori11.length()-1);
		dfs(0,array,N,ori2,ori11,false);
	}
	public static void dfs(int cnt, int[] array, int N, int[] ori, String ori11, boolean out) {
		if(out) {
			return;
		}
		if(cnt>=N) {
			String s = "";
			for(int a: array) {
				s+=a+" ";
			}
			s = s.substring(0,s.length()-1);
			if(s.equals(ori11)) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else {
					out = true;
					System.out.println(q.poll());
				}
			}else {
				q.offer(s);
			}
			
			return;
		}
			for(int j = 0 ; j < N ; j++) {
				
				if(check[j]) {
					continue;
				}
				if(array[cnt]<ori[j]) {
					continue;
				}
				array[cnt]=ori[j];
				check[j] = true;
				
				dfs(cnt+1, array, N , ori,ori11,out);
				check[j] = false;
			}
	}
}
