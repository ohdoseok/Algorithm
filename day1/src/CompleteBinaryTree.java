import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private int SIZE;
	private char[] nodes;
	private int lastindex;
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new char[size+1];
	}
	public boolean isEmpty() {
		return lastindex==0;
	}
	public boolean isFull() {
		return lastindex==SIZE;
	}
	public void add(char c) {
		if (isFull()) {
			System.out.println("꽉차서 채울수가 없어요!");
			return;
		}
		lastindex++;
		nodes[lastindex] = c;
	}
	public void bfs() {
		if (isEmpty()) {
			System.out.println("출력할게 없어요!");
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while(!q.isEmpty()) {
			int idx = q.poll();
			System.out.println(nodes[idx]);
			if (idx*2<=lastindex) {
				q.offer(idx*2);
			}
			if (idx*2+1<=lastindex) {
				q.offer(idx*2+1);
			}
		}
	}
}
