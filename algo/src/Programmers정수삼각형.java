import java.util.*;

public class Programmers정수삼각형 {
	public static void main(String[] args) {
	    
	}
	
	class Solution {
	    public int solution(int[][] triangle) {
	        for(int i = 1; i < triangle.length ; i++){
	            for(int j = 0; j < triangle[i].length ; j++){
	                //제일왼쪽
	                if(j==0){
	                    triangle[i][j] += triangle[i-1][j];
	                    //제일 오른쪽
	                }else if(j == triangle[i].length-1){
	                    triangle[i][j] += triangle[i-1][j-1];
	                }else{
	                    if(triangle[i][j]+triangle[i-1][j-1] > triangle[i][j] + triangle[i-1][j]){
	                        triangle[i][j]+=triangle[i-1][j-1];
	                    }else{
	                        triangle[i][j]+=triangle[i-1][j];
	                    }
	                }
	            }
	        }
	        int res = Integer.MIN_VALUE;
	        for(int i = 0 ; i < triangle[triangle.length-1].length ; i++){
	            if(res < triangle[triangle.length-1][i]){
	                res = triangle[triangle.length-1][i];
	            }
	        }
	        int answer;
	        answer = res;
	        
	        return answer;
	    }
	}
}
