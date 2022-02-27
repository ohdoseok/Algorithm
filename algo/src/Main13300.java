import java.util.Arrays;
import java.util.Scanner;

public class Main13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//학생수
		int K = sc.nextInt();//한방당 최대 인원
		int[] Marr = new int[7];
		int[] Garr = new int[7];
		int res = 0;
		for (int i = 0; i < N; i++) {//0여자 1남자
			int sex = sc.nextInt();
			int Y = sc.nextInt();
			if (sex==0) {
				Garr[Y]++;
			}else {
				Marr[Y]++;
			}
		}
		for (int i = 1; i < 7; i++) {
			if (Marr[i]%K==0) {
				res+=Marr[i]/K;
			}else {
				res+=(Marr[i]/K)+1;
			}
			if (Garr[i]%K==0) {
				res+=Garr[i]/K;
			}else {
				res+=(Garr[i]/K)+1;
			}
		}
		System.out.println(res);
	}
}
