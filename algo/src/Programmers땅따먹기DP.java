import java.util.*;
public class Programmers땅따먹기DP {
	
	class Solution {
	    public static int max = Integer.MIN_VALUE;
	    int solution(int[][] land) {
	        for(int i = 1; i < land.length ; i++){
	            for(int j = 0 ; j < 4 ; j++){
	                int val = 0;
	                int idx = -1;
	                for(int k = 0 ; k < 4 ; k++){
	                    if(j==k){
	                        continue;
	                    }
	                    if(val < land[i-1][k]){
	                        val = land[i-1][k];
	                        idx = k;
	                    }
	                }
	                land[i][j] += land[i-1][idx];
	                
	            }
	        }
	        for(int i = 0 ; i < 4 ;i++){
	            if(max < land[land.length-1][i]){
	                max = land[land.length-1][i];
	            }
	        }
	        return max;
	    }
	}
}
