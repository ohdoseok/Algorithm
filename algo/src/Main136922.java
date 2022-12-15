import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main136922 {
	public static int[] array = {1,5,10,50};
	public static Set<Integer> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		set = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0 ; i < 4 ; i++) {
			q.offer(array[i]);
		}

		for(int i = 0 ; i < N-1 ; i++) {
			int size1 = q.size();
			for(int k = 0 ; k < size1 ; k++) {
				int val = q.poll();
				if(q.contains(val)) {
					continue;
				}
				q.offer(val);
			}
			int size = q.size();
			for(int k = 0 ; k < size ; k++) {
				int val = q.poll();
				
				for(int j = 0 ; j < 4 ; j++) {
					q.offer(val+array[j]);
				}
			}
		}
		int res = 0;
		while(!q.isEmpty()) {
			int val = q.poll();
			if(!q.contains(val)){
				res++;
			}
		}
		System.out.println(res);
	}
}
