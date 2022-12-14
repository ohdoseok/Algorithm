import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[] array = {1,5,10,50};
	public static Set<Integer> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		set = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dfs(0,N,0);
		System.out.println(set.size());
	}
	public static void dfs(int cnt, int N, int res) {
		
		if(cnt == N) {
			set.add(res);
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {
			if(set.contains(res+array[i])) {
				continue;
			}
			dfs(cnt+1,N,res+array[i]);
		}
	}
}
