import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < progresses.length ; i++){
            q.offer(progresses[i]);
        }
        int res = 0;
        int cnt = 0;
        int day = 0;
        while(!q.isEmpty()){
            int level = q.poll();
            if(level+speeds[cnt]*day >= 100){
                res++;
            }else{
                if(res!=0){
                    list.add(res);
                    res = 0;
                }
                int mok = (100-level)/speeds[cnt];
                int nam = (100-level)%speeds[cnt];
                if(nam != 0){
                    mok++;
                }
                day = mok;
                res++;
            }
            cnt++;
        }
        list.add(res);
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}