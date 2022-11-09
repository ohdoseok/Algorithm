import java.util.Scanner;

public class Main10870 {
	public static void main(String[] args) {
		int n2 = 0;
		int n1 = 1;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		if(T == 0) {
			System.out.println(0);
		}else if(T==1) {
			System.out.println(1);
		}else {
			for(int i = 2 ; i <= T ; i++) {
				int tmp = n2+n1;
				n2 = n1;
				n1 = tmp;
			}
			System.out.println(n1);
		}
		
	}
}
