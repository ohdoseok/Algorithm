import java.util.*;
public class Programmers가장큰수 {
	
	class Solution {
	    public String solution(int[] numbers) {
	        PriorityQueue<String> pq = new PriorityQueue<>((o1,o2)->{
	            return (o2+o1).compareTo(o1+o2);
	        });
	        for(int A : numbers){
	            pq.offer(Integer.toString(A));
	        }
	        StringBuilder sb = new StringBuilder();
	        if(pq.peek().equals("0")){
	            return "0";
	        }
	        while(!pq.isEmpty()){
	            sb.append(pq.poll());
	        }
	        
	        return sb.toString();
	    }
	}
}
