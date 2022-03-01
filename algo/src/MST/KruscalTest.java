package MST;

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
public class KruscalTest {
	static int[] p;
	static int N;
	static int T;
	static Node[] list;
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int weight;
		Node(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		p = new int[N];
		T = sc.nextInt();
		list = new Node[T];
		int res = 0;
		for (int i = 0; i < T; i++) {
			list[i] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		MakeNode();
		Arrays.sort(list);
		for (Node node : list) {
			if(unionset(node.from, node.to)) {
				res+=node.weight;
			}
			
		}
		System.out.println(res);
		
	}
	static void MakeNode() {
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
	}
	static int findset(int a) {
		if (p[a] == a) {
			return a;
		}
		
		return findset(p[a]);
	}
	static boolean unionset(int a, int b) {
		a = findset(a);
		b = findset(b);
		if (a==b) {
			return false;
		}
		
		p[a] = b;
		return true;
	}
}
