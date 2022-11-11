import java.util.*;

public class Main14719 {
	public static void main(String[] args) {
		//물은 왼쪽벽과 오른쪽벽으로 인해서 생성된다.
		
		Scanner sc = new Scanner(System.in);
		
		int high = sc.nextInt();
		int width = sc.nextInt();
		int res = 0;
		int[] array = new int[width];
		for(int i = 0 ; i < width ; i++) {
			array[i] = sc.nextInt();
		}
		for(int i = 1 ; i < width-1 ; i++) {
			int left = Integer.MIN_VALUE;
			int right = Integer.MIN_VALUE;
			int plus = 1;
			while(true) {
				if(i-plus>-1) {
					if(left<array[i-plus] && array[i-plus]>array[i]) {
						left = array[i-plus];
					}
				}
				if(i+plus<width) {
					if(right<array[i+plus] && array[i+plus]>array[i]) {
						right = array[i+plus];
					}
				}
				if(i-plus<0&&i+plus>=width) {
					break;
				}
				plus++;
			}
			if(left!=Integer.MIN_VALUE && right!=Integer.MIN_VALUE) {
				int comp = Math.min(left, right);
				res += comp-array[i];
			}
			
			
		}
		
		System.out.println(res);
	}
}
