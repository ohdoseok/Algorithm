import java.util.*;

public class Main11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
			q.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt = 0;
		while(!q.isEmpty()) {
			int top = q.poll();
			cnt++;
			if(cnt==K) {
				sb.append(top+", ");
				cnt = 0;
			}else {
				q.offer(top);
			}
		}
		String res = sb.substring(0,sb.length()-2);
		res+=">";
		System.out.println(res);
	}
}
