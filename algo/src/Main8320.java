import java.util.Scanner;

public class Main8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < (N/i)+1; j++) {
				if (j>=i) {
					res++;
				}
			}


		}
		System.out.println(res);
	}
}
