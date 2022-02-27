import java.util.Scanner;

public class Main10158 {
	static int[] dy = {-1,-1,1,1};
	static int[] dx = {1,-1,-1,1};
	static int X;
	static int Y;
	static int T;
	static int startX;
	static int startY;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();//6
		Y = sc.nextInt();//4
		startX = sc.nextInt();//4
		startY = sc.nextInt();//1
		T = sc.nextInt();
		int a = startX+T;
		int b = startY+T;
		if ((a/X)%2==0) {
			a = a%X;
		}else {
			a = X-(a%X);
		}
		if ((b/Y)%2==0) {
			b = b%Y;
		}else {
			b = Y-(b%Y);
		}
		System.out.printf("%d %d",a,b);
		
	}
	
}
