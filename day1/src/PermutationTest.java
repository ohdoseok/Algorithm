import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest {//순열
	static int N,R;
	static int[] input, numbers;//input : 입력수배열, numbers : 선택수배열
	static boolean[] isSelected;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
			
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0);
	}
	
	//현재 자리에 수 뽑기
	public static void permutation(int cnt) {
		
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {//가지치기 선택이 되었다면? 넘어가라!
				continue;
			}
			
			numbers[cnt] = input[i];
			isSelected[i]=true;
			permutation(cnt+1);
			isSelected[i]=false;
		}
	}
}
