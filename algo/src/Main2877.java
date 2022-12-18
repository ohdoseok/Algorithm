import java.util.Scanner;

public class Main2877 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String val = Integer.toBinaryString(N+1);
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < val.length(); i++) {
			sb.append(val.charAt(i));
		}
		val = sb.toString();
		sb = new StringBuilder();
		for(int i = 0 ; i < val.length(); i++) {
			if(val.charAt(i)=='0') {
				sb.append('4');
			}else {
				sb.append('7');
			}
		}
		System.out.println(sb.toString());
	}
}
