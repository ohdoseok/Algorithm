package comparator;
import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private char[] nodes;
	private int SIZE; //최대 크기는 변경되지 않는 상수
	private int lastIndex;
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new char[size+1]; //1 index부터 사용함으로 size + 1 생성 필요

	}
	public boolean isEmpty() {
		return lastIndex == 0; // 하나도 입력이 안되면 lastIndex값은 초기값 0
	}
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	public void add(char e) {
		if(isFull()) {
			System.out.println("더 이상입력 안됨");
			return;
		}
		lastIndex++;
		nodes[lastIndex] = e;
	}

	public void bfs2() { // 너비 단위 업무처리
		if(isEmpty()) {
			System.out.println("출력 정보 없음");
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		int level = 0;
		while(!q.isEmpty()) {

			//같은 너비들만 탐색(할일)처리== 같은 행에 처리
			int size = q.size();
			System.out.print("level : " + level + " => ");
			for(int i =0; i < size; i++) {
				int cur = q.poll();
				System.out.print(nodes[cur] + " ");


				//왼쪽 자식 있으면 추가
				if(cur*2 <= lastIndex) {
					q.offer(cur*2);
				}
				//오른쪽 자식 있으면 추가
				if(cur*2 + 1 <= lastIndex) {
					q.offer(cur*2 + 1);
				}
			}
			System.out.println();
			level++;
		}

	}
	public void bfs() {
		if(isEmpty()) {
			System.out.println("출력 정보 없음");
			return;
		}
		//완전탐색(할일)
		//무조건 큐 자료 구조를 활용한다.
		//자료구조
		//선형 = > Iterator  =>  정렬된 데이터 탐색 BineraySearch
		//재귀에서 매번 변경되는 자료 관리 => 매개변수 => DFS
		//BFS에 매변 변경되는 자료를 관리 = > 클래스
		Queue<Integer> q = new LinkedList<>();
		//		Queue<new int[] {1,2}> q = new LinkedList<>();
		//무조건  첫번째 할일을 무조건 큐에 삽입한다.
		q.offer(1);

		//큐가 빌 때까지 탐색(할일)을 진행한다. 재귀 사용 안함.
		while(!q.isEmpty()) {
			// 큐에서 무조건 첫번째 탐색(할일)을 뽑아 낸다.
			int cur = q.poll();
			//그 탐색(할일)을 진행한다.

			//현재 위치의 문자를 출력하라.

			//현재위치에서 마지막 할일이 끝났으면(목표위치 찾음)
			//break로 while 벗어나게 한다.
			System.out.println(nodes[cur]);
			//현재위치에서 마지막 할일이 끝났으면(목표위치 찾음)
			//break로 while 벗어나게 한다.


			//나와 연결되어서 나중에 해야할일을 큐에 삽입한다.			
			//왼쪽 자식 있으면 추가
			if(cur*2 <= lastIndex) { //재귀호출
				q.offer(cur*2);
			}
			//오른쪽 자식 있으면 추가
			if(cur*2 + 1 <= lastIndex) {
				q.offer(cur*2 + 1);
			}
		}

	}
	public void dfsByPreOrder() {
		System.out.println("dfsByPreOrder");
		dfsByPreOrder(1);
		System.out.println();
	}
	public void dfsByInOrder() {
		System.out.println("dfsByInOrder");
		dfsByInOrder(1);
		System.out.println();
	}
	public void dfsByPostOrder() {
		System.out.println("dfsByPostOrder");
		dfsByPostOrder(1);
		System.out.println();
	}
	private  void dfsByPreOrder(int cur) { //배열에서 현재 위치
		if(cur > lastIndex) {
			return;
		}
		//현재 노드 탐색(할일) 처리
		System.out.print(nodes[cur] + " ");

		//다음 노드 처리 
		dfsByPreOrder(cur*2);
		dfsByPreOrder(cur*2 + 1);
	}
	private  void dfsByPostOrder(int cur) { //배열에서 현재 위치
		if(cur > lastIndex) {
			return;
		}
		//다음 노드 처리 
		dfsByPostOrder(cur*2);		
		dfsByPostOrder(cur*2 + 1);

		//현재 노드 탐색(할일) 처리
		System.out.print(nodes[cur] + " ");
	}
	private  void dfsByInOrder(int cur) { //배열에서 현재 위치
		if(cur > lastIndex) {
			return;
		}
		//다음 노드 처리 
		dfsByInOrder(cur*2);
		//현재 노드 탐색(할일) 처리
		System.out.print(nodes[cur] + " ");
		dfsByInOrder(cur*2 + 1);
	}
	//	private  void dfsByPreOrder(int cur) { //배열에서 현재 위치
	//		//현재 노드 탐색(할일) 처리
	//		System.out.print(nodes[cur] + " ");
	//		
	//		//다음 노드 처리 
	//		if(cur*2 <= lastIndex) { //재귀호출
	//			dfsByPreOrder(cur*2);
	//		}
	//		//오른쪽 자식 있으면 추가
	//		if(cur*2 + 1 <= lastIndex) {
	//			dfsByPreOrder(cur*2 + 1);
	//		}
	//	}

}
