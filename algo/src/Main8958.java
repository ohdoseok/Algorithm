import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < T; i++) {
			int tempres = 0;
			int res = 0;
			boolean check = false;
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j]=='O') {
					if (check) {
						tempres++;
					}
					res+=(1+tempres);
					check = true;
				}else if(arr[j] == 'X') {
					tempres = 0;
					check = false;
				}
			}
			System.out.println(res);
		}
	}
}
