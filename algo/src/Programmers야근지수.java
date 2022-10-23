import java.util.*;

public class Programmers야근지수 {
	public static void main(String[] args) {
	}
	
	class Solution {
	    public long solution(int n, int[] works) {
	        long result = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        for(int v : works){
	            pq.offer(v);
	        }
	        while(n>0){
	            pq.offer(pq.poll()-1);
	            n--;
	        }
	        while(!pq.isEmpty()){
	            int val = pq.poll();
	            if(val < 0){
	                result = 0;
	                break;
	            }else{
	                result+=val*val;
	            }
	        }
	        
	        return result;
	    }
	}
}
