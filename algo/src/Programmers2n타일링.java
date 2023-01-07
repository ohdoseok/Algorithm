
public class Programmers2n타일링 {
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        int x1 = 1;
	        int x2 = 2;
	        if(n == 1){
	            answer = x1;
	        }else{
	            for(int i = 2 ; i < n ; i++){
	                int tmp = x1;
	                x1 = x2;
	                x2 = (tmp+x2)%1000000007;
	            }
	        }
	        return x2;
	    }
	}
}
