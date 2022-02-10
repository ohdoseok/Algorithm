import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			int N = Integer.parseInt(br.readLine());
			String[] sta = new String[N/2+N%2];//홀수면 하나더많은 배열생성
			String[] stb = new String[N/2];
			String[] res = new String[N];//결과배열
 			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < sta.length; i++) {
				sta[i] = st.nextToken();
			}
			for (int i = 0; i < stb.length; i++) {
				stb[i] = st.nextToken();
			}
			for (int i = 0; i < N/2+N%2; i++) {
				if (N%2!=0&&i==(N/2+N%2)-1) {
					res[i*2] = sta[i];
				}else {
					res[i*2] = sta[i];
					res[i*2+1] = stb[i];
				}
				
			}
			System.out.printf("#%d ",testcase);
			for (int i = 0; i < res.length; i++) {
				System.out.printf("%s ",res[i]);
			}
			System.out.println();
		}
	}

}
