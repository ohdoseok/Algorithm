import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> now = new HashMap<>();
        
        for(int i = 0 ; i < 10 ; i++){
            now.put(discount[i], now.getOrDefault(discount[i],0)+1);
        }
        //0~10까지 값을 확인해서 회원가입을 해야하는 지 판단
        for(int i = 0 ; i < discount.length-9 ; i++){
            boolean OK = true;
            for(int j = 0 ; j < want.length ; j++){
                int discountNow = now.getOrDefault(want[j],0);
                if(number[j] > discountNow){
                    OK = false;
                    break;
                }
            }
            if(OK){
                answer += 1;
            }
            if(i+10>=discount.length){
                break;
            }
            now.put(discount[i],now.get(discount[i])-1);
            now.put(discount[i+10],now.getOrDefault(discount[i+10],0)+1);
            
        }
        return answer;
    }
}