import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main20055 {
	static class Node{
		int val;
		boolean robot;

		public Node(int val, boolean robot){
			this.val = val;
			this.robot = robot;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Node[] node = new Node[2*N];
		for (int i = 0; i < 2*N; i++) {
			node[i] = new Node(sc.nextInt(),false);
		}

		int count = 0;
		int start = 0;
		while(true) {
			//1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			Node tmpnode1 = node[0];
			Node tmpnode2;
			for (int i = 0; i < node.length; i++) {
				if (i+1>=2*N) {
					node[0] = tmpnode1;
				}else {
					tmpnode2 = node[i+1];
					node[i+1] = tmpnode1;
					tmpnode1 = tmpnode2;
					
				}
				if (i==N-1) {
					if (node[i].robot) {
						node[i].robot = false;
					}
				}
			}
			// 2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다
			for (int i = 1; i < N+1; i++) {
				if(node[N-i+1].val!=0 && node[N-i].robot && !node[N-i+1].robot) {
					node[N-i+1].robot = true;
					if (i==2) {
						node[N-i+1].robot = false;
					}
					node[N-i].robot = false;
					node[N-i+1].val-=1;
					if (node[N-i+1].val == 0) {
						count++;
					}
					
				}
			}
			//3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if (node[0].val!=0) {
				node[0].robot = true;
				node[0].val-=1;
				if (node[0].val == 0) {
					count++;
				}
			}
			start++;
			if (count>=K) {
				break;
			}
			
		}
		System.out.println(start);
	}
}
