//테케만 통과
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] start;
	static int[] end;
	static int beer;
	static PriorityQueue<Info> pq;
	static class Info implements Comparable<Info>{
		private int x;
		private int y;
		
		
		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}


		@Override
		public int compareTo(Info o) {
			// TODO Auto-generated method stub
			return (Math.abs(start[0]-this.x)+Math.abs(start[1]-this.y))-Math.abs(start[0]-o.x)+Math.abs(start[1]-o.y);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 0; testcase < T; testcase++) {
			int fste = 0;
			start = new int[2];
			end = new int[2];
			beer = 20;
			String rst = "sad";
			pq = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				pq.offer(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			
			fste = Math.abs(start[0]-end[0]) + Math.abs(start[1]-end[1]);
			
			while (!pq.isEmpty()) {
				Info info = pq.poll();
				if (Math.abs(end[0]-info.x)+Math.abs(end[1]-info.y)<fste) {
					if(Math.abs(start[0]-info.x)+Math.abs(start[1]-info.y)<=1000) {
						start[0] = info.x;
						start[1] = info.y;
					}
				}
				if (Math.abs(end[0]-start[0])+Math.abs(end[1]-start[1])<=1000) {
					rst = "happy";
					break;
				}
			}
			
			System.out.println(rst);
			
		}
	}
}
