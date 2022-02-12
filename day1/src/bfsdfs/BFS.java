package bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private int SIZE;
	private char[] arr;
	private int lastindex;
	BFS(int size){
		this.SIZE = size;
		arr = new char[size+1];
	}
	public boolean isEmpty() {
		return lastindex==0;
	}
	public boolean isFull(){
		return lastindex==SIZE;
	}
	public void add(char value) {
		if (isFull()) {
			System.out.println("꽉차서 추가 불가능!");
			return;
		}
		lastindex++;
		arr[lastindex] = value;
	}
	
	
	public void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		if (q.isEmpty()) {
			System.out.println("출력할 값이 없습니다 add로 추가해주세요");
			return;
		}
		while(!q.isEmpty()) {
			int standard = q.poll();
			if (standard*2<=lastindex){
				q.offer(standard*2);
			}
			if (standard*2+1<=lastindex) {
				q.offer(standard*2+1);
			}
			System.out.println(arr[standard]);
		}
		
	}
}
