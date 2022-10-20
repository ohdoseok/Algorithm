import java.util.*;

public class Programmers베스트앨범 {
	public static void main(String[] args) {
	}
	class Solution {
	    public List<Integer> solution(String[] genres, int[] plays) {
	        List<Integer> result = new ArrayList<>();
	        
	        HashMap<String, Integer> array = new HashMap<>();
	        for(int i=0 ; i < genres.length ; i++){
	            if(array.get(genres[i]) == null){
	                array.put(genres[i],plays[i]);
	            }else{
	               array.put(genres[i],array.get(genres[i])+plays[i]); 
	            }
	        }
	        List<Map.Entry<String, Integer>> arrayList = new LinkedList<>(array.entrySet());
			arrayList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
	        
	        for(Map.Entry<String, Integer> entry : arrayList){
	            int first = Integer.MIN_VALUE;
	            int secend = Integer.MIN_VALUE;
	            int resF = Integer.MAX_VALUE;
	            int resS = Integer.MAX_VALUE;
	            String findS = entry.getKey();
	            for(int i = 0 ; i < genres.length ; i++){
	                if(findS.equals(genres[i])){
	                    if(first == plays[i]){
	                        if(resF > i){
	                            resS = resF;
	                            resF = i;
	                        }else{
	                            resS = i;
	                        }
	                        secend = first;
	                    }else if(first < plays[i]){
	                        secend = first;
	                        resS = resF;
	                        first = plays[i];
	                        resF = i;
	                    }else if(secend == plays[i]){
	                        if(resS > i){
	                            resS = i;
	                        }
	                    }else if(secend < plays[i]){
	                        resS = i;
	                        secend = plays[i];
	                    }
	                }
	            }
	            if(secend == Integer.MIN_VALUE){
	                result.add(resF);
	            }else{
	                result.add(resF);
	                result.add(resS);
	            }
	            
	            
	        }
	        return result;
	    }
	}
}
