import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i < T+1; i++) {
			int res = 0;
			char[] comarr = br.readLine().toCharArray();
			int[] arr = new int[comarr.length];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = comarr[j]-'0';
			}
			
			int[] com = new int[arr.length];
			for (int j = 0; j < arr.length; j++) {
				if (arr[j]!=com[j]) {
					res++;
					for (int k = j; k < com.length; k++) {
						if (arr[j]==1) {
							com[k]=1;
						}else {
							com[k]=0;
						}
					}
				}
			}
			System.out.printf("#%d %d%n",i,res);
		}
	}
}
