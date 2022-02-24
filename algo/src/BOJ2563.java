import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ2563{
		public static void main(String[] args) {
			char[][] map = new char[100][100];
			int res = 0;
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for (int testcase = 1; testcase < T+1; testcase++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						map[X+i][Y+j] = 'X'; 
					}
				}
				
			}
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if(map[i][j] == 'X') res++;
				}
			}
			System.out.println(res);
		}
	
}
