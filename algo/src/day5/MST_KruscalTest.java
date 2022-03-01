package day5;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175
 */

public class MST_KruscalTest {

    static int N;
    static int[] p;
    static Edge[] list;
    static class Edge implements Comparable<Edge>{
        int from ,to;
        int weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.weight - o.weight;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  
        int E = sc.nextInt();// 총 간선의 갯수
        list = new Edge[E];
        for(int i = 0; i < E; i++) {
            list[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        //간선별 오름차순으로 정렬
        Arrays.sort(list);
        //Union -Find 알고리즘 으로 크루스칼 MST 비용 구하기
        makeSet();
        int res = 0;
        int cnt = 0;
        for(Edge edge : list) {
            if(unionSet(edge.from,edge.to)) {
                cnt++;
                res+= edge.weight;
            }
            if(cnt == N-1) {
                break;
            }
        }
        System.out.println(res);
        System.out.println(Arrays.toString(p));
    }
    static boolean unionSet(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if(a == b) {
            return false;
        }
        p[b] = a; 
        return true;
    }
    
    //a가 포함된 대표자 찾기
    static int findSet(int a) {
        if(a == p[a]) {  // a => 3 ,p[a] = 5;
            return a;
        }
        p[a] = findSet(p[a]); //경로 압축;
        return p[a]; // 현재 위치의 부모값 반환
    }
    //단위 집단 만들기
    static void makeSet() {
        p = new int[N]; //부모를 관리하는 배열
        //자신의 부모노드를 자신으로 설정
        for(int i =0; i < N; i++) {
            p[i] = i;
        }
    }
}