import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char val = s.charAt(i);
            if(val == '('){
                stack.push(val);
            }else{
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }else{
                    stack.pop();
                }
            }
        }
        if(answer && stack.isEmpty()){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }
}