import java.util.Scanner;

public class Main3460 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			int T = sc.nextInt();
			StringBuilder sb  = new StringBuilder();
			String S = Integer.toBinaryString(T);
			for(int j = 0 ; j < S.length() ; j++) {
				if(S.charAt(S.length()-j-1)=='1') {
					sb.append(j+" ");
				}
			}
			System.out.println(sb.substring(0,sb.length()-1));
		}
	}
}
