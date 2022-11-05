import java.util.*;
public class Programmers최솟값만들기 {
	
	class Solution
	{
	    public int solution(int []A, int []B)
	    {
	        Arrays.sort(A);
	        Arrays.sort(B);
	        int res = 0;
	        for(int i = 0; i < A.length ; i++){
	            res+=A[i]*B[A.length-1-i];
	        }
	        return res;
	    }
	}
}
