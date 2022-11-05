import java.util.*;
public class Programmers올바른괄호 {
	public static void main(String[] args) {
		
	}
	
	class Solution {
	    boolean solution(String s) {
	        Queue<Character> q = new LinkedList<>();
	        for(int i = 0 ; i < s.length() ; i++){
	            if(s.charAt(i) == '('){
	                q.offer(s.charAt(i));
	            }else{
	                if(q.isEmpty()){
	                    return false;
	                }else{
	                    q.poll();
	                }
	            }
	        }
	        if(!q.isEmpty()){
	            return false;
	        }else{
	            return true;
	        }
	    }
	}
}
