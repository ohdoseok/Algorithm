import java.util.ArrayList;
import java.util.Scanner;

public class Main2563 {
	public static void main(String[] args) {
		int[][] arr = new int[101][101];//x나 y에 0이들어가는 배열은 안씀
		int result = 0;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x; j < 10+x; j++) {//x~x+10까지 
				for (int k = y; k < 10+y; k++) {//y~y+10까지
					arr[j][k] = 1;//100의 공간에 1로채움
				}
			}
		}
		for (int i = 1; i < 101; i++) {//1로 차있는 공간을 탐색
			for (int j = 0; j < 101; j++) {
				if (arr[i][j]==1) {
					result++;
				}
			}
		}

		System.out.println(result);
	}
}
