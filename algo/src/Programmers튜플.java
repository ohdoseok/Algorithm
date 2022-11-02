import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.*;

public class Programmers튜플 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		String A = "";
		A.substring(0);
		
	}
	class Solution {
	    public List<Integer> solution(String s) {
	        List<String> list = new ArrayList<>();
	        List<Integer> result = new ArrayList<>();
	        s = s.substring(0,s.length()-1);
	        String[] array = s.split("}");
	        for(String A : array){
	            list.add(A.substring(2));
	        }
	        Collections.sort(list, new Comparator<String>(){
	           @Override
	            public int compare(String A, String B){
	                return A.length()-B.length();
	            }
	        });
	        for(String A : list){
	            if(A.length()>1){
	                String[] res = A.split(",");
	                for(String B : res){
	                    if(!result.contains(Integer.parseInt(B))){
	                        result.add(Integer.parseInt(B));
	                    }
	                }
	            }else{
	                result.add(Integer.parseInt(A));
	            }
	            
	        }
	        return result;
	    }
	}
}
