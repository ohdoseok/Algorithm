import java.util.Scanner;

public class Main3040 {
	static int[] arr;
	static boolean[] check;
	static int sum;
	static int[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		check = new boolean[9];
		sum = 0;
		res = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		go(0);
		for (int i = 0; i < 9; i++) {
			if (res[i]!=0) {
				System.out.println(res[i]);
			}
		}
	}
	static void go(int cnt) {
		if (cnt==7) {//7개가 모여서
			if (sum==100) {//100이되면 
				for (int i = 0; i < check.length; i++) {
					if (check[i]) {//true인 곳을
						res[i]=arr[i];//결과에 입력
					}
				}
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (check[i]) {//true면 이전에 선택된 숫자
				continue;
			}
			sum+=arr[i];//합계에 더해줌
			check[i]=true;
			go(cnt+1);
			check[i]=false;
			sum-=arr[i];
		}
	}
}