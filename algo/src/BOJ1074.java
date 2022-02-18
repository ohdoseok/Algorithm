import java.util.Scanner;

public class BOJ1074 {
	static int cnt;
	static int N;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		sum = 0;
		int size = (int)Math.pow(2, N);
		go(X,Y,size);
		System.out.println(sum);
	}
	
	static void go(int x, int y, int size) {
		if (size==1) {
			return;
		}
		if (x>=size/2&&y>=size/2) {//4사분면
			sum+=((size/2)*(size/2))*3;//4사분면의 첫번째수
			go(x%(size/2),y%(size/2),size/2);
		}else if(x<size/2&&y>=size/2) {//2사분면
			sum+=((size/2)*(size/2));
			go(x%(size/2),y%(size/2),size/2);
		}else if(x>=size/2&&y<size/2) {//3사분면
			sum+=((size/2)*(size/2))*2;
			go(x%(size/2),y%(size/2),size/2);
		}else {//1사분면
			go(x%(size/2),y%(size/2),size/2);
		}
	}

}
