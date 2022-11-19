import java.util.*;
public class Main1966 {
	static class Node{
		int val;
		boolean now;
		public Node(int val, boolean now){
			this.val = val;
			this.now = now;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0 ; i < T ; i++) {
			int N = sc.nextInt();
			int now = sc.nextInt();
			int[] check = new int[10];
			Queue<Node> q = new LinkedList<>();
			int[] array = new int[N];
			for(int j = 0 ; j < N ; j++) {
				if(j==now) {
					int a = sc.nextInt();
					check[a]++;
					q.offer(new Node(a,true));
				}else {
					int a = sc.nextInt();
					check[a]++;
					q.offer(new Node(a,false));
				}
			}
			
			int cnt = 0;
			Loop1 :
				while(!q.isEmpty()) {
					Node node = q.poll();
					boolean ok = false;
					for(int j = node.val+1 ; j < check.length ; j++) {
						if(check[j]!=0) {
							ok = true;
							q.offer(node);
							break;
						}
					}
					if(!ok) {
						check[node.val]--;
						cnt++;
						if(node.now) {
							System.out.println(cnt);
							break Loop1;
						}
					}

				}
		}
		

	}
}
