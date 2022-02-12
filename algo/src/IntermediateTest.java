import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntermediateTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			int sum = 0;
			int cnt = Integer.parseInt(br.readLine());
			char[][] arrC = new char[cnt][cnt];
			for (int i = 0; i < cnt; i++) {
				arrC[i] = br.readLine().toCharArray();
			}
			for (int i = 0; i < arrC.length; i++) {
				for (int j = 0; j < arrC[i].length; j++) {
					if (arrC[i][j]=='A') {
						if (i-1>=0) {
							arrC[i-1][j]='X';
						}
						if (j+1<cnt) {
							arrC[i][j+1]='X';
						}
						if (i+1<cnt) {
							arrC[i+1][j]='X';
						}
						if (j-1>=0) {
							arrC[i][j-1]='X';
						}
					}
					if (arrC[i][j]=='B') {
						for (int k = 1; k < 3; k++) {
							if (i-k>=0) {
								arrC[i-k][j]='X';
							}
							if (j+k<cnt) {
								arrC[i][j+k]='X';
							}
							if (i+k<cnt) {
								arrC[i+k][j]='X';
							}
							if (j-k>=0) {
								arrC[i][j-k]='X';
							}
						}
					}
					if (arrC[i][j]=='C') {
						for (int k = 1; k < 4; k++) {
							if (i-k>=0) {
								arrC[i-k][j]='X';
							}
							if (j+k<cnt) {
								arrC[i][j+k]='X';
							}
							if (i+k<cnt) {
								arrC[i+k][j]='X';
							}
							if (j-k>=0) {
								arrC[i][j-k]='X';
							}
						}
					}
				}
				
				
			}
			for (int i = 0; i < arrC.length; i++) {
				for (int j = 0; j < arrC.length; j++) {
					if (arrC[i][j]=='H') {
						sum++;
					}
				}
			}
			System.out.printf("#%d %d%n",testcase,sum);
		}
	}
}
