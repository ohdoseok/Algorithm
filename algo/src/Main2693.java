import java.util.Arrays;
import java.util.Scanner;

public class Main2693 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0 ; i < T ; i++) {
			int[] array = new int[10];
			for(int j = 0 ; j < 10 ; j++) {
				array[j] = sc.nextInt();
			}
			Arrays.sort(array);
			System.out.println(array[7]);
		}
	}
}
