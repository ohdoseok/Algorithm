
public class Programmers프렌즈블록 {
	import java.util.*;
	class Solution {
	    public int solution(int m, int n, String[] board) {
	        int res = 0;
	        char[][] map = new char[m][n];
	        for(int i = 0 ; i < board.length ; i++){
	            map[i] = board[i].toCharArray();
	        }
	        int[] dx = {0,1,1};
	        int[] dy = {1,1,0};
	        
	        while(true){
	            boolean check = false;
	            char[][] tmpMap = map.clone();
	            for(int i = 0 ; i < m ; i++){
	                for(int j = 0 ; j < n ; j++){
	                    char val = map[i][j];
	                    boolean ok = true;
	                    if(val=='Z'){
	                        continue;
	                    }
	                    for(int k = 0 ; k < 3 ; k++){
	                        if(i+dx[k]>=m || j+dy[k]>=n){
	                            ok = false;
	                            continue;
	                        }
	                        if(val != map[i+dx[k]][j+dy[k]]){
	                            ok = false;
	                            break;
	                        }
	                    }
	                    if(ok){
	                        check = true;
	                         for(int k = 0 ; k < 3 ; k++){
	                             tmpMap[i+dx[k]][j+dy[k]] = 'Z';
	                        }
	                    }
	                }
	            }
	            
	            map = tmpMap.clone();
	            if(!check){
	                break;
	            }
	            for(int j = 0 ; j < n ; j++){
	                for(int i = 1 ; i  < m ; i++){
	                    if(map[i][j]=='Z'){
	                        map[i][j] = map[i-1][j] ;
	                        map[i-1][j] = 'Z';
	                    }
	                }
	            }
	            
	        }
	        for(int i = 0 ; i < map.length ; i++){
	            for(int j = 0 ; j < map[i].length ; j++){
	                if(map[i][j]=='Z'){
	                    res++;
	                }
	            }
	        }
	        return res;
	}
	}
}
