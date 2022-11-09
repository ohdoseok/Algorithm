import java.util.*;
public class Main10818 {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			int T = sc.nextInt();
			if(T>max) {
				max = T;
			}
			if(T < min) {
				min = T;
			}
		}
		System.out.println(min+" "+max);
	}
}
