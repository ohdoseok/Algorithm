import java.io.*;
import java.util.*;
public class Main {
	public static int res = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			int val = Integer.parseInt(br.readLine());
			if(val == 0) {
				if(pq.size()==0) {
					sb.append(0);
				}else {
					sb.append(pq.poll());
				}
				sb.append('\n');
			}else {
				pq.offer(val);
			}
		}
		String res = sb.substring(0,sb.length()-1 );
		System.out.println(res);
	}
}
