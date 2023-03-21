import java.util.*;
import java.io.*;



public class Main
{
	static class Node implements Comparable<Node>{
		String val;
		String alpa;
		int num;
		Node(String val){
			this.val = val;
			String[] array = val.split("-");
			alpa = array[0];
			num = Integer.parseInt(array[1]);
		}
		@Override
		public int compareTo(Node node) {
//			return this.alpa.equals(node.alpa)?this.alpa.compareTo(node.alpa):this.num - node.num;
			if(this.alpa.equals(node.alpa)) {
				return this.num - node.num;
			}else {
				return this.alpa.compareTo(node.alpa);
			}
		}
		
	}
	//전략 :모두 정렬된 pq를 만들고 하나씩 뽑으면서 맞는사람이 나올때 까지 대기줄로 넣는다. 만약 해당 사람이 대기줄 제일앞이나 밖에 있다면 입장시킨다.
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//순서대로나와야하는 값 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//줄서는 줄은 스택 
		Stack<Node> lineStack = new Stack<>();
		//입력받는 값은 일반큐 
		Queue<Node> inputQueue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++) {
				String val = st.nextToken();
				pq.offer(new Node(val));
				inputQueue.offer(new Node(val));
			}
		}
		String res = "GOOD";
		while(!pq.isEmpty()) {
			if(lineStack.size() == 0) {
				Node node = inputQueue.poll();
				if(pq.peek().val.equals(node.val)) {
					pq.poll();
				}else {
					lineStack.add(node);
				}
			}else {
				Node node;
				if(inputQueue.isEmpty()) {
					node = lineStack.peek();
					if(pq.peek().val.equals(node.val)) {
						pq.poll();
						lineStack.pop();
					}else {
						res = "BAD";
						break;
					}
				}else {
					node = inputQueue.peek();
					if(pq.peek().val.equals(node.val)) {
						pq.poll();
						inputQueue.poll();
					}else {
						if(lineStack.peek().val.equals(pq.peek().val)) {
							lineStack.pop();
							pq.poll();
						}else {
							node = inputQueue.poll();
							lineStack.push(node);
						}
					}
				}
				
			}
		}
		if(!pq.isEmpty()) {
			res = "BAD";
		}
		System.out.println(res);
	}
}