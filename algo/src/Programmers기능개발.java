import java.util.*;
public class Programmers기능개발 {
	
	class Solution {
	    public static List<Integer> list = new ArrayList<>();
	    public int[] solution(int[] progresses, int[] speeds) {
	        boolean[] check = new boolean[progresses.length];
	        dfs(0,0,progresses,speeds,check);
	        int[] answer = new int[list.size()];
	        for(int i = 0 ; i < list.size() ; i++){
	            answer[i] = list.get(i);
	        }
	        return answer;
	    }
	    public static void dfs(int day, int res, int[] progresses, int[] speeds, boolean[] check){
	        if(check[check.length-1]){
	            list.add(res);
	            return;
	        }
	        for(int i = 0 ; i < progresses.length ; i++){
	            if(check[i]){
	                continue;
	            }
	            if(progresses[i]+day*speeds[i]<100){
	                if(res>0){
	                    list.add(res);
	                    res = 0;
	                    dfs(day+1,res,progresses,speeds,check);
	                }else{
	                    dfs(day+1,res,progresses,speeds,check);
	                }
	            }else{
	                check[i] = true;
	                dfs(day,res+1,progresses,speeds,check);
	            }
	        }
	    }
	}
}
