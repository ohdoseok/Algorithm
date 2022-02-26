import java.util.Scanner;

public class Main3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		boolean[] v = new boolean[42];
		int res = 0;
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt()%42;
			v[arr[i]] = true;
		}
		for (int i = 0; i < 42; i++) {
			if(v[i]) res++;
		}
		System.out.println(res);
	}
}
