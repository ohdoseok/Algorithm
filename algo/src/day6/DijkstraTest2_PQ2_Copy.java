package day6;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraTest2_PQ2_Copy {
	static int V;
	static int[][] map;
	static class Vertex implements Comparable<Vertex>{
		int no; //정점의 번호
		int minDistance; //출발지에서 자신으로의 최소 비용
		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}
		@Override
		public String toString() {
			return "Vertex [no=" + no + ", minDistance=" + minDistance + "]";
		}
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.minDistance - o.minDistance;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		map = new int[V][V];
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//다익스트라 구현
		// 시작 정점 지정
		int start = 0;
		int[] distance = new int[V];
		boolean[] visit = new boolean[V];
		// 시작정점에서 자신으로 오는 최소 비용
		// 최소 비용이 확정된 정점인지 판단 가능한 배열
		// 최소값을 LogE 시간내에 찾기 위한 자료구조 구현

		//distance 배열을 최대값으로 초기화 하기
		Arrays.fill(distance, Integer.MAX_VALUE);
		//출발지 비용 0으로 설정
		distance[start] = 0;
		//처음 자료를 우선 순위 큐에 넣어서 가장 먼저 나올 수 있도록 함
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.offer(new Vertex(start, distance[start]));
		//모든 정점으로 연결되는 최소 비용구하기 위해서 정점 만큼 반복
		//중간에 목적지 도착하면 반복문 벗어나기
		//큐가 빌때까지 반복
		while(!q.isEmpty()){
			//단계 1: 최소 비용이 확정되지 않은 정점 중에 최소 비용의 정점 선택
			Vertex ver = q.poll();
			int cur = ver.no;
			//큐에나 나온 정점이 이미 최소비용으로 처리가 된 경우에는 뽑아 온 정점은 무시한다.
			if (visit[cur]) {
				continue;
			}
			//현재 정점은 방문 처리
			visit[cur] = true;
			
			//단계 2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용르 수정
			for(int j = 0; j < V; j++) {
				//방문 정점 무시
				if (visit[j]) {
					continue;
				}
				//방문할 수 없는 정점은 무시
				if (map[cur][j]==0) {
					continue;
				}
				//최소 비용이 수정되어야 할 정점은 수정
				if (distance[j]>distance[cur]+map[cur][j]) {
					distance[j]=distance[cur]+map[cur][j];
					q.offer(new Vertex(j, distance[j]));
				}
			}
			
		}
		//출발점에서 모든 정점까지의 비용을 출력
		System.out.println(Arrays.toString(distance));
	}

}