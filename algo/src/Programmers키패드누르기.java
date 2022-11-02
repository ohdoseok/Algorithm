import java.util.*;
public class Programmers키패드누르기 {
	public static void main(String[] args) {
		int[] a;
		a = new int[] {1,2};
		int[][] A = {{1,2},{2,4}};
	}
	class Solution {
	    public String solution(int[] numbers, String hand) {
	        String answer = "";
	        String[][] map = {{"1","4","7","*"},{"2","5","8","0"},{"3","6","9","#"}};
	        int[] cLeft = {0,3};
	        int[] cRight = {2,3};
	        for(int number : numbers){
	            String val = Integer.toString(number);
	            for(int i = 0 ; i < map.length ; i++){
	                for(int j = 0 ; j < map[i].length ; j++){
	                    if(val.equals(map[i][j])){
	                        if(i == 0){
	                            answer+='L';
	                            cLeft = new int[]{i , j};
	                        }else if(i == 2){
	                            answer+='R';
	                            cRight = new int[]{i , j};
	                        }else{
	                           int L = Math.abs(cLeft[0]-i)+Math.abs(cLeft[1]-j);
	                            int R = Math.abs(cRight[0]-i)+Math.abs(cRight[1]-j);
	                            if(L < R){
	                                answer+='L';
	                                cLeft = new int[]{i , j};
	                            }else if(L > R){
	                                answer+='R';
	                                cRight = new int[]{i , j};
	                            }else{
	                                if(hand.equals("right")){
	                                    answer+='R';
	                                    cRight = new int[]{i , j};
	                                }else{
	                                    answer+='L';
	                                    cLeft = new int[]{i , j};
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        
	        return answer;
	    }
	}
}
