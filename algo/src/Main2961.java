import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2961 {
	static int res = 0;
	static int[] arrS;//신맛
	static int mulS = 1;
	static int[] arrB;//쓴맛
	static int sumB = 0;
	static int T;
	static int ctt = 0;
	static boolean[] count;
	static boolean changecnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		arrS = new int[T];
		arrB = new int[T];
		count = new boolean[T];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arrS[i] = Integer.parseInt(st.nextToken());
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		go(0);
		System.out.println(res);
		
	}
	static void go(int cnt) {
		if (cnt==T) {
			for (int i = 0; i < T; i++) {
				if (count[i]) {
					changecnt = true;//재료가 하나라도 들어가야
					mulS = mulS*arrS[i];
					sumB +=arrB[i];
				}
			}
			if (changecnt) {
				if (ctt==0) {
					res = Math.abs(mulS-sumB);
					ctt++;
				}else {
					if (res>Math.abs(mulS-sumB)) {
						res = Math.abs(mulS-sumB);
					}
				}
			}
			changecnt = false;
			mulS = 1;
			sumB = 0;
			return;
		}
		count[cnt]=true;
		go(cnt+1);
		count[cnt]=false;
		go(cnt+1);
	}
	
}
