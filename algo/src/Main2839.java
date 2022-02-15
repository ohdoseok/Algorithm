//5kg으로 옮기면 옮기는 수가 줄어들어서 최대의 무게로 옮기고 남은 무게를 3kg으로 옮기는데 나눠떨아지지않으면 5kg의 수를 하나씩줄여서 3kg을 늘려본다
import java.util.Scanner;

public class Main2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int fmok = 0;
		int tmok = 0;
		int res = -1;
		fmok = N/5;
		tmok = (N%5)/3;
		if ((N%5)%3 == 0) {
			res = fmok+tmok;
		}else {
			while(!(fmok==0)) {
				fmok--;
				if((N-(fmok*5))%3==0) {
					tmok = (N-(fmok*5))/3;
					res = fmok+tmok;
					break;
				}
			}
		}
		System.out.println(res);
	}
}
