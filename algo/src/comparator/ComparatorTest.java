package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorTest {
	static Mycomparator comparator = new Mycomparator();
	static class Mycomparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return -(o1-o2);
		}
		
	}
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);
		pq.offer(10);
		pq.offer(80);
		pq.offer(70);
		pq.offer(30);
		pq.offer(60);
		pq.offer(100);
		
		for (int i = 0; i < 6; i++) {
			System.out.println(pq.poll());
		}
	}
}
