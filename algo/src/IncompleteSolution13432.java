import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class IncompleteSolution13432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(rd.readLine());
		int[] resultS = new int[T+1];
		for (int testcase = 1; testcase < T+1; testcase++) {
			
			int result = -1;
			StringTokenizer st = new StringTokenizer(rd.readLine());
			int lastindex = Integer.parseInt(st.nextToken()); 
			int comA = Integer.parseInt(st.nextToken());
			int comB = Integer.parseInt(st.nextToken());
			int eachA = 0;
			int eachB = 0;
			
			
			for (int i = 2; i < Math.sqrt(comA)+1; i++) {
				if(comA%i==0) {
					eachA = i;
					break;
				}
			}
			for (int i = 2; i< Math.sqrt(comB)+1; i++) {
				if (comB%i==0) {
					eachB = i;
					break;
				}
			}
			//다했는데 eachAB가 0이면 자기자신이 약수다
			
			if (comA == 1 && comB == 1) {
				result = -1;
			}else if(comA == comB) {
				result = 0;
			}else {
				if (eachA==0&&eachB==0) {
					if (comA*comB<=lastindex) {
						result = 2;
					}else if(comA*2<=lastindex&& comB*2<=lastindex) {
						result = 3;
					}
				}else if(eachA==0){
					if (eachB==comA) {
						result = 1;
					}else if (eachB*comA<=lastindex) {
						result = 2;
					}
				}else if(eachB==0) {
					if(eachA == comB) {
						result = 1;
					}else if (eachA*comB<=lastindex) {
						result = 2;
					}
				}else {
					if (eachA==eachB) {
						result = 1;
					}else {
						if (eachA*eachB==comA||eachA*eachB==comB) {
							result = 1;
						}else if(comA/eachA==comB/eachB){
							result = 1;
						}else if (eachA*eachB<=lastindex) {
							result = 2;
						}
					}
				}
			}
			resultS[testcase] = result;
		}
		for (int i = 1; i < T+1; i++) {
			System.out.printf("#%d %d%n",i,resultS[i]);
		}
	}
}
