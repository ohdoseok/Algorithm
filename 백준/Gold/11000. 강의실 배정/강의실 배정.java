import java.io.*;
import java.util.*;
public class Main {
	static class Node{
		int start;
		int end;
		Node(int start, int end){
			this.start = start;
			this.end = end;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>(N, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.start == o2.start) {
					return o1.end - o2.end;
				}else{
					return o1.start-o2.start;
				}
			}
		});

		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

		}
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		pq2.offer(0);
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int val = pq2.peek();
			if(val<=node.start) {
				pq2.poll();
			}
			pq2.offer(node.end);

		}
		System.out.println(pq2.size());
	}

}
