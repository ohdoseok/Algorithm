import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2164 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i < num+1; i++) {
			q.add(i);
		}
		boolean check = true;
		while(!q.isEmpty()) {
			if (q.size()==1) {
				break;
			}
			if (check) {
				q.poll();
				check = false;
			}else {
				int setA = q.poll();
				q.add(setA);
				check = true;
			}
		}

		System.out.println(q.poll());
	}
}
