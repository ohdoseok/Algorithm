package day6;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraTest2_PQ {
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
        int start = 0; // 시작 정점 지정
        
        int[] distance = new int[V]; // 시작정점에서 자신으로 오는 최소 비용
        boolean[] v = new boolean[V]; // 최소 비용이 확정된 정점인지 판단 가능한 배열
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        //distance 배열을 최대값으로 초기화 하기
        Arrays.fill(distance, Integer.MAX_VALUE);
        //출발지 비용 0으로 설정
        distance[start] = 0;
        pq.offer(new Vertex(start, distance[start]));
        
        //모든 정점으로 연결되는 최소 비용구하기 위해서 정점 만큼 반복
        //중간에 목적지 도착하면 반복문 벗어나기
        //큐가 빌때까지 반복
        while(!pq.isEmpty()){
            //단계 1: 최소 비용이 확정되지 않은 정점 중에 최소 비용의 정점 선택
            Vertex cur = pq.poll();
            
            //큐에나 나온 정점이 이미 최소비용으로 처리가 된 경우에는 뽑아 온 정점은 무시한다.
            if(v[cur.no]) {
                continue;
            }
            
            //현재 정점은 방문 처리
            v[cur.no] = true;
            
            //단계 2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용르 수정
            for(int j = 0; j < V; j++) {
                //방문 정점 무시
                if(v[j]) {
                    continue;
                }
                
                //방문할 수 없는 정점은 무시
                if(map[cur.no][j] == 0) {
                    continue;
                }
                //최소 비용이 수정되어야 할 정점은 수정
                if(distance[j] > distance[cur.no] + map[cur.no][j]) {
                    distance[j] = distance[cur.no] + map[cur.no][j];// 비용을 업데이트 한다
                    //우선 순위 큐에 넣어준다.
                    pq.offer(new Vertex(j, distance[j] ));
                }
            }
            
        }
        System.out.println(Arrays.toString(distance));

    }

}