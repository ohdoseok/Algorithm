package comparator;

import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueueTest3 {
	public static void main(String[] args) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>(comparator); 
//		PriorityQueue<Integer> pq = new PriorityQueue<>(comparator); 
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return -(o1 - o2); //Auto unBoxing
			}
			
		}); 
		pq.offer(10);
		pq.offer(30);
		pq.offer(20);
		pq.offer(80);
		pq.offer(40);
		pq.offer(15);
		
//		System.out.println(pq);
		System.out.println(pq.poll());
//		System.out.println(pq);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());

	}

}
