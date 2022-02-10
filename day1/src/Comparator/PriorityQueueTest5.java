package Comparator;

import java.util.PriorityQueue;

public class PriorityQueueTest5 {
	public static void main(String[] args) {
		//번호, 점수
		PriorityQueue<Data> pq = new PriorityQueue<>();
//		PriorityQueue<Data> pq = new PriorityQueue<>
//		((o1,o2) -> -(o1.jum - o2.jum));
		pq.offer(new Data(3,80));
		pq.offer(new Data(7,80));
		pq.offer(new Data(4,80));
		pq.offer(new Data(9,90));
		pq.offer(new Data(1,80));
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println("end");
	}

}
class Data implements Comparable{
	//번호 오름차순으로 뽑아서 사용해야지
	int num;
	int jum;
	public Data(int num, int jum) {
		super();
		this.num = num;
		this.jum = jum;
	}
	@Override
	public String toString() {
		return "Data [num=" + num + ", jum=" + jum + "]";
	}
	@Override
	public int compareTo(Object o) {
		Data other = (Data)o;
		
		return this.jum == other.jum?(this.num - other.num):-(this.jum - other.jum);
//		return (this.jum - other.jum);
////		return -(this.num - other.num);
	}
}
