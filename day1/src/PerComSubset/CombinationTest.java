package PerComSubset;
import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {//조합 
	static int N,R;
	static int[] input, numbers;//input : 입력수배열, numbers : 선택수배열
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		combination(0, 0);
	}
	
	//현재 자리에 수 뽑기
	public static void combination(int cnt, int start) {
		
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i<N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
			
	}
}