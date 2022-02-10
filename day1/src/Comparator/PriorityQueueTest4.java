package Comparator;

import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueueTest4 {
	public static void main(String[] args) {
		//		PriorityQueue<Integer> pq = new PriorityQueue<>(
		//			(Integer o1, Integer o2) ->{
		//				return -(o1 - o2); //Auto unBoxing
		//		}); 
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> -(o1 - o2)); 
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
