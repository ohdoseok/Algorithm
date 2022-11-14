import java.util.*;
public class Main2750 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			pq.add(sc.nextInt());
		}
		int size= pq.size();
		for(int i = 0 ;  i < size ; i++) {
			
			System.out.println(pq.poll());
		}
	}
}
