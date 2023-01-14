import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder(s);
        boolean OK = true;
        for(int i = 0 ; i < s.length() ; i++){
            if(OK){
                if((int)s.charAt(i)>=96 && (int)s.charAt(i)<=122){
                    sb.setCharAt(i,Character.toUpperCase(s.charAt(i)));
                }
                OK = false;
            }else{
                sb.setCharAt(i,Character.toLowerCase(s.charAt(i)));
            }
            if(s.charAt(i) == ' '){
                    OK = true;
            }
            
        }
        answer = sb.toString();
        return answer;
    }
}