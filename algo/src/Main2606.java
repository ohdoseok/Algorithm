import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2606 {
	static int N;
	static int T;
	static int rst = 0;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		arr = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (find(from)>find(to)) {
				arr[find(from)]=arr[find(to)];
			}else {
				arr[find(to)]=arr[find(from)];
			}
		}
		
		for (int i = 2; i < N+1; i++) {
			if (find(arr[i])==1) {
				rst++;
			}
		}
		
		System.out.println(rst);
	}
	
	static int find(int n) {
		if(arr[n]==n) {
			return n;
		}else {
			n = find(arr[n]);
		}
		
		return n;
	}
}
