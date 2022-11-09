import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2309{
	public static boolean[] check;
	public static boolean ok;
	public static List<Integer> list2;
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < 9 ; i++) {
			list.add(sc.nextInt());
		}
		ok = false;
		check = new boolean[9];
		list2 = new ArrayList<Integer>();
		dfs(list,0,0);
		Collections.sort(list2);
		for(int i = 0 ; i < list2.size() ; i++) {
			System.out.println(list2.get(i));
		}
	}
	public static void dfs(List<Integer> list , int cnt, int sum) {
		if(ok) {
			return;
		}
		if(cnt == 7) {
			if(sum==100) {
				for(int i = 0 ; i < check.length ; i++) {
					if(check[i]) {
						list2.add(list.get(i));
					}
				}
				ok = true;
			}
			
			return;
		}
		for(int i = 0 ; i<9 ; i++) {
			if(check[i]) {
				continue;
			}
			check[i] = true;
			dfs(list, cnt+1,sum+list.get(i));
			check[i] = false;
		}
	}
}
