
public class Programmers숫자의표현 {
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        for(int j = 1 ; j < n+1 ; j++ ){
	            int sum = 0;
	            for(int i = 0 ; i < n ; i++){
	                sum += (j+i);
	                if(sum > n){
	                    break;
	                }else if(sum == n){
	                    answer++;
	                    break;
	                }
	            }
	        }
	        
	        
	        return answer;
	    }
	}
}
