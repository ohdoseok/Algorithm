import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main11943 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = 0;
		int O = 0;
		for(int i = 0 ; i < 2 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(i == 1) {
				O += Integer.parseInt(st.nextToken());
				A += Integer.parseInt(st.nextToken());
			}else {
				A += Integer.parseInt(st.nextToken());
				O += Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(Math.min(A, O));
		
	}
}
