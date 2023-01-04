import java.util.*;
public class Programmers피로도 {
	
	class Solution {
	    public static int max = Integer.MIN_VALUE;
	    public static boolean[] check;
	    public int solution(int k, int[][] dungeons) {
	        check = new boolean[dungeons.length];
	        dfs(dungeons,k,0,0);
	        return max;
	    }
	    public static void dfs(int[][] dungeons, int life, int cnt, int result){
	        if(cnt == dungeons.length){
	            if(max < result){
	                max = result;
	            }
	            return;
	        }
	        for(int i = 0 ; i < dungeons.length ; i++){
	            if(check[i]){
	                continue;
	            }
	            if(dungeons[i][0] <= life){
	                check[i] = true;
	                dfs(dungeons,life-dungeons[i][1], cnt+1, result+1);
	                check[i] = false;
	            }else{
	                check[i] = true;
	                dfs(dungeons,life,cnt+1,result);
	                check[i] = false;
	            }
	        }
	    }
	}
}
