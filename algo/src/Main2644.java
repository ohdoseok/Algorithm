import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2644 {
	static int[] arr;
	static int res;
	static List<Integer> list;
	public static void main(String[] args) {
		list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			arr[i] = i;
		}
		res = 0;
		int comA = sc.nextInt();
		int comB = sc.nextInt();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int P = sc.nextInt();
			int C = sc.nextInt();
			unionset(P,C);
		}
		check(comA);
		resultcheck(comB);
		System.out.println(res);
	}
	static boolean unionset(int a, int b) {
		int roota = findset(a);
		int rootb = findset(b);
		if (roota == rootb) {
			return false;
		}
		arr[rootb]=a;
		
		return true;
	}
	static int findset(int a) {
		if (arr[a]==a) {
			return a;
		}
		return findset(arr[a]);
	}
	static void check(int a) {
		list.add(a);
		if (arr[a]==a) {
			return;
		}
		check(arr[a]);
		
	}
	static void resultcheck(int a) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)==a) {
				res+=i;
				return;
			}
			if (arr[a]==a&&i==list.size()-1) {
				res=-1;
				return;
			}
		}
		res++;
		resultcheck(arr[a]);
	}
}
