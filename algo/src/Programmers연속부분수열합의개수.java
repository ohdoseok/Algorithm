import java.util.*;
public class Programmers연속부분수열합의개수 {
	class Solution {
	    public int solution(int[] elements) {
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i = 1 ; i < elements.length+1 ; i++){
	            for(int j = 0 ; j < elements.length ; j++){
	                int res = 0;
	                for(int k = 0 ; k < i ; k++){
	                    res += elements[(j+k)%elements.length];
	                }
	                set.add(res);
	            }
	        }
	        int answer = set.size();
	        return answer;
	    }
	}
}
