import java.util.Scanner;

public class Main5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int num = 1000 - A;
		int res = 0;
		int nam = 0;
		try {
			res = num/500;
			nam = num%500;

			res += nam/100;
			nam = nam%100;
			
			res += nam/50;
			nam = nam%50;
			
			res += nam/10;
			nam = nam%10;
			
			res += nam/5;
			nam = nam%5;
			
			res += nam/1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println(res);
	}
}
