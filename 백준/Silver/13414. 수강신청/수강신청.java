import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int goal = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		LinkedHashSet<String> set = new LinkedHashSet<>();
		for(int i = 0 ; i < N ; i++) {
			String val = br.readLine();
			if(!set.contains(val)) {
				set.add(val);
			}else {
				set.remove(val);
				set.add(val);
			}
		}
		StringBuilder sb = new StringBuilder();
		Iterator<String> list = set.iterator();
		while(list.hasNext()) {
			String val = list.next();
			sb.append(val+"\n");
			goal--;
			if(goal==0) {
				break;
			}
		}
		String result = sb.substring(0,sb.length()-1);
		System.out.println(result);
	}
}
