import java.util.*;

public class Programmers이중우선순위큐 {
	public static void main(String[] args) {
		
	}
	class Solution {
	    public int[] solution(String[] operations) {
	        List<Integer> pq = new ArrayList<>();
	        
	        for(String Sa : operations){
	            char first = Sa.charAt(0);
	            if(first == 'I'){
	                int insertInt = Integer.parseInt(Sa.substring(2));
	                pq.add(insertInt);
	            }else if(first == 'D'){
	                if(Sa.substring(2).equals("1")){
	                    Collections.sort(pq,Collections.reverseOrder());
	                    if(!pq.isEmpty()){
	                        pq.remove(0);
	                    }
	                }else{
	                    Collections.sort(pq);
	                    if(!pq.isEmpty()){
	                        pq.remove(0);
	                    }
	                }
	            }
	        }
	        int max;
	        int min;
	        Collections.sort(pq,Collections.reverseOrder());
	        if(pq.size()==0){
	            max = 0;
	        }else{
	           max  = pq.get(0);
	        }
	        
	        Collections.sort(pq);
	        if(pq.size()==0){
	            min = 0;
	        }else{
	           min  = pq.get(0);
	        }
	        
	        int[] answer = {max,min};
	        return answer;
	    }
	}
}
