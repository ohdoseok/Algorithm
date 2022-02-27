import java.util.Scanner;

public class Main14696 {
	public static void main(String[] args) {//4321
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int cnt = 0;
			int[] arrA = new int[5];
			int[] arrB = new int[5];
			int a = sc.nextInt();
			for (int j = 0; j < a; j++) {
				arrA[sc.nextInt()]++;
			}
			int b = sc.nextInt();
			for (int j = 0; j < b; j++) {
				arrB[sc.nextInt()]++;
			}
			for (int j = 4; j >0; j--) {
				if (arrA[j]==arrB[j]) {
					cnt++;
					continue;
				}else if (arrA[j]>arrB[j]) {
					System.out.println('A');
					break;
				}else {
					System.out.println('B');
					break;
				}
			}
			if (cnt==4) {
				System.out.println('D');
			}
		}
	}
}
