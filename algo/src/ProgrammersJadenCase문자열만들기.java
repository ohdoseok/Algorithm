import java.util.*;
public class ProgrammersJadenCase문자열만들기 {
	
	class Solution {
	    public String solution(String s) {
	        String[] array = s.toLowerCase().split("\\s");
	        String result = "";
	        for(String val : array){
	            String res;
	            if(val.length()>1){
	               res  = Character.toUpperCase(val.charAt(0))+val.substring(1);
	            }else{
	                res = val.toUpperCase();
	            }
	            result+=res+" ";
	        }
	        if(s.charAt(s.length()-1) == ' '){
	            result = result.substring(0,result.length()-1)+" ";
	        }else{
	            result = result.substring(0,result.length()-1);
	        }
	        return result;
	    }
	}
}
