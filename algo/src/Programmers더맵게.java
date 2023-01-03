import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.*;
public class Programmers더맵게 {
	public static void main(String[] args) {
		
		class Solution {
		    public int solution(int[] scoville, int K) {
		        PriorityQueue<Integer> pq = new PriorityQueue<>();
		        for(int val : scoville){
		            pq.offer(val);
		        }
		        int answer = 0;
		        while(pq.size()>1){
		            int val1 = pq.poll();
		            if(val1 >= K){
		                break;
		            }
		            int val2 = pq.poll();
		            int val = val1+val2*2;
		            pq.offer(val);
		            answer++;
		        }
		        if(pq.size()==1){
		            int val = pq.poll();
		            if(val < K){
		                answer = -1;
		            }
		        }
		        
		        return answer;
		    }
		}
	}
}
