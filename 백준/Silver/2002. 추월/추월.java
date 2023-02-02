import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] array = new String[N];
		for(int i = 0 ; i < N ; i++) {
			array[i] = br.readLine();
		}
		Queue<String> q = new LinkedList<>();
		for(int i = 0 ; i < N ; i++) {
			q.offer(br.readLine());
		}
		//int size = q.size();
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			if(q.contains(array[i])) {
				while(!q.isEmpty()) {
					String top = q.poll();
					if(top.equals(array[i])) {
						break;
					}else {
						cnt++;
					}
				}
			}
			
		}
		System.out.println(cnt);
		
	}
}
