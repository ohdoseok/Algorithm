import java.util.*;
public class Programmers소수찾기 {
	class Solution {
	    public static boolean[] check;
	    public static List<Integer> list;
	    public int solution(String numbers) {
	        int answer = 0;
	        list = new ArrayList<>();
	        check = new boolean[numbers.length()];
	        dfs(numbers, 0, "");
	        Collections.sort(list);
	        for(int i = 0 ; i < list.size() ; i++){
	            int val = list.get(i);
	            if(val == 0 || val == 1){
	                continue;
	            }
	            boolean sosu = true;
	            for(int j = 2 ; j < val ; j++){
	                if(val%j == 0){
	                    sosu = false;
	                    break;
	                }
	            }
	            if(sosu){
	                answer++;
	            }
	        }
	        return answer;
	    }
	    public static void dfs(String numbers,int cnt, String val){
	        if(cnt>0){
	           int res = Integer.parseInt(val);
	            if(!list.contains(res)){
	                list.add(res);
	            } 
	            if(cnt == numbers.length()){
	            
	                return;
	            }
	        }
	        
	        for(int i = 0 ; i < numbers.length() ; i++){
	            if(check[i]){
	                continue;
	            }
	            check[i] = true;
	            dfs(numbers, cnt+1, val+numbers.charAt(i));
	            check[i] = false;
	        }
	    }
	}
}
