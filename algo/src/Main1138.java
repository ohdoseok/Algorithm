import java.util.Scanner;

public class Main1138 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N];
		for(int i = 1 ; i <= N ; i++) {
			int index = sc.nextInt();
			int cnt = 0;
			for(int j = 0 ; j < N ; j++) {
				if(array[j]!=0) {
					continue;
				}
				if(cnt==index) {
					array[j]=i;
				}
				cnt++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int val : array) {
			sb.append(val+" ");
		}
		String res = sb.substring(0,sb.length()-1);
		System.out.println(res);
	}
}
