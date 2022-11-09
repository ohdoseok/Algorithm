import java.util.Scanner;

public class Main1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt = 0;
		for(int i = 0 ; i < T ; i++) {
			int n = sc.nextInt();
			boolean check = false;
			for(int j = 2 ; j < n ; j++) {
				if(n%j==0) {
					check = true;
					break;
				}
			}
			if(n!=1 && !check) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
