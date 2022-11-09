import java.util.Scanner;

public class Main2581 {
	public static void main(String[] args) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		for(int i = start ; i<=end ; i++) {
			if(i == 1) {
				continue;
			}
			boolean check = false;
			for(int j = 2 ; j<i ; j++) {
				if(i%j==0) {
					check = true;
					break;
				}
			}
			if(!check) {
				if(min > i) {
					min = i;
				}
				sum+=i;
			}
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
