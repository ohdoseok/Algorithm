import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution3307 {
	static int T;
	static int N;
	static List<Integer> list;
	static List<Integer> rstlist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			N = Integer.parseInt(br.readLine());
			list  = new ArrayList<Integer>();
			rstlist = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int max = 0;
			int result = Integer.MIN_VALUE;
			for (int k = 0; k < N; k++) {
				int output = list.get(k);
				if (rstlist.size()==0||rstlist.get(rstlist.size()-1)<output) {
					
					rstlist.add(output);
					max++;
					if (result<max) {
						result=max;
					}
				}else {
					for (int i = 0; i < rstlist.size(); i++) {
						if(rstlist.get(i)>=output) {
							rstlist.set(i, output);
							break;
						}
					}
				}
			}
			System.out.printf("#%d %d",testcase,result);
			System.out.println();
			
			
			
		}
	}
}
