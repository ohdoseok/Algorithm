import java.util.*;
class Solution {
    public static boolean[] check;
    public static int result = 1;
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < clothes.length ; i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(String key : map.keySet()){
            //안 입는 경우의 수 하나 추가
            list.add(map.get(key)+1);
        }
        //모든 경우를 구한다
        for(int i = 0 ; i < list.size() ; i++){
           result*=list.get(i);
        }
        //모두 안입는 경우가 추가 되어있기에 제거
        return result-1;
    }
    
}