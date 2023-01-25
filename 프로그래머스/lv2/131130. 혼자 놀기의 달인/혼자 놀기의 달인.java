import java.util.*;
class Solution {
    public static boolean[] check;
    public int solution(int[] cards) {
        int answer = 1;
        check = new boolean[cards.length];
        List<Integer> group = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
            for(int i = 0 ; i < cards.length ; i++){
                if(check[i]){
                    continue;
                }
                q.offer(cards[i]);
                check[i] = true;
                int cnt = 1;
                while(!q.isEmpty()){
                    int idx = q.poll()-1;
                    
                    if(!check[idx]){
                        q.offer(cards[idx]);
                        check[idx] = true;
                        cnt++;
                    }
                }
                group.add(cnt);
            }
        Collections.sort(group, Collections.reverseOrder());
        if(group.size()!=1){
            for(int i = 0 ; i < 2 ; i++){
                answer*=group.get(i);
            }
        }else{
            answer = 0;
        }
        
        return answer;
    }
    
}