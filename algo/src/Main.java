import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static Queue<int[]> q = new LinkedList<>();
	public static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ori = new int[N];
		check = new boolean[N];
		int[] ori2 = new int[N];
		int cnt = 1;
		for(int i = 0 ; i < N ; i++) {
			ori[i] = sc.nextInt();
			ori2[i] = cnt;
			cnt++;
		}
		
		int[] array = new int[N];
		dfs(0,array,N,ori2);
		String res = "-1";
		while(!q.isEmpty()) {
			boolean checkB = false;
			int[] pollArray = q.poll();
			for(int j = 0 ; j < N ; j++) {
				System.out.print(pollArray[j]+" "+ori[j]);
				if(!pollArray.equals(ori)) {
					checkB = true;
					break;
				}
			}
			System.out.println();
			if(!checkB) {
				System.out.println(res);
				break;
			}
			res = String.valueOf(pollArray);
		}
		
		
	}
	public static void dfs(int cnt, int[] array, int N, int[] ori) {
		if(cnt==N) {
			q.offer(array);
			return;
		}
			for(int j = 0 ; j < N ; j++) {
				if(check[j]) {
					continue;
				}
				array[cnt]=ori[j];
				check[j] = true;
				
				dfs(cnt+1, array, N , ori);
				check[j] = false;
			}
		
	}
}
