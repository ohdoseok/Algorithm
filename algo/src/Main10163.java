import java.util.Scanner;

public class Main10163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[]  res = new int[T+1];
		int[][]map = new int[1001][1001];
		for (int i = 1; i < T+1; i++) {
			int startx = sc.nextInt();
			int starty = sc.nextInt();
			int plusx = sc.nextInt();
			int plusy = sc.nextInt();
			for (int j = startx; j < startx+plusx; j++) {
				for (int k = starty; k < starty+plusy; k++) {
					map[j][k] = i;
				}
			}
		}
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (map[i][j]!=0) {
					res[map[i][j]]++;
				}
			}
		}
		for (int i = 1; i < T+1; i++) {
			System.out.println(res[i]);
		}
		
	}
}
