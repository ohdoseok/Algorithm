import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] res = new int[T+1];
		for (int i = 1; i < T+1; i++) {
			int C = Integer.parseInt(br.readLine());
			int street = 0;
			int V = 0;
			for (int j = 1; j < C+1; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int acc = 0;
				if (command!=0) {
					acc = Integer.parseInt(st.nextToken());
				}
				switch (command) {
				case 0:
					street += V;
					break;
				case 1:
					V+=acc;
					street+= V;
					break;
				case 2:
					if (V-acc<0) {
						V = 0;
					}else {
						V-=acc;
						street+=V;
					}
					break;
				}
				
			}
			res[i] = street;
		}
		for (int i = 1; i < res.length; i++) {
			System.out.printf("#%d %d%n",i,res[i]);
		}
	}
}
