import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.*;
public class Programmers메뉴리뉴얼 {
	public static Map<String,Integer> list = new HashMap<>();
    public static boolean[] check;
    public static int[] maxCheck;
	public static void main(String[] args) {
		
	}
	
	class Solution {
	    
	    public List<String> solution(String[] orders, int[] course) {
	        List<String> answer = new ArrayList<>();
	        maxCheck = new int[course.length];
	        for(String resOri : orders){
	            
	            
	            for(int i = 0 ; i < course.length ; i++){
	                int inputInt = course[i];
	                char[] resOriSet = resOri.toCharArray();
	                Arrays.sort(resOriSet);
	                resOri = new String(resOriSet);
	                check = new boolean[resOri.length()];
	                dfs(resOri,inputInt,"",0,i,0);
	                
	            }
	            
	        }
	        for(int i = 0 ; i < maxCheck.length ; i++){
	            for(String key : list.keySet()){
	                if(key.length()==course[i]){
	                    if(maxCheck[i] > 1 && list.get(key)==maxCheck[i]){
	                        answer.add(key);
	                    }
	                }
	            }
	        }
	        Collections.sort(answer, new Comparator<String>(){
	            @Override
	            public int compare(String A, String B){
	                return A.compareTo(B);
	            }
	        });
	        return answer;
	    }
	    public static void dfs(String resOri, int countGoal, String res, int countNow, int index, int n){
	        if(countNow == countGoal){
	            char[] resOriSet = res.toCharArray();
	            Arrays.sort(resOriSet);
	            res = new String(resOriSet);
	            if(list.containsKey(res)){
	                list.put(res,list.get(res)+1);
	                if(list.get(res)>maxCheck[index]){
	                    maxCheck[index] = list.get(res);
	                }
	            }else{
	                list.put(res,1);
	            }
	        }
	        for(int i = n ; i < resOri.length() ; i++){
	            if(check[i]){
	                continue;
	            }
	            check[i] = true;
	            dfs(resOri, countGoal, res+resOri.charAt(i), countNow+1, index,i);
	            check[i] = false;
	        }
	    }
	}
}
