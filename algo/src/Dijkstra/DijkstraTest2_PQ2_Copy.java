package Dijkstra;
/*
 * ============= 인접행렬 테스트케이스 

5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

output==> 8


6
0 3 5 0 0 0
0 0 2 6 0 0
0 1 0 4 6 0
0 0 0 0 2 3
3 0 0 0 0 6
0 0 0 0 0 0

output==> 12


10
0 4 6 0 0 0 0 0 0 0
0 0 0 9 8 0 0 0 0 0
0 3 0 0 2 3 0 0 0 0
0 0 0 0 0 0 6 0 0 0
0 0 0 2 0 1 3 7 0 0 
0 0 0 0 0 0 0 4 8 0
0 0 0 0 0 0 0 0 0 13
0 0 0 0 0 0 0 0 0 9
0 0 0 0 0 0 0 0 0 4
0 0 0 0 0 0 0 0 0 0


output ==> 21

============= 인접리스트 테스트케이스 
10 17
0 1 4
0 2 6
1 3 9
1 4 8
2 1 3
2 4 2
2 5 3
3 6 6
4 3 2
4 5 1
4 6 3
4 7 7
5 7 4
5 8 8
6 9 13
7 9 9
8 9 4

output ==> 21
 */
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
		int sum = 0;
		int start = 0;
		int[] minarr = new int[V];
		boolean[] visit = new boolean[V];
		// 시작정점에서 자신으로 오는 최소 비용
		// 최소 비용이 확정된 정점인지 판단 가능한 배열
		// 최소값을 LogE 시간내에 찾기 위한 자료구조 구현
		Arrays.fill(minarr, Integer.MAX_VALUE);
		//distance 배열을 최대값으로 초기화 하기

		//출발지 비용 0으로 설정
		minarr[start] = 0;
		//처음 자료를 우선 순위 큐에 넣어서 가장 먼저 나올 수 있도록 함
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		//모든 정점으로 연결되는 최소 비용구하기 위해서 정점 만큼 반복
		//중간에 목적지 도착하면 반복문 벗어나기
		//큐가 빌때까지 반복
		pq.add(new Vertex(start, minarr[start]));
		int cnt = 0;
		while(true){
			//단계 1: 최소 비용이 확정되지 않은 정점 중에 최소 비용의 정점 선택
			Vertex ver = pq.poll();
			//큐에나 나온 정점이 이미 최소비용으로 처리가 된 경우에는 뽑아 온 정점은 무시한다.
			int cur = ver.no;
			if (visit[cur]){
				continue;
			}
			
			sum=ver.minDistance;
			//현재 정점은 방문 처리
			visit[cur] = true;
			cnt++;
			if (cnt==V) {
				break;
			}
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
				if (minarr[j]>map[cur][j]+minarr[cur]) {
					minarr[j]=map[cur][j]+minarr[cur];
					pq.add(new Vertex(j, minarr[j]));
				}
			}
			
		}
		//출발점에서 모든 정점까지의 비용을 출력
		System.out.println(sum);
	}

}
