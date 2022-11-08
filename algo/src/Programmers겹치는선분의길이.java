import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Programmers겹치는선분의길이 {
	public static void main(String[] args) {
	}
	
	class Solution {
	    public int solution(int[][] lines) {
	        int answer=0;
	        int[] array = new int[201];
	        for(int[] A : lines){
	            for(int i = A[0]+100 ; i < A[1]+100 ; i++){
	                array[i]+=1;
	            }
	        }
	        for(int A : array){
	            if(A>1){
	                answer++;
	            }
	        }
	        return answer;
	    }
	}
}
