import java.util.Scanner;

public class Main1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		StringBuilder sb= new StringBuilder();
		boolean[] check = new boolean[1000001];
		check[1]=true;
		for(int i = 2 ; i <= 1000000 ; i++) {
			for(int j = 2 ; j <= 1000000 ; j++) {
				int val = i*j;
				if(val>1000000) {
					break;
				}
						
				if(check[val]) {
					continue;
				}
				check[val] = true;
			}
		}
		for(int i = M ; i <=N ; i++) {
			if(!check[i]) {
				sb.append(i);
				sb.append("\n");
			}
		}
		String res = sb.substring(0,sb.length()-1);
		System.out.println(res);
	}
}
