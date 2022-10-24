
public class Programmers단어변환 {
	public static String[] words;
    public static boolean[] check;
    public static int result;
	public static void main(String[] args) {
	}
	class Solution {
	    
	    public int solution(String begin, String target, String[] word) {
	        words = word;
	        check = new boolean[word.length];
	        result = Integer.MAX_VALUE;
	        dfs(begin, target, 0);
	        if(result == Integer.MAX_VALUE){
	            result = 0;
	        }
	        return result;
	    }
	    
	}
	public static void dfs(String target, String Cor, int resCount){
        if(target.equals(Cor)){
            if(result > resCount){
                result = resCount;
            }
        }
        
        for(int i = 0 ; i < words.length ; i++){
            int count = 0;
            if(check[i]){
                continue;
            }
            for(int j = 0 ; j < target.length() ; j++){
                if(target.charAt(j) != words[i].charAt(j)){
                    count++;
                }
                if(count > 1){
                    break;
                }
            }
            if(count <= 1){
                check[i] = true;
                dfs(words[i], Cor, resCount+1);
                check[i] = false;
            }
        }
    }
}
