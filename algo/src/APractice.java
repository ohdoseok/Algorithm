import java.util.Arrays;
import java.util.Scanner;

//급하게 코드 테스트나 간단하게 구현해보고 지우는 class
public class APractice {
	public static void main(String[] args) {
		String a = "1 2 3 4 5";
		String[] b = a.split(" ");
		System.out.println(Arrays.toString(b));
		System.out.println(b.length);
	}
}
