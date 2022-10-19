import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1920 {
	public static List<Long> Narray = new ArrayList<>();
	public static List<Long> Marray = new ArrayList<>();
	public static boolean check;
	public static int count;
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			Narray.add((long)sc.nextInt());
		}
		
		int M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			Marray.add((long)sc.nextInt());
		}
		
		Collections.sort(Narray);
		
		
		for (int i = 0; i < M; i++) {
			count = 0;
			check = false;
			half(0,N-1,i);
			if (check) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		
	}
	public static void half(int start, int end, int val) {
		if (count>Math.sqrt(N)) {
			check = false;
			return;
		}
		count++;
		int hf = (end-start)/2+start;
		if (Narray.get(start).equals(Marray.get(val))||Narray.get(end).equals(Marray.get(val))||Narray.get(hf).equals(Marray.get(val))) {
			check = true;
			return;
		}
		
		
		if (Narray.get(hf)>Marray.get(val)) {
			half(start,hf,val);
		}else {
			half(hf,end,val);
		}
	}
}
