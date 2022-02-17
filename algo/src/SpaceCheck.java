import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class SpaceCheck {//0으로된 정사각형의 숫자와 1로된 정사각형의 숫자를 찾는다.
	static int white;
	static int black;
	static int[][] map;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		white = 0;
		black = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		div(0,0,N);
		System.out.printf("0의 정사각형 : %d 1의 정사각형 : %d",white,black);
		
	}
	
	static void div(int y, int x, int size) {
		int sum = 0;
		for (int i = y; i < size+y; i++) {
			for (int j = x; j < size+x; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0) {
			white++;
		}else if(sum==size*size) {
			black++;
		}else {
			div(y,x,size/2);//좌상
			div(y,size/2+x,size/2);//우상
			div(size/2+y,x,size/2);//좌하
			div(size/2+y,size/2+x,size/2);//우하
		}
	}
}
