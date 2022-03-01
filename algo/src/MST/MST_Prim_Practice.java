package MST;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
 * 
 * 
 */


public class MST_Prim_Practice{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] map = new int[N][N];

		for(int i =0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//신장트리에 포함여부 판단 배열
		boolean[] visit = new boolean[N];
		//다른 정점에서 자신으로의 최소비용을 저장하는 배열 공간 선언 및 최대값으로 초기화
		int[] minV = new int[N];
		Arrays.fill(minV, Integer.MAX_VALUE);
		// MST 저장변수
		int result = 0;
		//임의의 정점을 시작점부터 발생하기 위함 처음 방문하는 지점 최소비용(0)으로 초기화
		minV[0] = 0;
		for(int c = 0; c < N; c++) { //모든 정점에서 연결해야 하는 최소갯수는 N-1
			//1.신장트리에 연결되지 않은 정점중에서 가장 유리한 정점을 선택
			int min = Integer.MAX_VALUE;
			int iV = 0;
			// 최소값을 가지고 있는 정점선택
			for(int i = 0; i < N; i++) {
				//이미 신장트리에 포함된 정점은 제외
				if (visit[i]) {
					continue;
				}
				// 최소비용배열에서 신장트리에 포함되지 않은 정정에서 최소 비용과 위치를 찾음
				if (min>minV[i]) {
					min=minV[i];
					iV = i;
				}
			}
			visit[iV] = true;
			result += min;
		
			
			//2. 선택된 정점을 신장트리에 포함 시킴
			
			// 그때 선택된 정점에 대한 최소 비용을 결과값에 저장
			
			
			//3. 방금 선택된 정점 기준으로 신장트리에 포함되지 않은 정점으로 연결된
			//   간선비용을 따져봐서 최소비용을 업데이트 함
			//   (이 부분이 정렬하지 않고 최소값으로 찾기 만으로 다음 정점을 선택함)
			for(int i = 0; i < N; i++) {
				//신장트리에 포함된 놈은 제외
				if (visit[i]) {
					continue;
				}
				
				 //연결되지 않은 정점은 무시
				if (map[iV][i]==0) {
					continue;
				}
				 //연결된 정점에서 최소값으로 갱신
				if (minV[i]>map[iV][i]) {
					minV[i]=map[iV][i];
				}
			}
		}
		//MST값 출력
		System.out.println(result);
		
	}

}