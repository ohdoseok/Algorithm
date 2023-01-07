import java.util.*;
public class Programmers다리를자니는트럭 {
	
	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        Queue<Integer> q = new LinkedList<>();
	        int sum = 0;
	        int res = 0;
	        for(int i = 0 ; i < bridge_length ; i++){
	            q.offer(0);
	        }
	        for(int i = 0 ; i < truck_weights.length ; i++){
	            int val = truck_weights[i];
	            sum-=q.poll();
	            res++;
	            if(val+sum > weight){
	                q.offer(0);
	                for(int j = 0 ; j < bridge_length; j++){
	                    sum-=q.poll();
	                    res++;
	                    if(val+sum <= weight){
	                        break;
	                    }else{
	                        q.offer(0);
	                    }
	                }
	            }
	            q.offer(val);
	            sum+=val;
	        }
	        while(!q.isEmpty()){
	            q.poll();
	            res++;
	        }
	        return res;
	    }
	}
}
