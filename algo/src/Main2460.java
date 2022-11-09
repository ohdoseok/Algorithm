import java.util.Scanner;

public class Main2460 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int now = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < 10 ; i++) {
			int out = sc.nextInt();
			int in = sc.nextInt();
			now = now-out+in;
			if(max < now) {
				max = now;
			}
		}
		System.out.println(max);
	}
}
