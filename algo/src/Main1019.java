import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] matrix = new char[N][M];
		for (int i = 0; i < N; i++) {
			String A = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = A.charAt(j);
			}
		}
		int result = Integer.MAX_VALUE;
		int count1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i+7>=N||j+7>=M) {
					continue;
				}
				for (int j2 = 0; j2 < 8; j2++) {
					for (int k = 0; k < 8; k++) {
						
						if (j2%2 == 0) {
							if (k%2 == 0) {
								if (matrix[i+j2][j+k]=='B') {
									count1++;
								}
							}else {
								if (matrix[i+j2][j+k]=='W') {
									count1++;
								}
							}
						}else {
							if (k%2 == 0) {
								if (matrix[i+j2][j+k]=='W') {
									count1++;
								}
							}else {
								if (matrix[i+j2][j+k]=='B') {
									count1++;
								}
							}
								
						}
					}
				}
				if (result > count1) {
					result = count1;
				}
				count1 = 0;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i+7>=N||j+7>=M) {
					continue;
				}
				for (int j2 = 0; j2 < 8; j2++) {
					for (int k = 0; k < 8; k++) {
						
						if (j2%2 == 0) {
							if (k%2 == 0) {
								if (matrix[i+j2][j+k]=='W') {
									count1++;
								}
							}else {
								if (matrix[i+j2][j+k]=='B') {
									count1++;
								}
							}
						}else {
							if (k%2 == 0) {
								if (matrix[i+j2][j+k]=='B') {
									count1++;
								}
							}else {
								if (matrix[i+j2][j+k]=='W') {
									count1++;
								}
							}
								
						}
					}
				}
				if (result > count1) {
					result = count1;
				}
				count1 = 0;
			}
		}
		
		System.out.println(result);
	}
}
