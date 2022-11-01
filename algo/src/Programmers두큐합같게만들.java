import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class Programmers두큐합같게만들 {
	public static void main(String[] args) {
	
	}
	
	class Solution {
	    public int solution(int[] queue1, int[] queue2) {
	        int maxleng = queue1.length*5;
	        long sum = 0;
	        
	        long sumq1 = 0;
	        long sumq2 = 0;
	        int res = 0;
	        Queue<Integer> q1 = new LinkedList<>();
	        Queue<Integer> q2 = new LinkedList<>();
	        for(int a : queue1){
	            q1.add(a);
	            sum+=a;
	            sumq1+=a;
	        }
	        for(int a : queue2){
	            q2.add(a);
	            sum+=a;
	            sumq2+=a;
	        }
	        long sumH = sum/2;
	        if(sum%2!=0){
	            return -1;
	        }
	        while(sumq1 != sumq2){
	            if(res > maxleng){
	                res = -1;
	                break;
	            }
	            if(sumq1 > sumH){
	                int top = q1.poll();
	                q2.offer(top);
	                sumq1-=top;
	                sumq2+=top;
	            }else if(sumq1 < sumH){
	                int top = q2.poll();
	                q1.offer(top);
	                sumq1+=top;
	                sumq2-=top;
	            }else{
	                break;
	            }
	            res++;
	        }
	        
	        return res;
	    }
	}
}
