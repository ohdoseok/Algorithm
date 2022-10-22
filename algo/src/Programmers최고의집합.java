import java.util.*;
public class Programmers최고의집합 {
	
	class Solution {
	    public int[] solution(int n, int s) {
	        List<Integer> array = new ArrayList<>();
	        int[] A = new int[n];
	        boolean check = false;
	        int v = s/n;
	        int roll = s%n;
	        
	        if(v > 0){
	            for(int i = 0 ; i < n-roll ; i++){
	                // array.add(v);
	                A[i] = v;
	            }
	            // for(int i = 0 ; i < roll ; i++){
	            //     array.add(v+1);
	            // }
	            for(int i = n-roll ; i < n ; i++){
	                A[i] = v+1;
	            }
	            
	                         
	        }else{
	            A = new int[1];
	            // array.add(-1);
	            A[0] = -1;
	        }
	        
	        
	        return A;
	    }
	}
}
