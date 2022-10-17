import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1260 {
	public static List<List<Integer>> Narray;
	public static boolean[] check;
	public static int M;
	public static int N;
	public static int start;
	public static StringBuilder dfsSB;
	public static StringBuilder bfsSB;
	public static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Narray = new ArrayList<>();
		M = sc.nextInt();
		check = new boolean[N+1];
		start = sc.nextInt();
		q = new LinkedList<>();
		
		for (int i = 0; i < N+1; i++) {
			Narray.add(new ArrayList<>());
		}
		
		
		for (int i = 0; i < M; i++) {
			int go = sc.nextInt();
			int end = sc.nextInt();
			Narray.get(go).add(end);
			Narray.get(end).add(go);
			Collections.sort(Narray.get(go));
			Collections.sort(Narray.get(end));
			
		}
		
		dfsSB = new StringBuilder();
		bfsSB = new StringBuilder();
		
		
		dfs(start);
		dfsSB.setLength(dfsSB.length()-1);
		System.out.println(dfsSB);
		
		
		q.offer(start);
		check = new boolean[N+1];
		bfs();
		bfsSB.setLength(bfsSB.length()-1);
		System.out.println(bfsSB);
		
	}
	
	
	public static void dfs(int i) {
		check[i] = true;
		dfsSB.append(i+" ");
		for (int j = 0; j < Narray.get(i).size(); j++) {
			if (check[Narray.get(i).get(j)]) {
				continue;
			}
			dfs(Narray.get(i).get(j));
		}
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			int top = q.poll();
			if (check[top]) {
				continue;
			}else {
				check[top] = true;
			}
			bfsSB.append(top+" ");
			for (int i = 0; i < Narray.get(top).size(); i++) {
				q.offer(Narray.get(top).get(i));
			}
			
		}
	}
}
