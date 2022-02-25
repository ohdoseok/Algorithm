import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3124 {
	static class Node implements Comparable<Node>{
		int to;
		int weight;

		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}


	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase < T+1; testcase++) {
			StringTokenizer st = null;
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());//정점수
			int E = Integer.parseInt(st.nextToken());//간선수
			boolean[] visit = new boolean[V+1];
			int[] minarr = new int[V+1];
			List<Node>[] list = new ArrayList[V+1];
			for (int i = 1; i < V+1; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list[from].add(new Node(to, weight));
				list[to].add(new Node(from, weight));
			}
			Arrays.fill(minarr, Integer.MAX_VALUE);
			minarr[1] = 0;
			PriorityQueue<Node> q = new PriorityQueue<>();
			q.offer(new Node(1, minarr[1]));
			Node node;
			int cnt =0;
			long res = 0;
			while(!q.isEmpty()){
				node = q.poll();
				int cur = node.to;
				if (visit[cur]) {
					continue;
				}
				res+= (long)node.weight;
				visit[cur] = true;


				for (Node n : list[cur]) {
					if (visit[n.to]) {
						continue;
					}
					q.offer(n);


				}


			}
			System.out.printf("#%d %d%n",testcase,res);
		}
	}
}
