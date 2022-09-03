import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main16947 {
	public static boolean resultcheck;
	public static int[] result;
	public static boolean[] check;
	public static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		arr = new ArrayList[testcase+1];
		check = new boolean[testcase+1];
		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int firstnum = Integer.parseInt(st.nextToken());
			int secnum = Integer.parseInt(st.nextToken());
			arr[firstnum].add(secnum);
			arr[secnum].add(firstnum);
			
		}
		
	}
	
	public static void dfs(int num, int prenum) {
		if (result[num]==1) {
			resultcheck = true;
			return;
		}
		for (int i = num; i < check.length; i++) {
			for (int j = 0; j < arr[i].size(); j++) {
				if (arr[i].get(j)!=prenum) {
					result[i]=1;
					dfs(arr[i].get(j),i);
				}
				if (!resultcheck) {
					result[i]=0;
				}
			}
			if(prenum!=0) {
				return;
			}
			if (resultcheck) {
				return;
			}
		}
	}
}
