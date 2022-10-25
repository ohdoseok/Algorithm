
public class Programmers등굣길 {
	class Solution {
	    public int solution(int m, int n, int[][] puddles) {
	        int[][] res = new int[n][m];
	       
	        for(int i = 0 ; i < puddles.length ; i++){
	            res[puddles[i][1]-1][puddles[i][0]-1] = -1;
	        }
	        
	        res[0][0] = 1;
	        for(int i = 0 ; i < n; i++){
	            for(int j = 0 ; j < m ; j++){
	                if(res[i][j]==-1){
	                    res[i][j] = 0;
	                    continue;
	                }
	                if(!(i==0&&j==0)){
	                    int left = 0;
	                    int up = 0;

	                    if(i > 0){
	                        up = res[i-1][j];
	                    }
	                    if(j > 0){
	                        left = res[i][j-1];
	                    }
	                    res[i][j] = (up+left) %1000000007;
	                }
	                
	            }
	        }
	        int answer = res[n-1][m-1];
	        
	        
	        
	        return answer;
	    }
	}
}
