import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		List<Integer>list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=0 ; i < W ; i++) {
			q.offer(-1);
		}
		int res = 0;
		while(!q.isEmpty()) {
			int val = q.poll();
			if(val > 0) {
				L+=val;
			}
			if(list.size()>0) {
				if(list.get(0)<=L) {
					q.offer(list.get(0));
					L-=list.get(0);
					list.remove(0);
				}else {
					q.offer(-1);
				}
			}
			res++;
		}
		System.out.println(res);
	}
}
