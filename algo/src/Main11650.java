import java.util.PriorityQueue;
import java.util.Scanner;

public class Main11650 {
	public static class PQ implements Comparable<PQ>{
		int X;
		int Y;
		public PQ(int X, int Y) {
			this.X = X;
			this.Y = Y;
		}
		
		@Override
		public int compareTo(PQ pq) {
			if (pq.X > this.X) {
				return -1;
			}else if(pq.X < this.X) {
				return 1;
			}else {
				if (pq.Y > this.Y) {
					return -1;
				}else {
					return 1;
				}
			}
		}
	}
	public static void main(String[] args) {
		PriorityQueue<PQ> pq = new PriorityQueue<>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			pq.add(new PQ(X,Y));
		}
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			PQ pq2 = pq.poll();
			System.out.println(pq2.X+" "+pq2.Y);
		}
		
		
		
	}
}
