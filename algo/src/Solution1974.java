import java.util.Scanner;

public class Solution1974 {
	static boolean[] Rcheck;
	static boolean[] Ccheck;
	static boolean[] check;
	static int[][] map;
	static int res;
	static int cnt;
	static int cnt2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase < T+1; testcase++) {
			Rcheck = new boolean[10];//0이면 초기화, 1이면 true, 2이면 false 세로 체크
			Ccheck = new boolean[10];//가로체크
			check = new boolean[9];
			cnt = 1;
			map = new int[9][9];
			res = 1;
			cnt2 = 1;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			checknine(0,0);
			if (res == 0) {
				System.out.printf("#%d %d%n",testcase,res);
			}else {
				checkall(0,0);
				System.out.printf("#%d %d%n",testcase,res);
			}
		}
	}
	static void checknine(int x, int y) {
		if (cnt>9) {
			return;
		}
		if (res==0) {
			return;
		}
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum+=map[x+i][y+j];
			}
		}
		if (sum!=45) {
			res=0;
		}else {
			if (y+3==9) {
				cnt++;
				checknine(x+3,0);
			}else {
				cnt++;
				checknine(x,y+3);
			}
		}
	}
	static void checkall(int x, int y) {//대각선으로 가면서 각각모든 행 열 check
		if (cnt2>9) {
			return;
		}
		if (res==0) {
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (Ccheck[map[x][i]]) {
				res = 0;
				break;
			}else {
				Ccheck[map[x][i]] = true;
			}
			if (Rcheck[map[i][y]]) {
				res = 0;
				break;
			}else {
				Rcheck[map[i][y]] = true;
			}
			
		}
		if (res!=0) {
			for (int i = 1; i < 10; i++) {
				Ccheck[i]=false;
				Rcheck[i]=false;
			}
		}
		cnt2++;
		checkall(x+1,y+1);
		
		
	}
}
