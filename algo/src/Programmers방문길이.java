import java.util.List;
import java.util.Scanner;

public class Programmers방문길이 {
	public static void main(String[] args) {
	}
	class Solution {
	    public int solution(String dirs) {
	        boolean[][][] check = new boolean[11][11][4];
	        //U D L R
	        int x = 5;
	        int y = 5;
	        int count = 0;
	        for(int i = 0 ; i < dirs.length() ; i++){
	            char First = dirs.charAt(i);
	            if(First == 'U'){
	                if(x > 0){
	                    if(!check[x-1][y][1] && !check[x][y][0]){
	                        count++;
	                    }
	                    check[x][y][0] = true;
	                    x-=1;
	                }else{
	                    continue;
	                }
	                
	            }else if(First == 'D'){
	                if(x < 10){
	                    if(!check[x+1][y][0] && !check[x][y][1]){
	                        count++;
	                    }
	                    check[x][y][1] = true;
	                    x+=1;
	                }else{
	                    continue;
	                }
	            }else if(First == 'L'){
	                if(y > 0){
	                    if(!check[x][y-1][3] && !check[x][y][2]){
	                        count++;
	                    }
	                    check[x][y][2] = true;
	                    y-=1;
	                }else{
	                    continue;
	                }
	                
	            }else{
	                if(y < 10){
	                    if(!check[x][y+1][2] && !check[x][y][3]){
	                        count++;
	                    }
	                    check[x][y][3] = true;
	                    y+=1;
	                }else{
	                    continue;
	                }
	            }
	        }
	        return count;
	    }
	}
}
