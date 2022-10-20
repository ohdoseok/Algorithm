import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Programmers네트워크 {
	public static void main(String[] args) {
		
	}
	
	class Solution {
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        Queue<Integer> q = new LinkedList<>();
	        boolean[] check =  new boolean[n];
	        for(int i = 0 ; i < computers.length ; i++)        {
	            if(check[i]){
	                continue;
	            }
	            for(int j = 0 ; j < computers[i].length ; j++){
	                if(check[j]){
	                    continue;
	                }
	                q.offer(j);
	                while(!q.isEmpty()){
	                    int N = q.poll();
	                    if(check[N]){
	                        continue;
	                    }
	                    check[N] = true;
	                    for(int k = 0 ; k < computers[N].length ; k++){
	                        if(check[k]){
	                            continue;
	                        }
	                        if(computers[N][k]==1){
	                            q.offer(k);
	                        }
	                    }
	                }
	                answer++;
	            }
	        }
	        
	        
	        return answer;
	    }
	}
}
