import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution4047 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			StringBuilder sb = new StringBuilder();
			boolean[] arrS = new boolean[14];
			int S = 0;
			boolean[] arrD = new boolean[14];
			int D = 0;
			boolean[] arrH = new boolean[14];
			int H = 0;
			boolean[] arrC = new boolean[14];
			int C = 0;
			char arr[] = br.readLine().toCharArray();
			for (int i = 0; i < arr.length; i=i+3) {
				if (arr[i]=='S') {
					if (arr[i+1]=='0') {
						if (arrS[arr[i+2]-'0']) {
							sb.append("ERROR");
							break;
						}
						arrS[arr[i+2]-'0']=true;
					}else {
						if (arrS[(arr[i+1]-'0')*10+(arr[i+2]-'0')]) {
							sb.append("ERROR");
							break;
						}
						arrS[(arr[i+1]-'0')*10+(arr[i+2]-'0')]=true;
					}
				}else if (arr[i]=='D') {
					if (arr[i+1]=='0') {
						if (arrD[arr[i+2]-'0']) {
							sb.append("ERROR");
							break;
						}
						arrD[arr[i+2]-'0']=true;
					}else {
						if (arrD[(arr[i+1]-'0')*10+(arr[i+2]-'0')]) {
							sb.append("ERROR");
							break;
						}
						arrD[(arr[i+1]-'0')*10+(arr[i+2]-'0')]=true;
					}
				}else if (arr[i]=='H') {
					if (arr[i+1]=='0') {
						if (arrH[arr[i+2]-'0']) {
							sb.append("ERROR");
							break;
						}
						arrH[arr[i+2]-'0']=true;
					}else {
						if (arrH[(arr[i+1]-'0')*10+(arr[i+2]-'0')]) {
							sb.append("ERROR");
							break;
						}
						arrH[(arr[i+1]-'0')*10+(arr[i+2]-'0')]=true;
					}
				}else if (arr[i]=='C') {
					if (arr[i+1]=='0') {
						if (arrC[arr[i+2]-'0']) {
							sb.append("ERROR");
							break;
						}
						arrC[arr[i+2]-'0']=true;
					}else {
						if (arrC[(arr[i+1]-'0')*10+(arr[i+2]-'0')]) {
							sb.append("ERROR");
							break;
						}
						arrC[(arr[i+1]-'0')*10+(arr[i+2]-'0')]=true;
					}
				}
			}
			if (sb.length()>0) {
				System.out.printf("#%d %s%n",testcase,sb);
			}else {
				for (int j = 1; j < 14; j++) {
					if (arrS[j]) {
						S++;
					}
					if (arrD[j]) {
						D++;
					}
					if (arrH[j]) {
						H++;
					}
					if (arrC[j]) {
						C++;
					}
				}
				System.out.printf("#%d %d %d %d %d%n",testcase,13-S,13-D,13-H,13-C);
			}
		}
	}
}