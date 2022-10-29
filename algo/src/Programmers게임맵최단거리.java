import java.util.*;

public class Programmers게임맵최단거리 {
	public static void main(String[] args) {
	}
	
	
	class Solution {
	    public int solution(int[][] maps) {
	        int[][] newmap = new int[maps.length][maps[0].length];
	        boolean rc = false;
	        Queue<int[]> q = new LinkedList<>();
	        int[] X = {1, 0, -1, 0};
	        int[] Y = {0, 1, 0, -1};
	        newmap[0][0]=1;
	        q.offer(new int[]{0,0});
	        while(!q.isEmpty()){
	                int[] A = q.poll();
	                int x = A[0];
	                int y = A[1];
	                for(int j = 0 ; j < 4 ; j++){
	                    if(x+X[j] < 0 || y+Y[j] < 0 || x+X[j] > maps.length-1 || y+Y[j] > maps[0].length-1){
	                        continue;
	                    }
	                    if(maps[x+X[j]][y+Y[j]]==1 && newmap[x+X[j]][y+Y[j]]==0){
	                        newmap[x+X[j]][y+Y[j]] = newmap[x][y]+1;
	                        q.offer(new int[]{x+X[j],y+Y[j]});
	                    }
	                }
	            
	                
	            
	            }
	        if(newmap[maps.length-1][maps[0].length-1] == 0){
	            return -1;
	        }
	         return newmap[maps.length-1][maps[0].length-1];
	        }
	       
	    }
}
