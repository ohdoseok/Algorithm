import java.util.*;
import java.io.*;



public class Main
{
	static boolean[] visit;
	static boolean[] tmpVisit;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ori = br.readLine();
		
		visit = new boolean[ori.length()];
		List<String> list = new ArrayList<>();
		for(int i = 1 ; i < ori.length()+1 ; i++) {
			list.clear();
			tmpVisit = new boolean[ori.length()];
			for(int j = 0 ; j < visit.length ; j++) {
				tmpVisit[j] = visit[j];
			}
			dfs(ori,list,i,i-1);
			System.out.println(list.get(0));
		}
		
	}
	public static void dfs(String ori, List<String> list, int goal , int cnt ) {
		if(goal == cnt) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < tmpVisit.length ; i++) {
				if(tmpVisit[i]) {
					sb.append(ori.charAt(i));
				}
			}
			list.add(sb.toString());
			Collections.sort(list);
			String val = list.get(0);
			if(sb.toString().equals(val)) {
				for(int i = 0 ; i < tmpVisit.length ; i++) {
					visit[i] = tmpVisit[i];
				}
			}
			list.clear();
			list.add(val);
			return;
		}
		for(int i = 0 ; i < tmpVisit.length ; i++) {
			if(tmpVisit[i]) {
				continue;
			}
			tmpVisit[i] = true;
			dfs(ori,list,goal,cnt+1);
			tmpVisit[i] = false;
		}
	}
		
}