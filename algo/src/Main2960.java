import java.util.Scanner;

public class Main2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] check = new boolean[N+1];
		int res = 0;
		Loop1:
		for(int i = 2 ; i <= N ; i++) {
			if(check[i]) {
				continue;
			}
			int count = 1;
			while(true) {
				if(i*count>N) {
					break;
				}else {
					if(!check[i*count]) {
						check[i*count] = true;
						res++;
						if(res==K) {
							System.out.println(i*count);
							break Loop1;
						}
					}
					
					
				}
				count++;
				
			}
		}
	}
}
