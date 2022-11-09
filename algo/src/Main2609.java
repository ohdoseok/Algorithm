import java.util.Scanner;

public class Main2609 {
	public static void main(String[] args) {
		int max=-1;
		int min=-1;
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		for(int i=Math.min(A, B) ; i >0  ; i--) {
			if(A%i==0 && B%i==0) {
				max = i;
				break;
			}
		}
		int cnt = 1;
		while(true) {
			if((Math.min(A, B)*cnt)%Math.max(A, B)==0) {
				min = Math.min(A, B)*cnt;
				break;
			}else {
				cnt++;
			}
		}
		System.out.println(max);
		System.out.println(min);
		
	}
}
