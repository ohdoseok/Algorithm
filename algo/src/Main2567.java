import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2567 {
	static class Vertex implements Comparable<Vertex>{
		int end;
		int weight;

		public Vertex(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());//정점의 개수
		int E = Integer.parseInt(st.nextToken());//간선의 개수
		int start = Integer.parseInt(br.readLine());
		int[] arr = new int[V+1];
		ArrayList<Vertex>[] list = new ArrayList[V+1];
		for (int i = 1; i < V+1; i++) {
			list[i] = new ArrayList<>();
		}
		boolean[] visit = new boolean[V+1];

		for (int i = 0; i <E; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		PriorityQueue<Vertex> q = new PriorityQueue<>();
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[start] = 0;
		q.offer(new Vertex(start, arr[start]));
		int cnt = 0;
		while(!q.isEmpty()) {
			Vertex ver = q.poll();
			int cur = ver.end;

			if (visit[cur]) {
				continue;
			}
			for (Vertex v : list[cur]) {
				if (arr[v.end]>arr[cur]+v.weight) {
					arr[v.end] = arr[cur] + v.weight;
					q.add(new Vertex(v.end, arr[v.end]));
				}
			}
		}


		for (int i = 1; i < arr.length; i++) {
			if (arr[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(arr[i]);
		}
	}
}
