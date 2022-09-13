import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sun.applet.Main;

public class Main22864 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());//1시간 일하면 피로도
		int B = Integer.parseInt(st.nextToken());//1시간에 일하는 양
		int C = Integer.parseInt(st.nextToken());//1시간 쉬면 회복하는
		int M = Integer.parseInt(st.nextToken());//넘으면 안되는
		int max = 0;//쌓인 피로도
		int count = 0;
		for (int i = 0; i < 24; i++) {
			if (max+A<=M) {
				count+=B;
				max += A;
			}else {
				max-=C;
			}
		}
		System.out.println(count);
	}
	
	
	
}
