
import java.util.*;
public class Programmers프린터 {
	class Solution {
	    public static class Node{
	        int idx;
	        int val;
	        Node(int idx, int val){
	            this.idx = idx;
	            this.val = val;
	        }
	    }
	    public int solution(int[] priorities, int location) {
	        Queue<Node> q = new LinkedList<>();
	        int[] check = new int[10];
	        int max = Integer.MIN_VALUE;
	        int standard = priorities[location];
	        for(int i = 0 ; i < priorities.length ; i++){
	            check[priorities[i]]++;
	            if(max < priorities[i]){
	                max = priorities[i];
	            }
	            q.offer(new Node(i,priorities[i]));
	        }
	        int cnt = 0;
	        while(true){
	            Node node = q.poll();
	            if(node.val == max){
	                cnt++;
	                if(node.idx == location){
	                    break;
	                }
	                check[max]--;
	                if(check[max]==0){
	                    for(int i = max ; i > 0 ; i--){
	                        if(check[i]!=0){
	                            max = i;
	                            break;
	                        }
	                    }
	                }
	                
	            }else{
	                q.offer(node);
	            }
	        }
	        return cnt;
	    }
	}
}
