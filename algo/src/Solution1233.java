//규칙 : 리프노드는 무조건 숫자여야한다. 자식이 하나라도있으면 노드는 무조건 사칙연산기호 이어야 한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i < 11; i++) {
			int check = 0;
			int N = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				String[] arr = br.readLine().split(" ");
				if (arr.length == 2) {
					if (arr[1].equals("-")||arr[1].equals("+")||arr[1].equals("/")||arr[1].equals("*")) {
						check++;
					}
				}
				if (arr.length == 4) {
					if (arr[1].equals("-")||arr[1].equals("+")||arr[1].equals("/")||arr[1].equals("*")) {
						
					}else {
						check++;
					}
				}
			}
			if (check==0) {
				System.out.printf("#%d %d",i,1);
			}else{
				System.out.printf("#%d %d",i,0);
			}
			System.out.println();
			
		}
	}
}
