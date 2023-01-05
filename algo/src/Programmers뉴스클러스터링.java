import java.util.*;
public class Programmers뉴스클러스터링 {
	class Solution {
	    public int solution(String str1, String str2) {
	        List<String> listA = new ArrayList<>();
	        List<String> listB = new ArrayList<>();
	        List<String> listSum = new ArrayList<>();
	        for(int i = 0 ; i < str1.length()-1; i++){
	            char A = Character.toLowerCase(str1.charAt(i));
	            char B = Character.toLowerCase(str1.charAt(i+1));
	            StringBuilder sb = new StringBuilder();
	            if(A>=97 && A <=122 && B>=97 && B <=122){
	                sb.append(A);
	                sb.append(B);
	                listA.add(sb.toString());
	            }
	        }
	        for(int i = 0 ; i < str2.length()-1; i++){
	            char A = Character.toLowerCase(str2.charAt(i));
	            char B = Character.toLowerCase(str2.charAt(i+1));
	            StringBuilder sb = new StringBuilder();
	            if(A>=97 && A <=122 && B>=97 && B <=122){
	                sb.append(A);
	                sb.append(B);
	                listB.add(sb.toString());
	            }
	        }
	        for(int i = listA.size()-1 ; i >= 0 ; i--){
	            String val = listA.get(i);
	            if(listB.contains(val)){
	                listA.remove(i);
	                for(int j = listB.size()-1 ; j >= 0  ; j--){
	                    if(val.equals(listB.get(j))){
	                        listB.remove(j);
	                        break;
	                    }
	                }
	                listSum.add(val);
	            }
	        }
	        int Al = listSum.size();
	        int All = listA.size()+listB.size()+listSum.size();
	        
	        double answer = (double)Al/(double)All;
	        if(Al == 0 && All == 0){
	            answer = (double)1;
	        }
	        int result = (int) Math.floor(answer*65536);
	        return result;
	    }
	}
}
