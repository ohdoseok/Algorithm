import java.util.Scanner;

public class Main10872 {
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		int N = sc.nextInt();
		long res = 1;
		if(N == 0) {
			System.out.println(res);
		}else {
			for(int i = 1; i <= N ; i++) {
				res*=i;
			}
			System.out.println(res);
		}
		
		
	}
}
