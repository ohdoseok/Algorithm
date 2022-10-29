import java.util.LinkedList;
import java.util.Queue;

public class Programmers모음사전 {
	public static char[] Array = {'A','E','I','O','U'};
    public static int answer = 0;
    public static String res = "";
	public static void main(String[] args) {
		
	}
	public static int go(String word) {
		for(int a = 0 ; a < 5 ; a++){
            res=Character.toString(Array[a]);
            answer++;
            if(res.equals(word)){
                return answer;
            }
            for(int b = 0 ; b < 5 ; b++){
                res = res.substring(0,1);
                res+=Array[b];
                answer++;
                 if(res.equals(word)){
                    return answer;
                }
                for(int c = 0 ; c < 5 ; c++){
                    res = res.substring(0,2);
                    res += Array[c];
                    answer++;
                     if(res.equals(word)){
                        return answer;
                    }
                    for(int d = 0 ; d < 5 ; d++){
                        res = res.substring(0,3);
                        res += Array[d];
                        answer++;
                         if(res.equals(word)){
                            return answer;
                        }
                        for(int e = 0 ; e < 5 ; e++){
                            res = res.substring(0,4);
                            res+=Array[e];
                            answer++;
                            if(res.equals(word)){
                                return answer;
                            }
                        }
                     }
                }
            }
        }
        return 0;
	}
	
}
