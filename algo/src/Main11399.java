import java.util.Arrays;
import java.util.Scanner;

public class Main11399 {
	static int T;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		arr = new int[T];
		int res = 0;
		int sum = 0;
		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < T; i++) {
			res += arr[i];
			sum +=res;
		}
		System.out.println(sum);
	}
}
