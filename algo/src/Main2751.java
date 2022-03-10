
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer>list = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		for(int a : list) {
			sb.append(a);
		}
		System.out.println(sb);
	}
}
