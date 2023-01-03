import java.util.*;
public class Programmers스킬트리 {
	
	class Solution {
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        
	            for(String val : skill_trees){
	                int idx = 0;
	                boolean check = false;
	                exit:
	                for(int i= 0 ; i < val.length() ; i++){
	                    if(idx == skill.length()){
	                        break;
	                    }
	                    if(val.charAt(i)==skill.charAt(idx)){
	                        idx++;
	                    }else{
	                        for(int j = idx+1 ; j < skill.length() ; j++){
	                            if(val.charAt(i)==skill.charAt(j)){
	                                check = true;
	                                break exit;
	                            }
	                        }
	                    }
	                }
	                if(!check){
	                    answer++;
	                }
	        }
	        return answer;
	    }
	}
}
