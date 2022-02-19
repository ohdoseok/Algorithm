import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2309 {
	static int[] arr;
	static int[] check;
	static boolean end;
	static ArrayList<Integer> res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		check = new int[7];
		res = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		search(0, 0);
		Collections.sort(res);
		for (int i = 0; i < 7; i++) {
			System.out.println(res.get(i));
		}
	}
	static void search(int cnt,int start) {
		if (cnt==7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum+=check[i];
			}
			if (sum==100&&end==false) {
				for (int i = 0; i < 7; i++) {
					res.add(check[i]);
					end=true;
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			check[cnt] = arr[i];
			search(cnt+1,i+1);
		}
	}
}
