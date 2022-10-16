import java.util.Scanner;

public class Main13458 {
	public static long[] array;
	public static long count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		count = 0;
		array = new long[N];
		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			long nam = array[i]-B;
			count++;
			if (nam>0) {
				count+=nam/C;
				if (nam%C!=0) {
					count++;
				}
			}
		}
		System.out.println(count);
		
	}
}
