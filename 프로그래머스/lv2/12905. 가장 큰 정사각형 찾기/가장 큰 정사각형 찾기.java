import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;

        int[] dx = {-1,-1,0};
        int[] dy = {-1,0,-1};
        for(int i = 1 ; i < board.length ; i++){
            for(int j = 1 ; j < board[i].length ; j++){
                if(board[i][j]==0){
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int k = 0 ; k < 3 ; k++){
                    if(min>board[i+dx[k]][j+dy[k]]){
                        min = board[i+dx[k]][j+dy[k]];
                    }
                }
                board[i][j] = min+1;
            }
        }
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                answer = Math.max(answer,board[i][j]);
            }
        }
        return answer*answer;
    }
}