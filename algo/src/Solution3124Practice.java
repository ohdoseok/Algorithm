import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3124Practice {
	static class Node implements Comparable<Node>{
		int node;
		int weight;
		 Node(int node, int weight){
			 this.node = node;
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
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			boolean[] visit = new boolean[V+1];
			ArrayList<Node>[] list = new ArrayList[V+1];
			for (int i = 1; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list[A].add(new Node(B, weight));
				list[B].add(new Node(A, weight));
			}
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(1, 0));
			Node node;
			long res = 0;
			int cnt = 0;
			while(!pq.isEmpty()) {
				node = pq.poll();
				int cur = node.node;
				if (visit[cur]) {
					continue;
				}
				
				res+=(long)node.weight;
				cnt++;
				if (cnt==V) {
					break;
				}
				visit[cur] = true;
				for (Node n : list[cur]) {
					if (visit[n.node]) {
						continue;
					}
					
					pq.offer(new Node(n.node, n.weight));
				}
				
			}
			System.out.printf("#%d %d%n",testcase,res);
			
			
			
			
			
		}
	}
}
