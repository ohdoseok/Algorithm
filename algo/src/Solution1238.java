import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1238 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testcase = 1; testcase < 11; testcase++) {
			int[][] map = new int[101][101];
			boolean[] arr = new boolean[101];
			Queue<Integer> q = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				map[Integer.parseInt(st2.nextToken())][Integer.parseInt(st2.nextToken())]=1;
			}
			List<Integer> list = new ArrayList<>();
			q.offer(start);
			arr[start] = true;
			while(!q.isEmpty()) {
				list.clear();
				int size = q.size();
				for (int k = 0; k < size; k++) {
					int tstart = q.poll();
					list.add(tstart);
					for (int i = 1; i < 101; i++) {
						if(map[tstart][i]==1&&!arr[i]){
							q.offer(i);
							arr[i] = true;
						}
					}
				}
				
			}
			int tmp= 0;
			for (int i = 0; i < list.size(); i++) {//가장 큰수 결정
				if (tmp<list.get(i)) {
					tmp = list.get(i);
				}
			}
			System.out.printf("#%d %d%n",testcase,tmp);
			
			
		}


	}
}
