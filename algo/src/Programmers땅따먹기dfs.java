import java.util.*;
public class Programmers땅따먹기dfs {
	
	class Solution {
	    public static int max = Integer.MIN_VALUE;
	    int solution(int[][] land) {
	        dfs(land,0,0,-1);
	        
	        return max;
	    }
	    public static void dfs(int[][] land, int cnt , int res , int y){
	        if(cnt == land.length){
	            if(max < res){
	                max = res;
	            }
	            return;
	        }
	        int val = Integer.MIN_VALUE;
	        for(int i = 0 ; i < 4 ; i++){
	            if(val > land[cnt][i] || i==y){
	                continue;
	            }
	            val = land[cnt][i];
	            dfs(land,cnt+1,res+land[cnt][i],i);
	        }
	    }
	}
}
