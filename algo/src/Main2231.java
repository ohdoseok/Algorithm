import java.util.Scanner;

public class Main2231 {
	public static int goal;
	public static boolean OK;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		goal = sc.nextInt();
		int result = 0;
		for (int i = 1; i < 1000001; i++) {
			int ja = (int)Math.log10(i);
			int a = (int)Math.pow(10, ja);
			int res = i;
			int mok = i;
			for (int j = 0; j < ja+1; j++) {
				res += mok/a;
				mok = mok%a;
				if (a==10) {
					res+=mok;
					break;
				}
				a = a/10;
			}
			if (res == goal) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		
	}
	
}
