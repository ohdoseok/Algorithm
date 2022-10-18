import java.util.Arrays;
import java.util.Scanner;

public class Main11656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] result = new String[input.length()];
		for (int i = 0; i < result.length; i++) {
			result[i] = input.substring(i);
		}
		Arrays.sort(result);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
