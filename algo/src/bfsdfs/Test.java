package bfsdfs;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
//		BFS makebfs = new BFS(size);
		DFS makedfs = new DFS(size);
		for (int i = 0; i < size; i++) {
//			makebfs.add((char)('A'+i));
			makedfs.add((char)('A'+i));
			
		}
//		makebfs.bfs();
		makedfs.dfs(1);
	}
}
