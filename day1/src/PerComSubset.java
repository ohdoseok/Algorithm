//순열은 n개중에서 r개를 선택한다. r개중 첫번째도 n개중에서 선택 r개중 2번째도 n개중에서 선택 하지만 첫번째 선택한 n을 제외하고 선택해야한다.
//다음 예제는 순서를 제대로 지정해서 배열에 넣어주지 않아서 1 2 다음 1 3 다음 2 1이 나와야 하지만 순서의 오류로 1 2로 출력된다 다음과 같은 코드를 수정하기 위해서는 반복문중에 먼저 나온 값을 r의 배열에 입력해 줘야한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PerComSubset {
		static int N;
		static int R;
		static int[] arrN;
		static int[] arrR;
		static boolean[] arrB;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		arrN = new int[N];
		arrR = new int[R];
		arrB = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i <N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		go(0);
		
	}
	static void go(int cnt) {
		if (cnt == R) {
			for (int i = 0; i < arrB.length; i++) {
				if (arrB[i]) {
					System.out.printf("%d ",arrN[i]);
				}
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {//매번 자리수마다 n개만큼 반복해줘서 하나 뽑는데 하나 뽑은게 그전에 뽑은거면 안된다.
			if (arrB[i]) {
				continue;
			}
			
			arrB[i] = true;
			go(cnt+1);
			arrB[i] = false;
		}
	}
}
