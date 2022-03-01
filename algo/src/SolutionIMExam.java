import java.util.Scanner;

public class SolutionIMExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase < T+1; testcase++) {
			int N = sc.nextInt();
			int res = 0;
			int[][] map = new int[N][N];
			int[] dx = {-1,0,1,0};
			int[] dy = {0,1,0,-1};
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j]==2) {
						for (int k = 0; k < 4; k++) {
							int tmp = 1;
							while(true) {
								if ((i+(dx[k]*tmp)<0)||(i+(dx[k]*tmp)>=N)||(j+(dy[k]*tmp)<0)||(j+(dy[k]*tmp)>=N)) {
									break;
								}
								else if (map[i+dx[k]*tmp][j+dy[k]*tmp]==0) {
									map[i+dx[k]*tmp][j+dy[k]*tmp]=3;
								}
								else if (map[i+dx[k]*tmp][j+dy[k]*tmp]==1) {
									break;
								}
								
								++tmp;
							}
							
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j]==0) {
						res++;
					}
				}
			}
			System.out.printf("#%d %d%n",testcase,res);
		}
	}
}
