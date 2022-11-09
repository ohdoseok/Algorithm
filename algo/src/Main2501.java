import java.util.*;

public class Main2501 {
	public static void main(String[] args) {
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean check = false;
		for(int i = 1 ; i<=N ; i++) {
			if(N%i==0) {
				cnt++;
				if(K==cnt) {
					System.out.println(i);
					check=true;
					break;
				}
			}
		}
		if(!check) {
			System.out.println(0);
		}
		
	}
}
