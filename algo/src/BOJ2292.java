import java.util.Scanner;

public class BOJ2292 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if (N==1) {
			System.out.println(1);
		}else {
			go(2,0);
		}
		
	}
	static void go(int prenum, int i) {
		if (N>=prenum+6*i&&N<=(prenum+(6*(i+1))-1)+(6*i)) {
			System.out.println(i+2);
			return;
		}else {
			go(prenum+6*i,i+1);
		}
	}
}
