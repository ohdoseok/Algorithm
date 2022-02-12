package comparator;

import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueueTest2 {
//	static Comparator comparator1 = new MyComparator();
//	static Comparator comparator2 = new MyComparator();
	static Comparator comparator = new Comparator<Integer>(){
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return -(o1 - o2); //Auto unBoxing
//			return o1.intValue() - o2.intValue(); //Auto unBoxing
		}
		
	};
	public static void main(String[] args) {
		//최소힙 구성
//		PriorityQueue<Integer> pq = new PriorityQueue<>();//기본적인 판정자
		//최대힙 변경
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(comparator); 
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
