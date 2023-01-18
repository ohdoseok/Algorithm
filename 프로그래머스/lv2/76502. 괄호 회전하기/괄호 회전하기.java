import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        //괄호를 옮길 큐
        Queue<Character> q = new LinkedList<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            q.offer(s.charAt(i));
        }
        //회전하는 수
        for(int i = 0 ; i < s.length() ; i++){
                //매번 검사를 하기위한 스택
            Stack<Character> stack = new Stack<>();
            for(int j = 0 ; j < s.length() ; j++){
                char val = q.poll();
                if(!stack.isEmpty()){
                    char stackTop = stack.peek();
                    if(val=='}'){
                        if(stackTop=='{'){
                            stack.pop();
                        }else{
                            stack.push(val);
                        }
                    }else if(val == ']'){
                        if(stackTop=='['){
                            stack.pop();
                        }else{
                            stack.push(val);
                        }
                    }else if(val == ')'){
                        if(stackTop=='('){
                            stack.pop();
                        }else{
                            stack.push(val);
                        }
                    }else{
                        stack.push(val);
                    }
                }else{
                    stack.push(val);
                }
                q.offer(val);
            }
            if(stack.isEmpty()){
               answer++; 
            }
            char top = q.poll();
            q.offer(top);
        }
        return answer;
    }
}