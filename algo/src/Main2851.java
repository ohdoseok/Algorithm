import java.util.Scanner;

public class Main2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int res = 0;//com-1까지의 합
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
			if (res<100) {
				res+=arr[i];
			}
			if (res==100) {
				System.out.println(100);
				break;
			}
			if (res>100) {
				if (Math.abs(100-(res-arr[i]))>Math.abs(100-res)) {
					System.out.println(res);
					break;
				}else if(Math.abs(100-(res-arr[i]))<Math.abs(100-res)) {
					System.out.println(res-arr[i]);
					break;
				}else {
					System.out.println(res);
					break;
				}
			}
		}
		if (res<100) {
			System.out.println(res);
		}
		
	}
}
